package com.hit.classservice.application.input.comment;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditCommentInput implements Input {

  private Long id;

  private String userId;

  private String content;

}
