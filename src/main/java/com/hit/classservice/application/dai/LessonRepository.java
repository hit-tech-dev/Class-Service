package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Lesson;

import java.util.List;

public interface LessonRepository {
  Lesson findById(Long id);

  List<Lesson> getListLessonBySubjectId(Long subjectId);

  int update(Lesson lesson);

<<<<<<< HEAD
  Lesson findLessonDetailById(Long id);

=======
  int save(Lesson lesson);
>>>>>>> d71bad44fb39d3e202b27d2579686a00f6029885
}
