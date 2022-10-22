package com.hit.classservice.adapter.web.v1.transfer.parameter.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLessonParameter {

  private Long id;

  private String name;

  private String content;

  private Long expiredTimeHomework;
}
