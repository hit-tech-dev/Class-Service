package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.schedule.UpdateScheduleParameter;
import com.hit.classservice.application.input.schedule.UpdateScheduleInput;
import com.hit.classservice.application.output.schedule.GetScheduleByIdOutput;
import com.hit.classservice.domain.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

  @Mappings({
          @Mapping(target = "id", source = "schedule.id"),
          @Mapping(target = "name", source = "schedule.name"),
          @Mapping(target = "internalName", source = "schedule.internalName"),
          @Mapping(target = "session", source = "schedule.session"),
          @Mapping(target = "timeDetail", source = "schedule.timeDetail")
  })

  GetScheduleByIdOutput toGetScheduleByIdOutput(Schedule schedule);

    UpdateScheduleInput toUpdateScheduleInput(UpdateScheduleParameter parameter);
}
