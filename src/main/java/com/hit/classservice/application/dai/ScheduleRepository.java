package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Schedule;

public interface ScheduleRepository {

  Schedule findById(Long id);

}
