package com.hit.classservice.application.interator.category;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.CategoryRepository;
import com.hit.classservice.application.input.category.UpdateCategoryInput;
import com.hit.classservice.application.input_boundary.category.UpdateCategoryDataCase;
import com.hit.classservice.application.output.category.UpdateCategoryOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Category;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationUpdateCategoryInteractor")
public class UpdateCategoryInteractor implements UpdateCategoryDataCase {
  private final CategoryRepository categoryRepository;

  public UpdateCategoryInteractor(@Qualifier("DatabaseCategoryRepository") CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @SneakyThrows
  @Override
  public UpdateCategoryOutput handle(UpdateCategoryInput input) {
    // Find obj by id
    Category oldCategory = categoryRepository.findById(input.getId());
    if (ObjectUtils.isEmpty(oldCategory)) {
      throw new NotFoundException(UserMessageConstant.Category.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Category.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    }

    // Check name unique
    Category oldCategoryByName = categoryRepository.findByName(input.getName());
    if (ObjectUtils.isNotEmpty(oldCategoryByName) && !input.getId().equals(oldCategoryByName.getId())) {
      return new UpdateCategoryOutput(CommonConstant.FALSE,
          String.format(DevMessageConstant.Category.DUPLICATE_NAME, input.getName()));
    }

    oldCategory.setName(input.getName());
    oldCategory.setDescription(input.getDescription());
    categoryRepository.update(oldCategory);
    return new UpdateCategoryOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }

}
