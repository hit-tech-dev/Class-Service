package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.user_subject.GetListUserInSubjectParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.user_subject.RemoveUserFromSubjectParameter;
import com.hit.classservice.application.input.user_subject.GetListUserInSubjectInput;
import com.hit.classservice.application.input.user_subject.RemoveUserFromSubjectInput;
import com.hit.classservice.application.output.user_subject.GetListUserInSubjectItemOutput;
import com.hit.classservice.application.output.user_subject.GetSubjectFromUserItemOutput;
import com.hit.classservice.domain.dto.UserInSubjectDto;
import com.hit.classservice.domain.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserSubjectMapper {

  RemoveUserFromSubjectInput toDeleteUserFromSubjectInput(RemoveUserFromSubjectParameter parameter);

  List<GetSubjectFromUserItemOutput> toGetListSubjectItemOutputs(List<Subject> subjects);

  @Mappings({
      @Mapping(target = "id", source = "subject.id"),
      @Mapping(target = "name", source = "subject.name"),
      @Mapping(target = "avatar", source = "subject.avatar"),
      @Mapping(target = "description", source = "subject.description")
  })
  GetSubjectFromUserItemOutput toGetSubjectFromUserItemOutput(Subject subject);

  GetListUserInSubjectInput toGetListUserInSubjectInput(GetListUserInSubjectParameter parameter);

  List<GetListUserInSubjectItemOutput> toGetListUserInSubjectItemOutputs(List<UserInSubjectDto> userInSubjectDtos);
}
