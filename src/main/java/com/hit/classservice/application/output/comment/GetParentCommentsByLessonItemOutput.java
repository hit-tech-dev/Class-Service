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

  private String authorName;

  private String authorAvatar;

  private Long createdDate;

  private String createdBy;

  private Integer totalNumberChild;

  private String userId;

}
