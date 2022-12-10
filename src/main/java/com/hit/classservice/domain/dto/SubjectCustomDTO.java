package com.hit.classservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectCustomDTO {

  private Long id;

  private String name;

  private String avatar;

  private String description;

  private String studyForm;

  private String studyPlace;

  private String totalStudent;

  private String timeDetail;

}
