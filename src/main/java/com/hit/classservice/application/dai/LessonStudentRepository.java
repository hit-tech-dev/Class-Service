package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.LessonStudent;

import java.util.List;

public interface LessonStudentRepository {

  LessonStudent findById(Long id);

  int save(LessonStudent lessonStudent);

  List<LessonStudent> getListLessonStudentByLessonId(Long lessonId);

}
