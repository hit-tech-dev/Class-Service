package com.hit.classservice.application.output.lesson;

import com.hit.classservice.application.output.Output;
import com.hit.classservice.application.output.document.GetDocumentOutputItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListLessonDetailItemOutput implements Output {

  private Long id;

  private String name;

  private String content;

  private Long expiredTimeHomework;

  private String createdBy;

  private Long createdDate;

  private List<GetDocumentOutputItem> documents;

}
