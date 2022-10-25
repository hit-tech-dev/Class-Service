package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Document;

import java.util.List;

public interface DocumentRepository {
  List<Document> getListDocumentByLessonId(Long lessonId);
}
