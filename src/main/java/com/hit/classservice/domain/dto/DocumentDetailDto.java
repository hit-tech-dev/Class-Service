package com.hit.classservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDetailDto {

  private Long documentId;

  private String title;

  private String link;

  private Long mark;

}
