package com.hit.classservice.application.interator.schedule;

import com.hit.classservice.application.dai.ScheduleRepository;
import com.hit.classservice.application.input.schedule.GetListScheduleInput;
import com.hit.classservice.application.input_boundary.schedule.GetListScheduleDataCase;
import com.hit.classservice.application.mapper.ScheduleMapper;
import com.hit.classservice.application.output.schedule.GetListScheduleItemOutput;
import com.hit.classservice.application.output.schedule.GetListScheduleOutput;
import com.hit.classservice.domain.entity.Schedule;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationGetListScheduleInterator")
public class GetListScheduleInterator implements GetListScheduleDataCase {
  private final ScheduleRepository scheduleRepository;
  private final ScheduleMapper scheduleMapper;

  public GetListScheduleInterator(@Qualifier("DatabaseScheduleRepository") ScheduleRepository scheduleRepository) {
    this.scheduleRepository = scheduleRepository;
    this.scheduleMapper = Mappers.getMapper(ScheduleMapper.class);
  }


  @SneakyThrows
  @Override
  public GetListScheduleOutput handle(GetListScheduleInput input) throws Exception {
    List<Schedule> schedules = scheduleRepository.findAll();

    List<GetListScheduleItemOutput> output = scheduleMapper.toGetListScheduleOutputs(schedules);

    return new GetListScheduleOutput(output);
  }
}
