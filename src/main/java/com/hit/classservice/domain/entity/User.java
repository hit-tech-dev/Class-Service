package com.hit.classservice.domain.entity;

import com.hit.classservice.domain.entity.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractAuditingEntity {

  private String id;

  private String studentCode;

  private String birthday;

  private String fullName;

  private String email;

  private String phone;

  private String gender;

  private String avatar;

}

