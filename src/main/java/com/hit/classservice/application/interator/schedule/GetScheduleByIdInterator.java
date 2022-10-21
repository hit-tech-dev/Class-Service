package com.hit.classservice.application.interator.schedule;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.ScheduleRepository;
import com.hit.classservice.application.input.schedule.GetScheduleByIdInput;
import com.hit.classservice.application.input_boundary.schedule.GetScheduleByIdDataCase;
import com.hit.classservice.application.mapper.ScheduleMapper;
import com.hit.classservice.application.output.schedule.GetScheduleByIdOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Schedule;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationGetScheduleByIdInterator")
public class GetScheduleByIdInterator implements GetScheduleByIdDataCase {
  private final ScheduleRepository scheduleRepository;
  private final ScheduleMapper scheduleMapper;

  public GetScheduleByIdInterator(@Qualifier("DatabaseScheduleRepository") ScheduleRepository scheduleRepository) {
    this.scheduleRepository = scheduleRepository;
      this.scheduleMapper = Mappers.getMapper(ScheduleMapper.class);
  }

  @SneakyThrows
  @Override
  public GetScheduleByIdOutput handle(GetScheduleByIdInput input) {
    Schedule schedule = scheduleRepository.findById(input.getId());

    if (ObjectUtils.isEmpty(schedule)) {
      throw new VsException(UserMessageConstant.Schedule.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Schedule.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    }

    return scheduleMapper.toGetScheduleByIdOutput(schedule);
  }

}
