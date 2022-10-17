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
public class Subject extends AbstractAuditingEntity {

  private Long id;

  private String name;

  private String avatar;

  private String description;

  private Long categoryId;

  public Subject(String name, String avatar, String description, Long categoryId) {
    this.name = name;
    this.avatar = avatar;
    this.description = description;
    this.categoryId = categoryId;
  }

}
