package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.ScheduleRepository;
import com.hit.classservice.domain.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("DatabaseScheduleRepository")
public interface DatabaseScheduleRepository extends ScheduleRepository {

  @Override
  Schedule findById(@Param("id") Long id);

  @Override
  List<Schedule> findAll();
}
