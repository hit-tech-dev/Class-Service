package com.hit.classservice.application.dai;

import com.hit.classservice.domain.dto.ChildrenCommentDTO;
import com.hit.classservice.domain.dto.ParentCommentDTO;
import com.hit.classservice.domain.entity.Comment;

import java.util.List;

public interface CommentRepository {
  Comment findById(Long id);

  List<ParentCommentDTO> findParentCommentByLesson(Long lessonId);

  List<ChildrenCommentDTO> findChildrenCommentByLessonAndParentComment(Long lessonId, Long parentId);

  int createCommentForLesson(Comment comment);

  int createCommentForLessonStudent(Comment comment);
}
