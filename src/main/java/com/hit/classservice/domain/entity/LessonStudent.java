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
public class LessonStudent extends AbstractAuditingEntity {

  private Long id;

  private boolean attendance;

  private Long lessonId;

  private String userId;

  public LessonStudent(Long lessonId, String userId, boolean attendance) {
    this.lessonId = lessonId;
    this.userId = userId;
    this.attendance = attendance;
  }
}
