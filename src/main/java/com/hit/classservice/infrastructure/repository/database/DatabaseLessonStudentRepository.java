package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.LessonStudentRepository;
import com.hit.classservice.domain.entity.LessonStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("DatabaseLessonStudentRepository")
public interface DatabaseLessonStudentRepository extends LessonStudentRepository {

  @Override
  LessonStudent findById(@Param("id") Long id);
}
