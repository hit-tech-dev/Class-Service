package com.hit.classservice.adapter.web.v1.transfer.parameter.lesson;

import com.hit.classservice.application.constant.UserMessageConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLessonParameter {

  @NotBlank(message = UserMessageConstant.INVALID_SOME_THING_FIELD_IS_REQUIRED)
  private String name;

  @NotBlank(message = UserMessageConstant.INVALID_SOME_THING_FIELD_IS_REQUIRED)
  private String content;

  private Long expiredTimeHomework;

  @NotNull(message = UserMessageConstant.INVALID_SOME_THING_FIELD_IS_REQUIRED)
  @Min(value = 1, message = UserMessageConstant.INVALID_SOME_THING_FIELD)
  private Long subjectId;

}
