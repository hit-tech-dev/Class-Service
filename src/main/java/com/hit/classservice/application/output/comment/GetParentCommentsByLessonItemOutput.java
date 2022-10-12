package com.hit.classservice.application.output.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetParentCommentsByLessonItemOutput {

  private Long id;

  private String content;

  private Long parentId;

  private String createdBy;

  private Long createdDate;
}
