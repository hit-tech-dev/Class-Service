package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.domain.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("DatabaseCommentRepository")
public interface DatabaseCommentRepository extends CommentRepository {

  @Override
  Comment findById(@Param("id") Long id);

  @Override
  int createCommentForLesson(@Param("item") Comment comment);

  @Override
  int editComment(@Param("item") Comment comment);

  @Override
  int createCommentForLessonStudent(@Param("item") Comment comment);

}
