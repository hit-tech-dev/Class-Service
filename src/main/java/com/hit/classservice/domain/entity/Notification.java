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
public class Notification extends AbstractAuditingEntity {

  private Long id;

  private String content;

  private String path;

  private Integer type;

  private Boolean isRead;

  public Notification(String content, String path, Integer type) {
    this.content = content;
    this.path = path;
    this.type = type;
  }

}
