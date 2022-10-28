package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.RestData;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.lesson.CreateLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.lesson.UpdateLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.lesson.*;
import com.hit.classservice.application.mapper.LessonMapper;
import com.hit.classservice.application.output.category.CreateCategoryOutput;
import com.hit.classservice.application.output.category.DeleteCategoryOutput;
import com.hit.classservice.application.output.category.GetCategoryOutput;
import com.hit.classservice.application.output.category.UpdateCategoryOutput;
import com.hit.classservice.application.output.lesson.*;
import io.swagger.v3.oas.annotations.Operation;
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

  /**
   *
   * @param subjectId
   * @return
   * @throws Exception
   */
  @Operation(summary = "API get list lessons by subject id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found list lessons by subject id successfully",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetListLessonBySubjectIdOutput.class))
          }),
      @ApiResponse(responseCode = "500", description = "Subject Id is not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @GetMapping(UrlConstant.Lesson.GET_LESSON_BY_SUBJECT)
  public ResponseEntity<?> getListLessonBySubjectId(@PathVariable(name = "subjectId") Long subjectId) throws Exception {
    // Create input
    GetListLessonBySubjectIdInput input = new GetListLessonBySubjectIdInput(subjectId);
    // Get output
    GetListLessonBySubjectIdOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   *
   * @param parameter
   * @return
   * @throws Exception
   */
  @Operation(summary = "API update lesson uses parameter")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Update successfully", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = UpdateLessonOutput.class))
      }),
      @ApiResponse(responseCode = "500", description = "Update failed", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @PutMapping(UrlConstant.Lesson.UPDATE)
  public ResponseEntity<?> updateLesson(@Valid @RequestBody UpdateLessonParameter parameter) throws Exception {
    // Create input
    UpdateLessonInput input = lessonMapper.toUpdateLessonInput(parameter);
    // Get output
    UpdateLessonOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   *
   * @param parameter
   * @return
   * @throws Exception
   */
  @Operation(summary = "API create new lesson")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Create successfully",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = CreateLessonOutput.class))
          })
  })
  @PostMapping(UrlConstant.Lesson.CREATE)
  public ResponseEntity<?> createLesson(@Valid @RequestBody CreateLessonParameter parameter) throws Exception {
    //Create input
    CreateLessonInput input = lessonMapper.toCreateLessonInput(parameter);
    //Get output
    CreateLessonOutput output = useCaseBus.handle(input);
    //Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   *
   * @param subjectId
   * @return
   * @throws Exception
   */
  @Operation(summary = "API get all information of list lessons detail by subject id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found list lessons detail by subject id successfully",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetListLessonDetailOutput.class))
          }),
      @ApiResponse(responseCode = "500", description = "Subject Id is not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @GetMapping(UrlConstant.Lesson.LIST_LESSON_DETAIL)
  public ResponseEntity<?> getListLessonDetailBySubjectId(@PathVariable(name = "subjectId") Long subjectId) throws Exception {
    //Create input
    GetListLessonDetailBySubjectIdInput input = new GetListLessonDetailBySubjectIdInput(subjectId);
    //Get output
    GetListLessonDetailOutput output = useCaseBus.handle(input);
    //return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   *
   * @param id
   * @return
   * @throws Exception
   */
  @Operation(summary = "API delete lesson by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Deleted successfully", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = DeleteLessonOutput.class))
      }),
      @ApiResponse(responseCode = "500", description = "Id not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
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
