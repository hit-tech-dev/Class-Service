package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import org.springframework.beans.factory.annotation.Qualifier;

@RestApiV1
public class ClassController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;

  public ClassController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                         @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
  }

}
