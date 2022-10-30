package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.RestData;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.schedule.UpdateScheduleParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.schedule.GetListScheduleInput;
import com.hit.classservice.application.input.schedule.GetScheduleByIdInput;
import com.hit.classservice.application.input.schedule.UpdateScheduleInput;
import com.hit.classservice.application.mapper.ScheduleMapper;
import com.hit.classservice.application.output.schedule.GetListScheduleOutput;
import com.hit.classservice.application.output.schedule.GetScheduleByIdOutput;
import com.hit.classservice.application.output.schedule.UpdateScheduleOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestApiV1
public class ScheduleController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;
  private final ScheduleMapper scheduleMapper;

  public ScheduleController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                            @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.scheduleMapper = Mappers.getMapper(ScheduleMapper.class);
  }

  /**
   * @param id Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API get schedule by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the schedule",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetScheduleByIdOutput.class))
          }),
      @ApiResponse(responseCode = "500", description = "Id not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @GetMapping(UrlConstant.Schedule.GET)
  public ResponseEntity<?> getScheduleById(@Parameter(required = true, name = "id", description = "Id of schedule")
                                             @PathVariable("id") Long id) throws Exception {
    // Create input
    GetScheduleByIdInput input = new GetScheduleByIdInput(id);
    // Get output
    GetScheduleByIdOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter UpdateScheduleParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API update schedule")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Update success", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = UpdateScheduleOutput.class))
      }),
      @ApiResponse(responseCode = "500", description = "Id not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @PutMapping(UrlConstant.Schedule.UPDATE)
  public ResponseEntity<?> updateScheduleById( @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Body of request to update schedule")
                                                @Valid @RequestBody UpdateScheduleParameter parameter) throws Exception {
    UpdateScheduleInput input = scheduleMapper.toUpdateScheduleInput(parameter);

    UpdateScheduleOutput output = useCaseBus.handle(input);

    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API get list schedule")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the schedule",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetListScheduleOutput.class))})
  })
  @GetMapping(UrlConstant.Schedule.LIST)
  public ResponseEntity<?> getAllSchedule() throws Exception {
    // Create input
    GetListScheduleInput input = new GetListScheduleInput();
    // Get output
    GetListScheduleOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}