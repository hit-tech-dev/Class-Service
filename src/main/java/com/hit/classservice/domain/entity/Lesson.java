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
public class Lesson extends AbstractAuditingEntity {

    private Long id;

    private String name;

    private String content;

    private Long expiredTimeHomework;

    private Long subjectId;
}
