package com.hit.classservice.application.output.user_subject;

import com.hit.classservice.application.output.common.CreatedBy;
import com.hit.classservice.application.output.common.LastModifiedBy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetListUserInSubjectItemOutput {

  private String id;

  private String studentCode;

  private String birthday;

  private String fullName;

  private String email;

  private String phone;

  private String gender;

  private String avatar;

  private Integer grade;

  private String roleName;

  private CreatedBy createdBy;

  private LastModifiedBy lastModifiedBy;

}
