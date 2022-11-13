package com.hit.classservice.application.input.user_subject;

import com.hit.classservice.application.input.Input;
import com.hit.classservice.application.input.commons.FindDataInput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListUserInSubjectInput extends FindDataInput implements Input {

  private Long subjectId;

}
