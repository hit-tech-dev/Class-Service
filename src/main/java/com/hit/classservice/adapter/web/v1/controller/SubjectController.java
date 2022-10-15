package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.subject.CreateSubjectParam;
import com.hit.classservice.adapter.web.v1.transfer.parameter.subject.UpdateSubjectParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.subject.*;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.subject.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestApiV1
public class SubjectController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;
  private final SubjectMapper subjectMapper;

  public SubjectController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                           @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.subjectMapper = Mappers.getMapper(SubjectMapper.class);
  }

  @GetMapping(UrlConstant.Subject.LIST)
  public ResponseEntity<?> getAllSubject() throws Exception {
    // Create input
    GetListSubjectInput input = new GetListSubjectInput();
    // Get output
    GetListSubjectOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @GetMapping(UrlConstant.Subject.GET)
  public ResponseEntity<?> getSubjectById(@PathVariable("id") Long id) throws Exception {
    // Create input
    GetSubjectInput input = new GetSubjectInput(id);
    // Get output
    GetSubjectOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @PatchMapping(UrlConstant.Subject.UPDATE)
  public ResponseEntity<?> updateSubject(@Valid @RequestBody UpdateSubjectParameter parameter) throws Exception {
    // Create input
    UpdateSubjectInput input = subjectMapper.toUpdateSubjectInput(parameter);
    // Get output
    UpdateSubjectOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @DeleteMapping(UrlConstant.Subject.DELETE)
  public ResponseEntity<?> deleteSubject(@PathVariable(name = "id") Long id) throws Exception {
    //Create input
    DeleteSubjectInput input = new DeleteSubjectInput(id);
    // Get output
    DeleteSubjectOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @PostMapping(UrlConstant.Subject.CREATE)
  public ResponseEntity<?> createSubject(@Valid @RequestBody CreateSubjectParam createSubjectParam) throws Exception {
    //Create input
    CreateSubjectInput input = subjectMapper.toCreateSubjectInput(createSubjectParam);
    //Get output
    CreateSubjectOutput output = useCaseBus.handle(input);
    //Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader() , output);

  }

}
