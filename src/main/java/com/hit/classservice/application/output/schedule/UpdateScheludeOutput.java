package com.hit.classservice.application.output.schedule;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateScheludeOutput implements Output {
    private boolean status;

    private String message;

}
