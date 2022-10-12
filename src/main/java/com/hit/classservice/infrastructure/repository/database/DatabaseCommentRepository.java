package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.domain.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("DatabaseCommentRepository")
public interface DatabaseCommentRepository extends CommentRepository {

  @Override
  Comment findById(@Param("id") Long id);

  @Override
  List<Comment> findByParentId(@Param("id") Long id);

  @Override
  int createCommentForLesson(@Param("item") Comment comment);

  @Override
  int createCommentForLessonStudent(@Param("item") Comment comment);

  @Override
  int delete(@Param("id") Long id);

}
