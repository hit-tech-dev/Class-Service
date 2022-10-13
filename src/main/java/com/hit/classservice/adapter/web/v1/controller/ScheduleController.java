package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.schedule.GetScheduleByIdInput;
import com.hit.classservice.application.output.schedule.GetScheduleByIdOutput;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestApiV1
public class ScheduleController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;

  public ScheduleController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                            @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
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

}
