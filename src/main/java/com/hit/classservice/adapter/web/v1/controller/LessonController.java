package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.lesson.GetListLessonBySubjectIdInput;
import com.hit.classservice.application.input.subject.GetListSubjectInput;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.lesson.GetListLessonBySubjectIdOutput;
import com.hit.classservice.application.output.subject.GetListSubjectOutput;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestApiV1
public class LessonController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;
  private final SubjectMapper subjectMapper;

  public LessonController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                          @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.subjectMapper = Mappers.getMapper(SubjectMapper.class);
  }

  @GetMapping(UrlConstant.Lesson.GET_LESSON_BY_SUBJECT)
  public ResponseEntity<?> getListLessonBySubjectId(@PathVariable(name = "subjectId") Long subjectId) throws Exception {
    // Create input
    GetListLessonBySubjectIdInput input = new GetListLessonBySubjectIdInput(subjectId);
    // Get output
    GetListLessonBySubjectIdOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}
