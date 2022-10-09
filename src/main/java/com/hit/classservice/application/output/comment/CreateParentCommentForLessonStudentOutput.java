package com.hit.classservice.application.output.comment;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateParentCommentForLessonStudentOutput implements Output {

  private boolean status;

  private String message;

}
