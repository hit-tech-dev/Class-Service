package com.hit.classservice.application.interator.comment;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.input.comment.DeleteCommentInput;
import com.hit.classservice.application.input_boundary.comment.DeleteCommentDataCase;
import com.hit.classservice.application.output.comment.DeleteCommentOutput;
import com.hit.classservice.application.utils.SecurityUtil;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Comment;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationDeleteCommentInteractor")
public class DeleteCommentInteractor implements DeleteCommentDataCase {
  private final CommentRepository commentRepository;

  public DeleteCommentInteractor(@Qualifier("DatabaseCommentRepository") CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  @Override
  public DeleteCommentOutput handle(DeleteCommentInput input) throws Exception {
    // Find obj by id
    Comment oldComment = commentRepository.findById(input.getId());
    if (ObjectUtils.isEmpty(oldComment)) {
      throw new VsException(UserMessageConstant.Comment.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Comment.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    }

    // Check comment is from CurrentUserLogin
    if (oldComment.getUserId().compareTo(SecurityUtil.getCurrentUserLogin()) != 0) {
      throw new VsException(UserMessageConstant.Comment.ERR_NOT_YOURS,
          String.format(DevMessageConstant.Comment.ERR_NOT_YOURS, input.getId()),
          new String[]{input.getId().toString()});
    }

    // Delete comment children
    List<Comment> commentsChildren = commentRepository.findByParentId(input.getId());
    for (Comment c : commentsChildren) {
      commentRepository.delete(c.getId());
    }

    // Delete comment parent
    commentRepository.delete(input.getId());

    return new DeleteCommentOutput(CommonConstant.TRUE, "Delete successful");
  }

}
