package com.hit.classservice.adapter.web.v1.transfer.parameter;

import com.hit.classservice.application.constant.UserMessageConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateNotificationParameter {

    @NotBlank(message = UserMessageConstant.INVALID_SOME_THING_FIELD_IS_REQUIRED)
    private String content;

    private String path;

    private Integer type;

}
