package com.hit.classservice.application.input.comment;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetParentCommentsByLessonInput implements Input {

  private Long lessonId;

}
