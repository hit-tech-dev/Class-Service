package com.hit.classservice.application.interator.category;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.CategoryRepository;
import com.hit.classservice.application.input.category.DeleteCategoryInput;
import com.hit.classservice.application.input_boundary.category.DeleteCategoryDataCase;
import com.hit.classservice.application.output.category.DeleteCategoryOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Category;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("ApplicationDeleteCategoryInteractor")
public class DeleteCategoryInteractor implements DeleteCategoryDataCase {
  private final CategoryRepository categoryRepository;

  public DeleteCategoryInteractor(@Qualifier("DatabaseCategoryRepository") CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @SneakyThrows
  @Override
  public DeleteCategoryOutput handle(DeleteCategoryInput input) {
    // Find obj by id
    Category oldCategory = categoryRepository.findById(input.getId());
    if (ObjectUtils.isEmpty(oldCategory)) {
      throw new NotFoundException(UserMessageConstant.Category.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Category.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    }

    // Check category has relation with subject
    // Chờ có bảng subject thì code thêm vào đây để nếu có subject thì không được xóa

    // Delete obj
    categoryRepository.delete(input.getId());
    return null;
  }

}
