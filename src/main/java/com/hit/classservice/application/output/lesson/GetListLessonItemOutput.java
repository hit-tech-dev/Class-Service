package com.hit.classservice.application.output.lesson;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListLessonItemOutput implements Output {

  private Long id;

  private String name;

  private String content;

  private Long expiredTimeHomework;

  private String note;

  private String mentor;

}
