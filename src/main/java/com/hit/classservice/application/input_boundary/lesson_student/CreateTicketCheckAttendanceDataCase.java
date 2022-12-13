package com.hit.classservice.application.input_boundary.lesson_student;

import com.hit.classservice.application.input.lesson_student.CreateTicketCheckAttendanceInput;
import com.hit.classservice.application.input_boundary.UseCase;
import com.hit.classservice.application.output.lesson_student.CreateTicketCheckAttendanceOutput;

public interface CreateTicketCheckAttendanceDataCase extends UseCase<CreateTicketCheckAttendanceInput,
    CreateTicketCheckAttendanceOutput> {
}
