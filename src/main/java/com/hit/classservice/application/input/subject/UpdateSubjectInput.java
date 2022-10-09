package com.hit.classservice.application.input.subject;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSubjectInput implements Input {

  private Long id;

  private String name;

  private String avatar;

  private String description;

}
