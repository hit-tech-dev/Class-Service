package com.hit.classservice.application.input.lesson;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLessonInput implements Input {

  private String name;

  private String content;

  private Long expiredTimeHomework;

  private Long subjectId;

}
