package com.hit.classservice.application.output.category;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryOutput implements Output {

  private Long id;

  private String name;

  private String description;

}
