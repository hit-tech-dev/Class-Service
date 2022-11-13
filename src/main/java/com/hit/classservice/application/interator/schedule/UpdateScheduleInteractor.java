package com.hit.classservice.application.interator.schedule;


import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.ScheduleRepository;
import com.hit.classservice.application.input.schedule.UpdateScheduleInput;
import com.hit.classservice.application.input_boundary.schedule.UpdateScheduleDataCase;
import com.hit.classservice.application.output.schedule.UpdateScheduleOutput;
import com.hit.classservice.application.utils.SecurityUtil;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Schedule;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationUpdateScheduleInteractor")
public class UpdateScheduleInteractor implements UpdateScheduleDataCase {
  private final ScheduleRepository scheduleRepository;

  public UpdateScheduleInteractor(@Qualifier("DatabaseScheduleRepository") ScheduleRepository scheduleRepository) {
    this.scheduleRepository = scheduleRepository;
  }

  @SneakyThrows
  @Override
  public UpdateScheduleOutput handle(UpdateScheduleInput input) {
    Schedule oldSchedule = scheduleRepository.findById(input.getId());
    if (ObjectUtils.isEmpty(oldSchedule)) {
      throw new NotFoundException(UserMessageConstant.Schedule.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Schedule.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    }
    oldSchedule.setName(input.getName());
    oldSchedule.setSession(input.getSession());
    oldSchedule.setTimeDetail(input.getTimeDetail());
    oldSchedule.setInternalName(input.getInternalName());
    oldSchedule.setLastModifiedBy(SecurityUtil.getCurrentUserLogin());
    scheduleRepository.update(oldSchedule);

    return new UpdateScheduleOutput(CommonConstant.TRUE, "Update successful");
  }

}
