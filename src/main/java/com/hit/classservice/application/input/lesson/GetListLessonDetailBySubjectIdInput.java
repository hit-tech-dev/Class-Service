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
public class GetListLessonDetailBySubjectIdInput implements Input {

  private Long subjectId;

}
