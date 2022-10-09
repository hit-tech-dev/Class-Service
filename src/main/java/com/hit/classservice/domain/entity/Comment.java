package com.hit.classservice.domain.entity;

import com.hit.classservice.domain.entity.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends AbstractAuditingEntity {

  private Long id;

  private String content;

  private Long parentId;

  // Foreign Key
  private String userId;

  private Long lessonId;

  private Long lessonStudentId;

}
