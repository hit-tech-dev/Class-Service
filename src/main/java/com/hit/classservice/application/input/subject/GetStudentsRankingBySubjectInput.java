package com.hit.classservice.application.input.subject;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetStudentsRankingBySubjectInput implements Input {

  private Long subjectId;

  private Boolean isTrending;
}
