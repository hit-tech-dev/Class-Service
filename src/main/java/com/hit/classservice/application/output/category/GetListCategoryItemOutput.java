package com.hit.classservice.application.output.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListCategoryItemOutput {

  private Long id;

  private String name;

  private String description;

}
