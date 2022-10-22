package com.hit.classservice.application.interator.notification;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.dai.NotificationRepository;
import com.hit.classservice.application.input.notification.CreateNotificationInput;
import com.hit.classservice.application.input_boundary.notification.CreateNotificationDataCase;
import com.hit.classservice.application.output.notification.CreateNotificationOutput;
import com.hit.classservice.domain.entity.Notification;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateNotificationInteractor")
public class CreateNotificationInteractor implements CreateNotificationDataCase {
  private final NotificationRepository notificationRepository;

  public CreateNotificationInteractor(@Qualifier("DatabaseNotificationRepository") NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }

  @Override
  public CreateNotificationOutput handle(CreateNotificationInput input) throws Exception {
    // Insert
    Notification notification = new Notification(input.getContent(), input.getPath(), input.getType());
    notificationRepository.save(notification);
    return new CreateNotificationOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }

}
