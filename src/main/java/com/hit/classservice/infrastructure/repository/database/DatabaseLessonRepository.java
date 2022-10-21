package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.domain.entity.Lesson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("DatabaseLessonRepository")
public interface DatabaseLessonRepository extends LessonRepository {
  @Override
  Lesson findById(@Param("id") Long id);

  @Override
  List<Lesson> getListLessonBySubjectId(@Param("subjectId") Long subjectId);

  @Override
  int save(@Param("item") Lesson lesson);

}
