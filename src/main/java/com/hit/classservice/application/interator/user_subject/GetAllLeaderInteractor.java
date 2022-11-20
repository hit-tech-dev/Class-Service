package com.hit.classservice.application.interator.user_subject;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.user_subject.GetAllLeaderInput;
import com.hit.classservice.application.input_boundary.user_subject.GetAllLeaderDataCase;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.user_subject.GetAllLeaderItemOutput;
import com.hit.classservice.application.output.user_subject.GetAllLeaderOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.domain.dto.UserDto;
import com.hit.classservice.domain.entity.Subject;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationGetAllLeaderInteractor")
public class GetAllLeaderInteractor implements GetAllLeaderDataCase {

  private final SubjectRepository subjectRepository;
  private final SubjectMapper subjectMapper;

  public GetAllLeaderInteractor(@Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository) {
    this.subjectRepository = subjectRepository;
    this.subjectMapper = Mappers.getMapper(SubjectMapper.class);
  }

  @Override
  public GetAllLeaderOutput handle(GetAllLeaderInput input) throws Exception {
    Subject oldSubject = subjectRepository.findById(input.getSubjectId());
    if(ObjectUtils.isEmpty(oldSubject)) {
      throw new NotFoundException(UserMessageConstant.Subject.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Subject.ERR_NOT_FOUND_BY_ID, input.getSubjectId()),
          new String[]{input.getSubjectId().toString()});
    }

    List<UserDto> userDtoList = subjectRepository.getAllLeader(input.getSubjectId());
    List<GetAllLeaderItemOutput> outputs = subjectMapper.toGetAllLeaderItemOutputs(userDtoList);
    
    return new GetAllLeaderOutput(outputs);
  }
}
