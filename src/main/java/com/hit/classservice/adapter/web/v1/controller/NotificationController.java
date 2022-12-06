package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.RestData;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.notification.CreateNotificationParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.notification.*;
import com.hit.classservice.application.mapper.NotificationMapper;
import com.hit.classservice.application.output.notification.*;
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

  /**
   * @param id Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API get notification by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found the notification",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = GetNotificationOutput.class))
          }),
      @ApiResponse(responseCode = "400", description = "Id not exist", content = {
          @Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
      })
  })
  @GetMapping(UrlConstant.Notification.GET)
  public ResponseEntity<?> getNotificationById(@PathVariable("id") Long id) throws Exception {
    // Create input
    GetNotificationInput input = new GetNotificationInput(id);
    // Get output
    GetNotificationOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param parameter CreateNotificationParameter
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API create new notification")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Create notification success",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = CreateNotificationOutput.class))
          })
  })
  @PostMapping(UrlConstant.Notification.CREATE)
  public ResponseEntity<?> createNotification(@Valid @RequestBody CreateNotificationParameter parameter) throws Exception {
    // Create input
    CreateNotificationInput input = notificationMapper.toCreateNotificationInput(parameter);
    // Get output
    CreateNotificationOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param id Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API read notification by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = ReadNotificationOutput.class))
          }),
      @ApiResponse(responseCode = "404", description = "Not found notificationId",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
          })
  })
  @PatchMapping(UrlConstant.Notification.READ)
  public ResponseEntity<?> readNotificationById(@PathVariable("id") Long id) throws Exception {
    // Create input
    ReadNotificationInput input = new ReadNotificationInput(id);
    // Get output
    ReadNotificationOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @param id Long
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API delete notification by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = ReadNotificationOutput.class))
          }),
      @ApiResponse(responseCode = "404", description = "Not found notificationId",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = RestData.class))
          })
  })
  @DeleteMapping(UrlConstant.Notification.DELETE)
  public ResponseEntity<?> deleteNotificationById(@PathVariable("id") Long id) throws Exception {
    // Create input
    DeleteNotificationInput input = new DeleteNotificationInput(id);
    // Get output
    DeleteNotificationOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

  /**
   * @return ResponseEntity<?>
   */
  @Operation(summary = "API read all notification notification")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success",
          content = {@Content(mediaType = CommonConstant.APPLICATION_JSON_TYPE,
              schema = @Schema(implementation = ReadAllNotificationOutput.class))
          })
  })
  @PatchMapping(UrlConstant.Notification.READ_ALL)
  public ResponseEntity<?> readAllNotificationById() throws Exception {
    // Create input
    ReadAllNotificationInput input = new ReadAllNotificationInput();
    // Get output
    ReadAllNotificationOutput output = useCaseBus.handle(input);
    // Return output
    return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
  }

}
