package com.hit.classservice.application.interator.comment;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.input.comment.CreateParentCommentForLessonInput;
import com.hit.classservice.application.input_boundary.comment.CreateParentCommentForLessonDataCase;
import com.hit.classservice.application.output.comment.CreateParentCommentForLessonOutput;
import com.hit.classservice.application.utils.SecurityUtil;
import com.hit.classservice.domain.entity.Comment;
import com.hit.classservice.domain.entity.Lesson;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateParentCommentForLessonInteractor")
public class CreateParentCommentForLessonInteractor implements CreateParentCommentForLessonDataCase {

  private final CommentRepository commentRepository;

  private final LessonRepository lessonRepository;

  public CreateParentCommentForLessonInteractor(@Qualifier("DatabaseCommentRepository") CommentRepository commentRepository,
                                                @Qualifier("DatabaseLessonRepository") LessonRepository lessonRepository) {
    this.commentRepository = commentRepository;
    this.lessonRepository = lessonRepository;
  }

  @SneakyThrows
  @Override
  public CreateParentCommentForLessonOutput handle(CreateParentCommentForLessonInput input) {
    Lesson oldLesson = lessonRepository.findById(input.getLessonId());
    if (ObjectUtils.isEmpty(oldLesson)) {
      return new CreateParentCommentForLessonOutput(CommonConstant.FALSE, String.format(
          DevMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID, input.getLessonId()));
    }

    Comment comment = new Comment();
    comment.setContent(input.getContent());
    comment.setLessonId(input.getLessonId());
    comment.setUserId(SecurityUtil.getCurrentUserLogin());
    comment.setParentId(null);
    commentRepository.createCommentForLesson(comment);
    return new CreateParentCommentForLessonOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }
}
