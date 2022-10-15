package com.hit.classservice.application.input.schedule;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateScheduleInput implements Input {
    private Long id;

    private String name;

    private String internalName;

    private String session;

    private String timeDetail;
}
