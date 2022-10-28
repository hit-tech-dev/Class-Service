package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.NotificationRepository;
import com.hit.classservice.domain.entity.Notification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("DatabaseNotificationRepository")
public interface DatabaseNotificationRepository extends NotificationRepository {

  @Override
  Notification findById(@Param("id") Long id);

  @Override
  void readNotification(@Param("id") Long id);

  @Override
  int save(@Param("item") Notification notification);

  @Override
  void deleteById(@Param("id") Long id);

  @Override
  void readAllNotification(@Param("userId") String userId);
}
