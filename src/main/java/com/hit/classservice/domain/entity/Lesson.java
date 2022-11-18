package com.hit.classservice.domain.entity;

import com.hit.classservice.application.output.document.GetDocumentOutputItem;
import com.hit.classservice.domain.entity.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson extends AbstractAuditingEntity {

  private Long id;

  private String name;

  private String content;

  private Long expiredTimeHomework;

  private Long subjectId;

  private List<Document> documents;

  private String note;

  private String mentor;

  public Lesson(String name, String content, Long expiredTimeHomework, Long subjectId) {
    this.name = name;
    this.content = content;
    this.expiredTimeHomework = expiredTimeHomework;
    this.subjectId = subjectId;
  }

}
