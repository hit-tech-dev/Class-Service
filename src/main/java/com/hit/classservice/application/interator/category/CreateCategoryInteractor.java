package com.hit.classservice.application.interator.category;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.dai.CategoryRepository;
import com.hit.classservice.application.input.category.CreateCategoryInput;
import com.hit.classservice.application.input_boundary.category.CreateCategoryDataCase;
import com.hit.classservice.application.output.category.CreateCategoryOutput;
import com.hit.classservice.domain.entity.Category;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateCategoryInteractor")
public class CreateCategoryInteractor implements CreateCategoryDataCase {
  private final CategoryRepository categoryRepository;

  public CreateCategoryInteractor(@Qualifier("DatabaseCategoryRepository") CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @SneakyThrows
  @Override
  public CreateCategoryOutput handle(CreateCategoryInput input) {
    // Check name exist
    boolean nameExist = categoryRepository.checkNameExist(input.getName());
    if (nameExist) {
      return new CreateCategoryOutput(CommonConstant.FALSE, String.format(DevMessageConstant.Category.NAME_IS_EXIST,
          input.getName()));
    }

    // Insert category when name is not exist
    Category category = new Category(input.getName(), input.getDescription());
    categoryRepository.save(category);

    return new CreateCategoryOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }

}
