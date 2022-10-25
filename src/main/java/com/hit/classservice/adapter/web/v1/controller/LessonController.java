package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.lesson.CreateLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.lesson.UpdateLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.lesson.*;
import com.hit.classservice.application.mapper.LessonMapper;
import com.hit.classservice.application.output.lesson.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestApiV1
public class LessonController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;
  private final LessonMapper lessonMapper;

  public LessonController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                          @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.lessonMapper = Mappers.getMapper(LessonMapper.class);
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

  @PutMapping(UrlConstant.Lesson.UPDATE)
  public ResponseEntity<?> updateLesson(@Valid @RequestBody UpdateLessonParameter parameter) throws Exception {
    // Create input
    UpdateLessonInput input = lessonMapper.toUpdateLessonInput(parameter);
    // Get output
    UpdateLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @PostMapping(UrlConstant.Lesson.CREATE)
  public ResponseEntity<?> createSubject(@Valid @RequestBody CreateLessonParameter parameter) throws Exception {
    //Create input
    CreateLessonInput input = lessonMapper.toCreateLessonInput(parameter);
    //Get output
    CreateLessonOutput output = useCaseBus.handle(input);
    //Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * API get road map by subject id
   *
   * @param subjectId Long
   * @return ResponseEntity<?>
   */
  @GetMapping(UrlConstant.Lesson.LIST_LESSON_DETAIL)
  public ResponseEntity<?> getListLessonDetailBySubjectId(@PathVariable(name = "subjectId") Long subjectId) throws Exception {
    //Create input
    GetListLessonDetailBySubjectIdInput input = new GetListLessonDetailBySubjectIdInput(subjectId);
    //Get output
    GetListLessonDetailOutput output = useCaseBus.handle(input);
    //return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @DeleteMapping(UrlConstant.Lesson.DELETE)
  public ResponseEntity<?> deleteLessonById(@PathVariable("id") Long id) throws Exception {
    // Create input
    DeleteLessonInput input = new DeleteLessonInput(id);
    // Get output
    DeleteLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}
