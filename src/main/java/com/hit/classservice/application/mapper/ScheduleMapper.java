package com.hit.classservice.application.mapper;

import com.hit.classservice.application.output.schedule.GetListScheduleItemOutput;
import com.hit.classservice.application.output.schedule.GetScheduleByIdOutput;
import com.hit.classservice.domain.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

  @Mappings({
      @Mapping(target = "id", source = "schedule.id"),
      @Mapping(target = "name", source = "schedule.name"),
      @Mapping(target = "internalName", source = "schedule.internalName"),
      @Mapping(target = "session", source = "schedule.session"),
      @Mapping(target = "timeDetail", source = "schedule.timeDetail")
  })
  GetListScheduleItemOutput toGetListScheduleItemOutput(Schedule schedule);

  List<GetListScheduleItemOutput> toGetListScheduleOutputs(List<Schedule> schedules);

  GetScheduleByIdOutput toGetScheduleByIdOutput(Schedule schedule);


}
