package com.hit.classservice.application.interator.comment;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.dai.LessonStudentRepository;
import com.hit.classservice.application.input.comment.CreateChildrenCommentForLessonStudentInput;
import com.hit.classservice.application.input_boundary.comment.CreateChildrenCommentForLessonStudentDataCase;
import com.hit.classservice.application.output.comment.CreateChildrenCommentForLessonStudentOutput;
import com.hit.classservice.application.utils.SecurityUtil;
import com.hit.classservice.domain.entity.Comment;
import com.hit.classservice.domain.entity.LessonStudent;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateChildrenCommentForLessonStudentInteractor")
public class CreateChildrenCommentForLessonStudentInteractor implements CreateChildrenCommentForLessonStudentDataCase {

  private final CommentRepository commentRepository;

  private final LessonStudentRepository lessonStudentRepository;

  public CreateChildrenCommentForLessonStudentInteractor(@Qualifier("DatabaseCommentRepository") CommentRepository commentRepository,
                                                         @Qualifier("DatabaseLessonStudentRepository") LessonStudentRepository lessonStudentRepository) {
    this.commentRepository = commentRepository;
    this.lessonStudentRepository = lessonStudentRepository;
  }

  @SneakyThrows
  @Override
  public CreateChildrenCommentForLessonStudentOutput handle(CreateChildrenCommentForLessonStudentInput input) throws Exception {
    LessonStudent oldLessonStudent = lessonStudentRepository.findById(input.getLessonStudentId());
    Comment parentComment = commentRepository.findById(input.getParentCommentId());
    if (ObjectUtils.isEmpty(oldLessonStudent)) {
      return new CreateChildrenCommentForLessonStudentOutput(CommonConstant.FALSE, String.format(
          DevMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID, input.getLessonStudentId()));
    }
    if (ObjectUtils.isEmpty(parentComment)) {
      return new CreateChildrenCommentForLessonStudentOutput(CommonConstant.FALSE, String.format(
          DevMessageConstant.Comment.ERR_NOT_FOUND_BY_ID, input.getParentCommentId()));
    }

    Comment comment = new Comment();
    comment.setContent(input.getContent());
    comment.setLessonStudentId(input.getLessonStudentId());
    comment.setUserId(SecurityUtil.getCurrentUserLogin());

    //stop comment level 2
    int count = 0;
    Comment checkComment = commentRepository.findById(parentComment.getParentId());
    for (int i = 1; i < 2; i++) {
      if (checkComment == null) {
        break;
      }
      count++;
      checkComment = commentRepository.findById(checkComment.getParentId());
    }
    if (count == 1) {
      comment.setParentId(parentComment.getParentId());
    } else {
      comment.setParentId(input.getParentCommentId());
    }
    commentRepository.createCommentForLessonStudent(comment);
    return new CreateChildrenCommentForLessonStudentOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }
}
