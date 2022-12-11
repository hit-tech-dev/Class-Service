package com.hit.classservice.application.interator.subject;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.subject.GetSubjectInput;
import com.hit.classservice.application.input_boundary.subject.GetSubjectDatacase;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.subject.GetSubjectOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.dto.ScheduleDto;
import com.hit.classservice.domain.dto.SubjectDto;
import com.hit.classservice.domain.entity.Subject;
import com.nimbusds.jose.shaded.json.JSONObject;
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
      throw new NotFoundException(UserMessageConstant.Subject.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Subject.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});

    GetSubjectOutput output = subjectMapper.toGetSubjectOutput(subject);

    output.setLeaders(subjectRepository.getAllLeader(input.getId()));
    JSONObject json = new JSONObject();
    json.put("avatar", subject.getAvatar());
    json.put("description", subject.getDescription());
    json.put("form", subject.getStudyForm());
    json.put("totalStudent", subjectRepository.countStudentSubject(input.getId()));

    ScheduleDto scheduleDto = subjectRepository.getTimeSubject(input.getId());
    json.put("time", scheduleDto.getTime());
    json.put("timeDetail", scheduleDto.getTimeDetail());
    json.put("address", subject.getStudyPlace());
    output.setDetail(json);

    return output;
  }

}
