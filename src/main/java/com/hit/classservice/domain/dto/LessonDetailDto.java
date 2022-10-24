package com.hit.classservice.domain.dto;

import com.hit.classservice.domain.entity.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonDetailDto {

  private Long id;

  private String name;

  private String content;

  private Long expiredTimeHomework;

  private List<DocumentDetailDto> documents;

}
