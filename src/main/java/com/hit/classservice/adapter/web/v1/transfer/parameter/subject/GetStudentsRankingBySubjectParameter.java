package com.hit.classservice.adapter.web.v1.transfer.parameter.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetStudentsRankingBySubjectParameter {

  private Long subjectId;

  private Boolean isTrending = Boolean.FALSE;
}
