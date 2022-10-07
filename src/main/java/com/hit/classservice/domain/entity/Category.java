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
public class Category extends AbstractAuditingEntity {

  private Long id;

  private String name;

  private String description;

  public Category(String name, String description) {
    this.name = name;
    this.description = description;
  }

}
