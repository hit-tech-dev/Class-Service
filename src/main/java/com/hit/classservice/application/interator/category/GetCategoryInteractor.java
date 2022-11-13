package com.hit.classservice.application.interator.category;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.CategoryRepository;
import com.hit.classservice.application.input.category.GetCategoryInput;
import com.hit.classservice.application.input_boundary.category.GetCategoryDataCase;
import com.hit.classservice.application.mapper.CategoryMapper;
import com.hit.classservice.application.output.category.GetCategoryOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Category;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationGetCategoryInteractor")
public class GetCategoryInteractor implements GetCategoryDataCase {
  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;

  public GetCategoryInteractor(@Qualifier("DatabaseCategoryRepository") CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
    this.categoryMapper = Mappers.getMapper(CategoryMapper.class);
  }

  @SneakyThrows
  @Override
  public GetCategoryOutput handle(GetCategoryInput input) {
    Category category = categoryRepository.findById(input.getId());

    if (ObjectUtils.isEmpty(category)) {
      throw new NotFoundException(UserMessageConstant.Category.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Category.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    }

    return categoryMapper.toGetCategoryOutput(category);
  }

}
