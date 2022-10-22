package com.hit.classservice.application.output.lesson;

import com.hit.classservice.application.output.Output;
import com.hit.classservice.domain.entity.Comment;
import com.hit.classservice.domain.entity.Document;
import com.hit.classservice.domain.entity.LessonStudent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetLessonDetailByIdOutput implements Output {

  private Long id;
  private Long subjectId;
  private String name;
  private String content;
  private Long expiredTimeHomework;
  private List<Document> documents;
  private List<LessonStudent> lessonStudents;
  private List<Comment> comments;
}
