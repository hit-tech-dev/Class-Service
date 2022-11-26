package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.common.PagingMetaParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.user_subject.GetListUserInSubjectParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.user_subject.RemoveUserFromSubjectParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.subject.GetListSubjectInput;
import com.hit.classservice.application.input.user_subject.GetListSubjectFromUserInput;
import com.hit.classservice.application.input.user_subject.RemoveUserFromSubjectInput;
import com.hit.classservice.application.mapper.UserSubjectMapper;
import com.hit.classservice.application.output.subject.GetListSubjectOutput;
import com.hit.classservice.application.output.user_subject.GetListSubjectFromUserOutput;
import com.hit.classservice.application.input.user_subject.GetListUserInSubjectInput;
import com.hit.classservice.application.input.user_subject.RemoveUserFromSubjectInput;
import com.hit.classservice.application.mapper.UserSubjectMapper;
import com.hit.classservice.application.output.user_subject.GetListUserInSubjectOutput;
import com.hit.classservice.application.output.user_subject.RemoveUserFromSubjectOutput;
import com.hit.classservice.application.utils.SecurityUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

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

  @GetMapping(UrlConstant.UserSubject.LIST)
  public ResponseEntity<?> getAllSubjectFromUser() throws Exception {

    // Get user_id
    String uuid = SecurityUtil.getCurrentUserLogin();
    // Create input
    GetListSubjectFromUserInput input = new GetListSubjectFromUserInput(uuid);
    // Get output
    GetListSubjectFromUserOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }
  @GetMapping(UrlConstant.UserSubject.LIST_USER)
  public ResponseEntity<?> getListUserBySubjectId(@Valid GetListUserInSubjectParameter parameter) throws Exception {
    GetListUserInSubjectInput input = userSubjectMapper.toGetListUserInSubjectInput(parameter);

    GetListUserInSubjectOutput output = useCaseBus.handle(input);

    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}
