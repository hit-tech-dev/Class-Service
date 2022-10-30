package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.RestData;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.subject.CreateSubjectParam;
import com.hit.classservice.adapter.web.v1.transfer.parameter.subject.UpdateSubjectParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.subject.*;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.subject.*;
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

  /**
   * @return ResponseEntity<?>
   */
  @Operation(summary = "Api get list subject")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the subjects",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetListSubjectOutput.class))})
  })
  @GetMapping(UrlConstant.Subject.LIST)
  public ResponseEntity<?> getAllSubject() throws Exception {
    // Create input
    GetListSubjectInput input = new GetListSubjectInput();
    // Get output
    GetListSubjectOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param id Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API get subject by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the subject",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetSubjectOutput.class))
      }),
      @ApiResponse(responseCode = "500", description = "Id not exits", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @GetMapping(UrlConstant.Subject.GET)
  public ResponseEntity<?> getSubjectById(@Parameter(required = true , name = "id",description = "Id of subject")
                                          @PathVariable("id") Long id) throws Exception {
    // Create input
    GetSubjectInput input = new GetSubjectInput(id);
    // Get output
    GetSubjectOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter UpdateSubjectParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API update subject by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Update success", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = UpdateSubjectOutput.class))
      }),
      @ApiResponse(responseCode = "500", description = "Id subject not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @PatchMapping(UrlConstant.Subject.UPDATE)
  public ResponseEntity<?> updateSubject(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to update subject")
                                         @Valid @RequestBody UpdateSubjectParameter parameter) throws Exception {
    // Create input
    UpdateSubjectInput input = subjectMapper.toUpdateSubjectInput(parameter);
    // Get output
    UpdateSubjectOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param id Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API delete subject")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Delete success", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = DeleteSubjectOutput.class))
      }),
      @ApiResponse(responseCode = "500", description = "Id subject not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @DeleteMapping(UrlConstant.Subject.DELETE)
  public ResponseEntity<?> deleteSubject(@Parameter(description = "Id of subject", required = true)
                                         @PathVariable(name = "id") Long id) throws Exception {
    //Create input
    DeleteSubjectInput input = new DeleteSubjectInput(id);
    // Get output
    DeleteSubjectOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter CreateSubjectParam
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API create new subject")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Create subject success", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = CreateSubjectOutput.class))
      })
  })
  @PostMapping(UrlConstant.Subject.CREATE)
  public ResponseEntity<?> createSubject(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to create new subject")
                                         @ModelAttribute CreateSubjectParam createSubjectParam) throws Exception {
    //Create input
    CreateSubjectInput input = subjectMapper.toCreateSubjectInput(createSubjectParam);
    //Get output
    CreateSubjectOutput output = useCaseBus.handle(input);
    //Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);

  }

}
