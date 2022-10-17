package com.hit.classservice.application.interator.subject;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.subject.CreateSubjectInput;
import com.hit.classservice.application.input_boundary.subject.CreateSubjectDataCase;
import com.hit.classservice.application.output.subject.CreateSubjectOutput;
import com.hit.classservice.application.utils.FileUtil;
import com.hit.classservice.domain.entity.Subject;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateSubjectInteractor")
public class CreateSubjectInteractor implements CreateSubjectDataCase {

  private final SubjectRepository subjectRepository;
  private final FileUtil uploadFileUtil;

  public CreateSubjectInteractor(@Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository,
                                 FileUtil uploadFileUtil) {
    this.subjectRepository = subjectRepository;
    this.uploadFileUtil = uploadFileUtil;
  }

  @SneakyThrows
  @Override
  public CreateSubjectOutput handle(CreateSubjectInput input) {
    Subject oldSubject = subjectRepository.findByName(input.getName());
    if (ObjectUtils.isNotEmpty(oldSubject)) {
      return new CreateSubjectOutput(CommonConstant.FALSE, String.format(DevMessageConstant.Subject.DUPLICATE_NAME,
          input.getName()));
    }
    Subject subject = new Subject(input.getName(), this.uploadFileUtil.uploadFile(input.getFile()),
        input.getDescription(), input.getCategoryId());
    subjectRepository.save(subject);
    return new CreateSubjectOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }
}
