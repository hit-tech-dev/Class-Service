package com.hit.classservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private String id;

  private Long roleId;

  private String studentCode;

  private String birthday;

  private String fullName;

  private String email;

  private String phone;

  private String gender;

  private String avatar;

}
