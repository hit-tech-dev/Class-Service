package com.hit.classservice.application.dai;

import com.hit.classservice.domain.dto.ChildrenCommentDTO;
import com.hit.classservice.domain.dto.ParentCommentDTO;
import com.hit.classservice.domain.entity.Comment;

import java.util.List;

public interface CommentRepository {

  Comment findById(Long id);

  List<Comment> findByParentId(Long id);

  List<ParentCommentDTO> findParentCommentByLesson(Long lessonId);

  List<ChildrenCommentDTO> findChildrenCommentByLessonAndParentComment(Long lessonId, Long parentId);

  int createCommentForLesson(Comment comment);

  int editComment(Comment comment);

  int createCommentForLessonStudent(Comment comment);

  int delete(Long id);

  List<Comment> getListCommentByLessonId(Long lessonId);
}
