package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Lesson;

import java.util.List;

public interface LessonRepository {
  Lesson findById(Long id);

  List<Lesson> getListLessonBySubjectId(Long subjectId);

  int update(Lesson lesson);

  int save(Lesson lesson);
}
