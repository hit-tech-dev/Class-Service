package com.hit.classservice.application.interator.notification;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.dai.NotificationRepository;
import com.hit.classservice.application.input.notification.ReadAllNotificationInput;
import com.hit.classservice.application.input_boundary.notification.ReadAllNotificationDataCase;
import com.hit.classservice.application.output.notification.ReadAllNotificationOutput;
import com.hit.classservice.application.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationReadAllNotificationInteractor")
public class ReadAllNotificationInteractor implements ReadAllNotificationDataCase {
  private final NotificationRepository notificationRepository;

  public ReadAllNotificationInteractor(@Qualifier("DatabaseNotificationRepository") NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }

  @Override
  public ReadAllNotificationOutput handle(ReadAllNotificationInput input) throws Exception {
    notificationRepository.readAllNotification(SecurityUtil.getCurrentUserLogin());
    return new ReadAllNotificationOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }


}
