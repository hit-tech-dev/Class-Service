package com.hit.classservice.application.dai;

import com.hit.classservice.domain.dto.LessonDetailDto;
import com.hit.classservice.domain.entity.Lesson;

import java.util.List;

public interface LessonRepository {
  Lesson findById(Long id);

  List<Lesson> getListLessonBySubjectId(Long subjectId);

  int update(Lesson lesson);

  boolean deleteById(Long id);


  int save(Lesson lesson);

  List<LessonDetailDto> findAllLessonDetailBySubjectId(Long subjectId);

}
