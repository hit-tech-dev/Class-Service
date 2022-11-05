package com.hit.classservice.application.output.user_subject;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RemoveUserFromSubjectOutput implements Output {

  private boolean status;

  private String message;

}
