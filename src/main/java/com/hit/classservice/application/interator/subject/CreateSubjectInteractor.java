package com.hit.classservice.application.interator.subject;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.CategoryRepository;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.subject.CreateSubjectInput;
import com.hit.classservice.application.input_boundary.subject.CreateSubjectDataCase;
import com.hit.classservice.application.output.subject.CreateSubjectOutput;
import com.hit.classservice.application.utils.FileUtil;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.domain.entity.Category;
import com.hit.classservice.domain.entity.Subject;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateSubjectInteractor")
public class CreateSubjectInteractor implements CreateSubjectDataCase {
  private final SubjectRepository subjectRepository;
  private final CategoryRepository categoryRepository;

  public CreateSubjectInteractor(@Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository,
                                 @Qualifier("DatabaseCategoryRepository") CategoryRepository categoryRepository) {
    this.subjectRepository = subjectRepository;
    this.categoryRepository = categoryRepository;
  }

  @SneakyThrows
  @Override
  public CreateSubjectOutput handle(CreateSubjectInput input) {
    Category oldCategory = categoryRepository.findById(input.getCategoryId());
    if (ObjectUtils.isEmpty(oldCategory)) {
      throw new NotFoundException(UserMessageConstant.Category.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Category.ERR_NOT_FOUND_BY_ID, input.getCategoryId()),
          new String[]{input.getCategoryId().toString()});
    }
    Subject oldSubject = subjectRepository.findByName(input.getName());
    if (ObjectUtils.isNotEmpty(oldSubject)) {
      return new CreateSubjectOutput(CommonConstant.FALSE, String.format(DevMessageConstant.Subject.DUPLICATE_NAME,
          input.getName()));
    }
    Subject subject = new Subject(input.getName(), FileUtil.uploadFile(input.getFile()),
        input.getDescription(), input.getCategoryId());
    subjectRepository.save(subject);
    return new CreateSubjectOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }

}
