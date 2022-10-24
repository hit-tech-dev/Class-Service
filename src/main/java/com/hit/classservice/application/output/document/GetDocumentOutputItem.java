package com.hit.classservice.application.output.document;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDocumentOutputItem implements Output {

  private Long documentId;

  private String link;

  private Integer type;

  private String title;

  private Double mark;

}
