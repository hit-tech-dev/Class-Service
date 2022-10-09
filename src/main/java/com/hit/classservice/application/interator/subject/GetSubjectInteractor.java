package com.hit.classservice.application.interator.subject;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.subject.GetSubjectInput;
import com.hit.classservice.application.input_boundary.subject.GetSubjectDatacase;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.subject.GetSubjectOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Subject;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationGetSubjectInteractor")
public class GetSubjectInteractor implements GetSubjectDatacase {
  private final SubjectRepository subjectRepository;

  private final SubjectMapper subjectMapper;

  public GetSubjectInteractor(@Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository) {
    this.subjectRepository = subjectRepository;
    this.subjectMapper = Mappers.getMapper(SubjectMapper.class);
  }

  public GetSubjectOutput handle(GetSubjectInput input) {
    Subject subject = subjectRepository.findById(input.getId());

    if (ObjectUtils.isEmpty(subject))
      throw new VsException(UserMessageConstant.Subject.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Subject.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    return subjectMapper.toGetSubjectOutput(subject);
  }

}
