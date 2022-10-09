package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.LessonStudent;

public interface LessonStudentRepository {

    LessonStudent findById(Long id);
}
