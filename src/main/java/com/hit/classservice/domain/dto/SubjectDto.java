package com.hit.classservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDto {

  private Long id;

  private Long categoryId;

  private String name;

  private String avatar;

  private String description;

  private Long createdDate;

  private CreatedByDto createdBy;

  private LastModifiedByDto lastModifiedBy;

}
