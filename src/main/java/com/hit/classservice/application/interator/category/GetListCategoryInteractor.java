package com.hit.classservice.application.interator.category;

import com.hit.classservice.application.dai.CategoryRepository;
import com.hit.classservice.application.input.category.GetListCategoryInput;
import com.hit.classservice.application.input_boundary.category.GetListCategoryDataCase;
import com.hit.classservice.application.mapper.CategoryMapper;
import com.hit.classservice.application.output.category.GetListCategoryItemOutput;
import com.hit.classservice.application.output.category.GetListCategoryOutput;
import com.hit.classservice.domain.entity.Category;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    List<Category> list = categoryRepository.findAll();

    List<GetListCategoryItemOutput> output = categoryMapper.toGetListCategoryItemOutputs(list);

    return new GetListCategoryOutput(output);
  }

}
