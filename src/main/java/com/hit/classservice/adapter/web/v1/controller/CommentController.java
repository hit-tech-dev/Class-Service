package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateChildrenCommentForLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateChildrenCommentForLessonStudentParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateParentCommentForLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateParentCommentForLessonStudentParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.comment.*;
import com.hit.classservice.application.mapper.CommentMapper;
import com.hit.classservice.application.output.comment.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestApiV1
public class CommentController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;
  private final CommentMapper commentMapper;

  public CommentController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                           @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.commentMapper = Mappers.getMapper(CommentMapper.class);
  }

  //Comment of table Lesson
  @GetMapping(UrlConstant.Comment.GET_PARENT_BY_LESSON)
  public ResponseEntity<?> getParentCommentsByLesson(@PathVariable Long lessonId) throws Exception {
    // Create input
    GetParentCommentsByLessonInput input = new GetParentCommentsByLessonInput(lessonId);
    // Get output
    GetParentCommentsByLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @GetMapping(UrlConstant.Comment.GET_CHILDREN_BY_LESSON)
  public ResponseEntity<?> getChildrenCommentsByLesson(@PathVariable Long lessonId, @PathVariable Long parentId) throws Exception {
    // Create input
    GetChildrenCommentsByLessonInput input = new GetChildrenCommentsByLessonInput(lessonId, parentId);
    // Get output
    GetChildrenCommentsByLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @PostMapping(UrlConstant.Comment.CREATE_PARENT_FOR_LESSON)
  public ResponseEntity<?> createParentCommentForLesson(@Valid @RequestBody CreateParentCommentForLessonParameter parameter) throws Exception {
    // Create input
    CreateParentCommentForLessonInput input = commentMapper.toCreateParentCommentForLessonInput(parameter);
    // Get output
    CreateParentCommentForLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @PostMapping(UrlConstant.Comment.CREATE_CHILDREN_FOR_LESSON)
  public ResponseEntity<?> createChildrenCommentForLesson(@Valid @RequestBody CreateChildrenCommentForLessonParameter parameter) throws Exception {
    // Create input
    CreateChildrenCommentForLessonInput input = commentMapper.toCreateChildrenCommentForLessonInput(parameter);
    // Get output
    CreateChildrenCommentForLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  //Comment of table Lesson Student
  @PostMapping(UrlConstant.Comment.CREATE_PARENT_FOR_LESSON_STUDENT)
  public ResponseEntity<?> createParentCommentForLessonStudent(@Valid @RequestBody CreateParentCommentForLessonStudentParameter parameter) throws Exception {
    // Create input
    CreateParentCommentForLessonStudentInput input =
        commentMapper.toCreateParentCommentForLessonStudentInput(parameter);
    // Get output
    CreateParentCommentForLessonStudentOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @PostMapping(UrlConstant.Comment.CREATE_CHILDREN_FOR_LESSON_STUDENT)
  public ResponseEntity<?> createChildrenCommentForLessonStudent(@Valid @RequestBody CreateChildrenCommentForLessonStudentParameter parameter) throws Exception {
    // Create input
    CreateChildrenCommentForLessonStudentInput input =
        commentMapper.toCreateChildrenCommentForLessonStudentInput(parameter);
    // Get output
    CreateChildrenCommentForLessonStudentOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @DeleteMapping(UrlConstant.Comment.DELETE)
  public ResponseEntity<?> deleteComment(@PathVariable("id") Long id) throws Exception {
    // Create input
    DeleteCommentInput input = new DeleteCommentInput(id);
    // Get output
    DeleteCommentOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}
