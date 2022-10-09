package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Comment;

public interface CommentRepository {
  Comment findById(Long id);

  int createCommentForLesson(Comment comment);

  int createCommentForLessonStudent(Comment comment);
}
