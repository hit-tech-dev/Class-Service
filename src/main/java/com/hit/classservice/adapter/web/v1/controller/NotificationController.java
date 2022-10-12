package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.notification.CreateNotificationParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.notification.CreateNotificationInput;
import com.hit.classservice.application.input.notification.DeleteNotificationInput;
import com.hit.classservice.application.input.notification.GetNotificationInput;
import com.hit.classservice.application.input.notification.ReadNotificationInput;
import com.hit.classservice.application.mapper.NotificationMapper;
import com.hit.classservice.application.output.notification.CreateNotificationOutput;
import com.hit.classservice.application.output.notification.DeleteNotificationOutput;
import com.hit.classservice.application.output.notification.GetNotificationOutput;
import com.hit.classservice.application.output.notification.ReadNotificationOutput;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestApiV1
public class NotificationController {
  private final UseCaseBus useCaseBus;
  private final ResponseHeader responseHeader;
  private final NotificationMapper notificationMapper;

  public NotificationController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                                @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
    this.useCaseBus = useCaseBus;
    this.responseHeader = responseHeader;
    this.notificationMapper = Mappers.getMapper(NotificationMapper.class);
  }

  @GetMapping(UrlConstant.Notification.GET)
  public ResponseEntity<?> getNotificationById(@PathVariable("id") Long id) throws Exception {
    // Create input
    GetNotificationInput input = new GetNotificationInput(id);
    // Get output
    GetNotificationOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @PostMapping(UrlConstant.Notification.CREATE)
  public ResponseEntity<?> createNotification(@Valid @RequestBody CreateNotificationParameter parameter) throws Exception {
    // Create input
    CreateNotificationInput input = notificationMapper.toCreateNotificationInput(parameter);
    // Get output
    CreateNotificationOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @PatchMapping(UrlConstant.Notification.READ)
  public ResponseEntity<?> readNotificationById(@PathVariable("id") Long id) throws Exception {
    // Create input
    ReadNotificationInput input = new ReadNotificationInput(id);
    // Get output
    ReadNotificationOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  @DeleteMapping(UrlConstant.Notification.DELETE)
  public ResponseEntity<?> deleteNotificationById(@PathVariable("id") Long id) throws Exception {
    // Create input
    DeleteNotificationInput input = new DeleteNotificationInput(id);
    // Get output
    DeleteNotificationOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}