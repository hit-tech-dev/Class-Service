package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Notification;

public interface NotificationRepository  {

    void readNotification(Long id);

    int save(Notification notification);

    Notification findById(Long id);

    void deleteById(Long id);
}
