package com.hit.classservice.application.mapper;

import com.hit.classservice.application.output.schedule.GetScheduleByIdOutput;
import com.hit.classservice.domain.entity.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

  GetScheduleByIdOutput toGetScheduleByIdOutput(Schedule schedule);

}
