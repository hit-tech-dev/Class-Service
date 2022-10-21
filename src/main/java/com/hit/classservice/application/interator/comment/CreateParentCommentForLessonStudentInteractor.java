package com.hit.classservice.application.interator.comment;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.dai.LessonStudentRepository;
import com.hit.classservice.application.input.comment.CreateParentCommentForLessonStudentInput;
import com.hit.classservice.application.input_boundary.comment.CreateParentCommentForLessonStudentDataCase;
import com.hit.classservice.application.output.comment.CreateParentCommentForLessonStudentOutput;
import com.hit.classservice.application.utils.SecurityUtil;
import com.hit.classservice.domain.entity.Comment;
import com.hit.classservice.domain.entity.LessonStudent;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateParentCommentForLessonStudentInteractor")
public class CreateParentCommentForLessonStudentInteractor implements CreateParentCommentForLessonStudentDataCase {
  private final CommentRepository commentRepository;
  private final LessonStudentRepository lessonStudentRepository;

  public CreateParentCommentForLessonStudentInteractor(@Qualifier("DatabaseCommentRepository") CommentRepository commentRepository,
                                                       @Qualifier("DatabaseLessonStudentRepository") LessonStudentRepository lessonStudentRepository) {
    this.commentRepository = commentRepository;
    this.lessonStudentRepository = lessonStudentRepository;
  }

  @SneakyThrows
  @Override
  public CreateParentCommentForLessonStudentOutput handle(CreateParentCommentForLessonStudentInput input) {
    LessonStudent oldLessonStudent = lessonStudentRepository.findById(input.getLessonStudentId());
    if (ObjectUtils.isEmpty(oldLessonStudent)) {
      return new CreateParentCommentForLessonStudentOutput(CommonConstant.FALSE, String.format(
          DevMessageConstant.LessonStudent.ERR_NOT_FOUND_BY_ID, input.getLessonStudentId()));
    }

    Comment comment = new Comment();
    comment.setContent(input.getContent());
    comment.setLessonStudentId(input.getLessonStudentId());
    comment.setUserId(SecurityUtil.getCurrentUserLogin());
    comment.setParentId(null);
    commentRepository.createCommentForLessonStudent(comment);
    return new CreateParentCommentForLessonStudentOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }

}
