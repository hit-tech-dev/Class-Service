package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.domain.entity.Lesson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("DatabaseLessonRepository")
public interface DatabaseLessonRepository extends LessonRepository {

    @Override
    Lesson findById(@Param("id") Long id);
}
