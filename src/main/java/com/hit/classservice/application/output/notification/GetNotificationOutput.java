package com.hit.classservice.application.output.notification;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetNotificationOutput implements Output {

    private Long id;

    private String content;

    private String path;

    private Integer type;

    private Boolean isRead;
}
