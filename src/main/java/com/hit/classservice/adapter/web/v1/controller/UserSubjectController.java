package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.user_subject.RemoveUserFromSubjectParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.user_subject.RemoveUserFromSubjectInput;
import com.hit.classservice.application.mapper.UserSubjectMapper;
import com.hit.classservice.application.output.user_subject.RemoveUserFromSubjectOutput;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestApiV1
public class UserSubjectController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;
  private final UserSubjectMapper userSubjectMapper;

  public UserSubjectController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                               @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.userSubjectMapper = Mappers.getMapper(UserSubjectMapper.class);
  }

  @DeleteMapping(UrlConstant.UserSubject.DELETE)
  public ResponseEntity<?> removeUserFromSubject(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to remove user form subject")
                                                 @RequestBody RemoveUserFromSubjectParameter removeUserFromSubjectParameter) throws Exception {
    RemoveUserFromSubjectInput input = userSubjectMapper.toDeleteUserFromSubjectInput(removeUserFromSubjectParameter);

    RemoveUserFromSubjectOutput output = useCaseBus.handle(input);

    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}