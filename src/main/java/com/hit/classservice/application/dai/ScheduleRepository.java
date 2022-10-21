package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {

  Schedule findById(Long id);

  int update(Schedule schedule);

  List<Schedule> findAll();

}
