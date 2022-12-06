package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.RestData;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.*;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.comment.*;
import com.hit.classservice.application.mapper.CommentMapper;
import com.hit.classservice.application.output.comment.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

  /**
   * @param lessonId Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API get list parent comment by Lesson")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the comment",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetParentCommentsByLessonOutput.class))
          }),
      @ApiResponse(responseCode = "500", description = "lessonId not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @GetMapping(UrlConstant.Comment.GET_PARENT_BY_LESSON)
  public ResponseEntity<?> getParentCommentsByLesson(
      @Parameter(required = true, name = "lessonId", description = "Id of lesson") @PathVariable Long lessonId) throws Exception {
    // Create input
    GetParentCommentsByLessonInput input = new GetParentCommentsByLessonInput(lessonId);
    // Get output
    GetParentCommentsByLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param lessonId Long
   * @param parentId Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API get list children comment by Lesson")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the comment",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetChildrenCommentsByLessonOutput.class))
          }),
      @ApiResponse(responseCode = "500", description = "lessonId or parentId not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @GetMapping(UrlConstant.Comment.GET_CHILDREN_BY_LESSON)
  public ResponseEntity<?> getChildrenCommentsByLesson(
      @Parameter(required = true, name = "lessonId", description = "Id of lesson") @PathVariable Long lessonId,
      @Parameter(required = true, name = "parentId", description = "Id of parent comment")
      @PathVariable Long parentId) throws Exception {
    // Create input
    GetChildrenCommentsByLessonInput input = new GetChildrenCommentsByLessonInput(lessonId, parentId);
    // Get output
    GetChildrenCommentsByLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter CreateParentCommentForLessonParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API create new comment by Lesson")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Create success",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = CreateParentCommentForLessonOutput.class))
          })
  })
  @PostMapping(UrlConstant.Comment.CREATE_PARENT_FOR_LESSON)
  public ResponseEntity<?> createParentCommentForLesson(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to create new comment")
      @Valid @RequestBody CreateParentCommentForLessonParameter parameter) throws Exception {
    // Create input
    CreateParentCommentForLessonInput input = commentMapper.toCreateParentCommentForLessonInput(parameter);
    // Get output
    CreateParentCommentForLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter CreateChildrenCommentForLessonParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API reply comment by Lesson")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Create success",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = CreateChildrenCommentForLessonOutput.class))
          })
  })
  @PostMapping(UrlConstant.Comment.CREATE_CHILDREN_FOR_LESSON)
  public ResponseEntity<?> createChildrenCommentForLesson(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to reply comment")
      @Valid @RequestBody CreateChildrenCommentForLessonParameter parameter) throws Exception {
    // Create input
    CreateChildrenCommentForLessonInput input = commentMapper.toCreateChildrenCommentForLessonInput(parameter);
    // Get output
    CreateChildrenCommentForLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter CreateParentCommentForLessonStudentParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API create new comment by Lesson Student")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Create success",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = CreateParentCommentForLessonStudentOutput.class))
          })
  })
  @PostMapping(UrlConstant.Comment.CREATE_PARENT_FOR_LESSON_STUDENT)
  public ResponseEntity<?> createParentCommentForLessonStudent(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to create new comment")
      @Valid @RequestBody CreateParentCommentForLessonStudentParameter parameter) throws Exception {
    // Create input
    CreateParentCommentForLessonStudentInput input =
        commentMapper.toCreateParentCommentForLessonStudentInput(parameter);
    // Get output
    CreateParentCommentForLessonStudentOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter CreateChildrenCommentForLessonStudentParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API reply comment by Lesson Student")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Create success",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = CreateChildrenCommentForLessonStudentOutput.class))
          })
  })
  @PostMapping(UrlConstant.Comment.CREATE_CHILDREN_FOR_LESSON_STUDENT)
  public ResponseEntity<?> createChildrenCommentForLessonStudent(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to reply comment")
      @Valid @RequestBody CreateChildrenCommentForLessonStudentParameter parameter) throws Exception {
    // Create input
    CreateChildrenCommentForLessonStudentInput input =
        commentMapper.toCreateChildrenCommentForLessonStudentInput(parameter);
    // Get output
    CreateChildrenCommentForLessonStudentOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter EditCommentParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API update comment")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Update success", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = EditCommentOutput.class))
      }),
      @ApiResponse(responseCode = "500", description = "Id not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @PutMapping(UrlConstant.Comment.EDIT)
  public ResponseEntity<?> editComment(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to update comment")
      @Valid @RequestBody EditCommentParameter parameter) throws Exception {
    // Create input
    EditCommentInput input = commentMapper.toEditCommentInput(parameter);
    // Get output
    EditCommentOutput output = useCaseBus.handle(input);

    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param id Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API delete comment")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Delete success", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = DeleteCommentOutput.class))
      }),
      @ApiResponse(responseCode = "500", description = "Id not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @DeleteMapping(UrlConstant.Comment.DELETE)
  public ResponseEntity<?> deleteComment(
      @Parameter(description = "Id of comment", required = true)
      @PathVariable("id") Long id) throws Exception {
    // Create input
    DeleteCommentInput input = new DeleteCommentInput(id);
    // Get output
    DeleteCommentOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}