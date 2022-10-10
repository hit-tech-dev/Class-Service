package com.hit.classservice.application.interator.schedule;

import com.hit.classservice.application.dai.ScheduleRepository;
import com.hit.classservice.application.input.schedule.GetScheduleByIdInput;
import com.hit.classservice.application.input_boundary.schedule.GetScheduleByIdDataCase;
import com.hit.classservice.application.output.schedule.GetScheduleByIdOutput;
import com.hit.classservice.domain.entity.Schedule;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationGetScheduleByIdInterator")
public class GetScheduleByIdInterator implements GetScheduleByIdDataCase {
  private final ScheduleRepository scheduleRepository;

  public GetScheduleByIdInterator(@Qualifier("DatabaseScheduleRepository") ScheduleRepository scheduleRepository) {
    this.scheduleRepository = scheduleRepository;
  }

  @SneakyThrows
  @Override
  public GetScheduleByIdOutput handle(GetScheduleByIdInput input) {
    Schedule schedule = scheduleRepository.findById(input.getId());

    return new GetScheduleByIdOutput(schedule.getId(), schedule.getName(), schedule.getInternalName(),
        schedule.getSession(), schedule.getTimeDetail());
  }

}
