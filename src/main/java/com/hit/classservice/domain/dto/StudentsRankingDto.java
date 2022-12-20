package com.hit.classservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentsRankingDto {

  private String id;

  private String fullName;

  private String avatar;

  private Boolean isIncrement;

  private String totalMark;
}
