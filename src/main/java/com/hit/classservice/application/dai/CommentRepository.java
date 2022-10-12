package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Comment;

import java.util.List;

public interface CommentRepository {
  Comment findById(Long id);

  List<Comment> findByParentId(Long id);

  int createCommentForLesson(Comment comment);

  int createCommentForLessonStudent(Comment comment);

  int delete(Long id);
}
