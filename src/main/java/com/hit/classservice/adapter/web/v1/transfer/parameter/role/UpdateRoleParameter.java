package com.hit.classservice.adapter.web.v1.transfer.parameter.role;

import com.hit.classservice.application.constant.UserMessageConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleParameter {

  @Min(value = 1, message = UserMessageConstant.INVALID_SOME_THING_FIELD)
  private Long id;

  @NotBlank(message = UserMessageConstant.INVALID_SOME_THING_FIELD_IS_REQUIRED)
  private String name;

  private String description;

}
