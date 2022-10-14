package com.hit.classservice.application.input_boundary.schedule;

import com.hit.classservice.application.input.schedule.GetListScheduleInput;
import com.hit.classservice.application.input.schedule.GetScheduleByIdInput;
import com.hit.classservice.application.input_boundary.UseCase;
import com.hit.classservice.application.output.schedule.GetListScheduleOutput;
import com.hit.classservice.application.output.schedule.GetScheduleByIdOutput;

public interface GetListScheduleDataCase extends UseCase<GetListScheduleInput, GetListScheduleOutput> {
}
