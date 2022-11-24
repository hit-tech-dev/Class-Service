package com.hit.classservice.application.input.user_subject;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetListSubjectFromUserInput implements Input {

  private String userId;

}
