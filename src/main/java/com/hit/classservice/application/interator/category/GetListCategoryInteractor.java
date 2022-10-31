package com.hit.classservice.application.interator.category;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.SortByDataConstant;
import com.hit.classservice.application.dai.CategoryRepository;
import com.hit.classservice.application.input.category.GetListCategoryInput;
import com.hit.classservice.application.input_boundary.category.GetListCategoryDataCase;
import com.hit.classservice.application.mapper.CategoryMapper;
import com.hit.classservice.application.output.category.GetListCategoryItemOutput;
import com.hit.classservice.application.output.category.GetListCategoryOutput;
import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.domain.dto.CategoryDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ApplicationGetListCategoryInterator")
public class GetListCategoryInteractor implements GetListCategoryDataCase {
  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;

  public GetListCategoryInteractor(@Qualifier("DatabaseCategoryRepository") CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
    this.categoryMapper = Mappers.getMapper(CategoryMapper.class);
  }

  @Override
  public GetListCategoryOutput handle(GetListCategoryInput input) {
    String keyword = input.getKeyword().trim();
    Long total = categoryRepository.countSearchCategory(keyword);

    PagingMeta meta = new PagingMeta(total, input.getPageNum(), input.getPageSize(),
        input.getSortBy(SortByDataConstant.CATEGORY), input.getSortType());

    if (total.equals(CommonConstant.ZERO_VALUE)) {
      return new GetListCategoryOutput(new ArrayList<>(), meta);
    }

    List<CategoryDto> lstCategory = categoryRepository.searchCategory(keyword, meta);

    List<GetListCategoryItemOutput> output = categoryMapper.toGetListCategoryItemOutputs(lstCategory);

    return new GetListCategoryOutput(output, meta);
  }

}
