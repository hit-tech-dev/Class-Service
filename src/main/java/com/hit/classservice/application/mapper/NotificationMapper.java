package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.notification.CreateNotificationParameter;
import com.hit.classservice.application.input.notification.CreateNotificationInput;
import com.hit.classservice.application.output.notification.GetNotificationOutput;
import com.hit.classservice.domain.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface NotificationMapper {

  @Mappings({
      @Mapping(target = "id", source = "notification.id"),
      @Mapping(target = "content", source = "notification.content"),
      @Mapping(target = "path", source = "notification.path"),
      @Mapping(target = "type", source = "notification.type"),
      @Mapping(target = "isRead", source = "notification.isRead")
  })
  GetNotificationOutput toGetNotificationOutput(Notification notification);

  CreateNotificationInput toCreateNotificationInput(CreateNotificationParameter parameter);
}
