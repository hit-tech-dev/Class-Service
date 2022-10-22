package com.hit.classservice.application.input.lesson_student;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLessonStudentInput implements Input {

  private String userId;

  private Long lessonId;

  private boolean attendance;

}
