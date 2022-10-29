package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.lesson_student.CreateLessonStudentParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.lesson_student.CreateLessonStudentInput;
import com.hit.classservice.application.mapper.LessonStudentMapper;
import com.hit.classservice.application.output.lesson_student.CreateLessonStudentOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

  /**
   * @param parameter CreateLessonStudentParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API create new lesson student")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Create success",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = CreateLessonStudentOutput.class))
          })
  })
  @PostMapping(UrlConstant.LessonStudent.CREATE)
  public ResponseEntity<?> createSubject(
      @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to create new lesson student")
      @Valid @RequestBody CreateLessonStudentParameter parameter) throws Exception {
    //Create input
    CreateLessonStudentInput input = lessonStudentMapper.toCreateLessonStudentInput(parameter);
    //Get output
    CreateLessonStudentOutput output = useCaseBus.handle(input);
    //Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}
