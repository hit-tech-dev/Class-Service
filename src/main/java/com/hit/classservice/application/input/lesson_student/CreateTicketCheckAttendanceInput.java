package com.hit.classservice.application.input.lesson_student;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicketCheckAttendanceInput implements Input {
  private String userId;

  private Long lessonId;

  private boolean attendance;

}
