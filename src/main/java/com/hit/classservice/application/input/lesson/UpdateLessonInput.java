package com.hit.classservice.application.input.lesson;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLessonInput implements Input {

  private Long id;

  private String name;

  private String content;

  private Long expiredTimeHomework;
}
