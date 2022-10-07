package com.hit.classservice.application.input.category;


import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryInput implements Input {

  private String name;

  private String description;

}
