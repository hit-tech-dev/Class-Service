package com.hit.classservice.application.output.role;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetRoleOutput implements Output {

  private Long id;

  private String name;

  private String description;

}
