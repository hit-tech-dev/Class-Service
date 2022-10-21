package com.hit.classservice.adapter.web.v1.transfer.parameter.lesson_student;

import com.hit.classservice.application.constant.UserMessageConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLessonStudentParameter {

  @NotNull(message = UserMessageConstant.INVALID_SOME_THING_FIELD_IS_REQUIRED)
  private String userId;

  @NotNull(message = UserMessageConstant.INVALID_SOME_THING_FIELD_IS_REQUIRED)
  @Min(value = 1, message = UserMessageConstant.INVALID_SOME_THING_FIELD)
  private Long lessonId;

  private boolean attendance;

}
