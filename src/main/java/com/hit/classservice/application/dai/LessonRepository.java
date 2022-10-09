package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Lesson;

public interface LessonRepository {

  Lesson findById(Long id);
}
