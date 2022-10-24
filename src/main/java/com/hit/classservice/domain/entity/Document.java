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
public class Document extends AbstractAuditingEntity {

  private Long id;

  private String link;

  private Integer type;

  private String title;

  private Double mark;

}
