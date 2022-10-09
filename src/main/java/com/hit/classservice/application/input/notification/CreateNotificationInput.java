package com.hit.classservice.application.input.notification;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateNotificationInput implements Input {

  private String content;

  private String path;

  private Integer type;

}
