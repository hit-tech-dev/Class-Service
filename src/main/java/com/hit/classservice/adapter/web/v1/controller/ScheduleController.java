package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.schedule.UpdateScheduleParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.schedule.GetListScheduleInput;
import com.hit.classservice.application.input.schedule.GetScheduleByIdInput;
import com.hit.classservice.application.input.schedule.UpdateScheduleInput;
import com.hit.classservice.application.mapper.ScheduleMapper;
import com.hit.classservice.application.output.schedule.GetListScheduleOutput;
import com.hit.classservice.application.output.schedule.GetScheduleByIdOutput;
import com.hit.classservice.application.output.schedule.UpdateScheduleOutput;
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
                            @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader, ScheduleMapper scheduleMapper) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.scheduleMapper = scheduleMapper;
  }

  @GetMapping(UrlConstant.Schedule.GET)
  public ResponseEntity<?> getScheduleById(@PathVariable("id") Long id) throws Exception {
    // Create input
    GetScheduleByIdInput input = new GetScheduleByIdInput(id);
    // Get output
    GetScheduleByIdOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @PutMapping(UrlConstant.Schedule.UPDATE)
  public ResponseEntity<?> updateScheduleById(@Valid @RequestBody UpdateScheduleParameter parameter) throws Exception {
    UpdateScheduleInput input = scheduleMapper.toUpdateScheduleInput(parameter);

    UpdateScheduleOutput output = useCaseBus.handle(input);

    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

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