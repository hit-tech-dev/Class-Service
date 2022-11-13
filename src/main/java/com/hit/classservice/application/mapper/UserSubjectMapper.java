package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.user_subject.GetListUserInSubjectParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.user_subject.RemoveUserFromSubjectParameter;
import com.hit.classservice.application.input.user_subject.GetListUserInSubjectInput;
import com.hit.classservice.application.input.user_subject.RemoveUserFromSubjectInput;
import com.hit.classservice.application.output.user_subject.GetListUserInSubjectItemOutput;
import com.hit.classservice.domain.dto.UserInSubjectDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserSubjectMapper {

  RemoveUserFromSubjectInput toDeleteUserFromSubjectInput(RemoveUserFromSubjectParameter parameter);

  GetListUserInSubjectInput toGetListUserInSubjectInput(GetListUserInSubjectParameter parameter);

  List<GetListUserInSubjectItemOutput> toGetListUserInSubjectItemOutputs(List<UserInSubjectDto> userInSubjectDtos);
}
