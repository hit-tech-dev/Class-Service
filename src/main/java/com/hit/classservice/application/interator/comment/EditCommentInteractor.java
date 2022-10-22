package com.hit.classservice.application.interator.comment;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.input.comment.EditCommentInput;
import com.hit.classservice.application.input_boundary.comment.EditCommentDataCase;
import com.hit.classservice.application.output.comment.EditCommentOutput;
import com.hit.classservice.application.utils.SecurityUtil;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Comment;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationEditCommentInteractor")
public class EditCommentInteractor implements EditCommentDataCase {

  private final CommentRepository commentRepository;

  private final LessonRepository lessonRepository;

  public EditCommentInteractor(@Qualifier("DatabaseCommentRepository") CommentRepository commentRepository,
                               @Qualifier("DatabaseLessonRepository") LessonRepository lessonRepository) {
    this.commentRepository = commentRepository;
    this.lessonRepository = lessonRepository;
  }

  @SneakyThrows
  @Override
  public EditCommentOutput handle(EditCommentInput input) throws Exception {
    Comment comment = commentRepository.findById(input.getId());

    // Find obj by id
    if (ObjectUtils.isEmpty(comment)) {
      throw new VsException(UserMessageConstant.Comment.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Comment.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    }

    // Check comment is from CurrentUserLogin
    if (comment.getUserId().compareTo(SecurityUtil.getCurrentUserLogin()) != 0) {
      throw new VsException(UserMessageConstant.Comment.ERR_NOT_YOURS,
          String.format(DevMessageConstant.Comment.ERR_NOT_YOURS, input.getId()),
          new String[]{input.getId().toString()});
    }

    comment.setContent(input.getContent());
    commentRepository.editComment(comment);
    return new EditCommentOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }
}
