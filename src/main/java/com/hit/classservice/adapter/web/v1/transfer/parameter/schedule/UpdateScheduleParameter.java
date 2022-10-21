package com.hit.classservice.adapter.web.v1.transfer.parameter.schedule;

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
public class UpdateScheduleParameter {

    @NotNull(message = UserMessageConstant.Subject.INVALID_FIELD_IS_REQUIRED)
    @Min(value = 1, message = UserMessageConstant.Subject.INVALID_FIELD_ENTERED)
    private Long id;

    @NotBlank(message = UserMessageConstant.Subject.INVALID_FIELD_IS_REQUIRED)
    private String name;

    private String internalName;

    private String session;

    private String timeDetail;

}
