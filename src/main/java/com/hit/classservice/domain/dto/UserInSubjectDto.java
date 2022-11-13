package com.hit.classservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInSubjectDto {

  private String id;

  private String studentCode;

  private String birthday;

  private String fullname;

  private String email;

  private String phone;

  private Integer grade;

  private String gender;

  private String avatar;

  private String roleName;

  private CreatedByDto createdBy;

  private LastModifiedByDto lastModifiedBy;

}
