package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.lesson_student.CreateLessonStudentParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.lesson_student.CreateLessonStudentInput;
import com.hit.classservice.application.mapper.LessonStudentMapper;
import com.hit.classservice.application.output.lesson_student.CreateLessonStudentOutput;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestApiV1
public class LessonStudentController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;
  private final LessonStudentMapper lessonStudentMapper;

  public LessonStudentController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                                 @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.lessonStudentMapper = Mappers.getMapper(LessonStudentMapper.class);
  }

  @PostMapping(UrlConstant.LessonStudent.CREATE)
  public ResponseEntity<?> createSubject(@Valid @RequestBody CreateLessonStudentParameter parameter) throws Exception {
    //Create input
    CreateLessonStudentInput input = lessonStudentMapper.toCreateLessonStudentInput(parameter);
    //Get output
    CreateLessonStudentOutput output = useCaseBus.handle(input);
    //Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}
