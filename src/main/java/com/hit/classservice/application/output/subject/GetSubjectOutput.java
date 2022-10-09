package com.hit.classservice.application.output.subject;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetSubjectOutput implements Output {

  private Long id;

  private String name;

  private String avatar;

  private String description;

}
