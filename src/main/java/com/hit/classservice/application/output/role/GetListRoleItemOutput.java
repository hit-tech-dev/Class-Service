package com.hit.classservice.application.output.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListRoleItemOutput {

  private Long id;

  private String name;

  private String description;

}
