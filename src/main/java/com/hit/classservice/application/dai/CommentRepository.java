package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.Comment;

public interface CommentRepository {
    Comment findById(Long id);

    int createParentCommentForLesson(Comment comment);

    int createParentCommentForLessonStudent(Comment comment);
}
