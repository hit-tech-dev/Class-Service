package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.user_subject.RemoveUserFromSubjectParameter;
import com.hit.classservice.application.input.user_subject.RemoveUserFromSubjectInput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserSubjectMapper {

  RemoveUserFromSubjectInput toDeleteUserFromSubjectInput(RemoveUserFromSubjectParameter removeUserFromSubjectParameter);

}
