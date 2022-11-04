package com.hit.classservice.adapter.web.v1.transfer.parameter.user_subject;

import com.hit.classservice.application.constant.UserMessageConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RemoveUserFromSubjectParameter {

  @NotNull(message = UserMessageConstant.INVALID_SOME_THING_FIELD_IS_REQUIRED)
  @Min(value = 1, message = UserMessageConstant.INVALID_SOME_THING_FIELD)
  private Long subjectId;

  @NotBlank(message = UserMessageConstant.INVALID_SOME_THING_FIELD_IS_REQUIRED)
  private String userId;

}
