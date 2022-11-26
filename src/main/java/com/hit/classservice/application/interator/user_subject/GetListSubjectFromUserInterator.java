package com.hit.classservice.application.interator.user_subject;

import com.hit.classservice.application.dai.UserSubjectRelationRepository;
import com.hit.classservice.application.input.user_subject.GetListSubjectFromUserInput;
import com.hit.classservice.application.input_boundary.user_subject.GetListSubjectFromUserDataCase;
import com.hit.classservice.application.mapper.UserSubjectMapper;
import com.hit.classservice.application.output.user_subject.GetListSubjectFromUserOutput;
import com.hit.classservice.application.output.user_subject.GetSubjectFromUserItemOutput;
import com.hit.classservice.domain.entity.Subject;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("getAllSubjectFromUserInterator")
public class GetListSubjectFromUserInterator implements GetListSubjectFromUserDataCase {
  private final UserSubjectRelationRepository repository;
  private final UserSubjectMapper mapper;

  public GetListSubjectFromUserInterator(@Qualifier("DatabaseUserSubjectRelationRepository") UserSubjectRelationRepository repository) {
    this.repository = repository;
    this.mapper = Mappers.getMapper(UserSubjectMapper.class);
  }

  @SneakyThrows
  @Override
  public GetListSubjectFromUserOutput handle(GetListSubjectFromUserInput input) {
    List<Subject> subjects = repository.getListSubjectFromUserByUserId(input.getUserId());

    List<GetSubjectFromUserItemOutput> output = mapper.toGetListSubjectItemOutputs(subjects);

    return new GetListSubjectFromUserOutput(output);
  }

}
