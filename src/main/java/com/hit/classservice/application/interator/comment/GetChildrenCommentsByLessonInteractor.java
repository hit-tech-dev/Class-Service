package com.hit.classservice.application.interator.comment;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.input.comment.GetChildrenCommentsByLessonInput;
import com.hit.classservice.application.input_boundary.comment.GetChildrenCommentsByLessonDataCase;
import com.hit.classservice.application.mapper.CommentMapper;
import com.hit.classservice.application.output.comment.GetChildrenCommentsByLessonItemOutput;
import com.hit.classservice.application.output.comment.GetChildrenCommentsByLessonOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Comment;
import com.hit.classservice.domain.entity.Lesson;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationGetChildrenCommentsByLessonInteractor")
public class GetChildrenCommentsByLessonInteractor implements GetChildrenCommentsByLessonDataCase {

  private final CommentRepository commentRepository;

  private final LessonRepository lessonRepository;

  private final CommentMapper commentMapper;

  public GetChildrenCommentsByLessonInteractor(@Qualifier("DatabaseCommentRepository") CommentRepository commentRepository,
                                               @Qualifier("DatabaseLessonRepository") LessonRepository lessonRepository) {
    this.commentRepository = commentRepository;
    this.lessonRepository = lessonRepository;
    this.commentMapper = Mappers.getMapper(CommentMapper.class);
  }

  @Override
  public GetChildrenCommentsByLessonOutput handle(GetChildrenCommentsByLessonInput input) throws Exception {
    Lesson oldLesson = lessonRepository.findById(input.getLessonId());
    Comment parentComment = commentRepository.findById(input.getParentId());
    if (ObjectUtils.isEmpty(oldLesson)) {
      throw new VsException(UserMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID, input.getLessonId()),
          new String[]{input.getLessonId().toString()});
    }
    if(ObjectUtils.isEmpty(parentComment)) {
      throw new VsException(UserMessageConstant.Comment.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Comment.ERR_NOT_FOUND_BY_ID, input.getParentId()),
          new String[]{input.getParentId().toString()});
    }

    List<Comment> comments = commentRepository.findChildrenCommentByLessonAndParentComment(input.getLessonId(), input.getParentId());

    List<GetChildrenCommentsByLessonItemOutput> output = commentMapper.toGetChildrenCommentsByLessonOutput(comments);
    return new GetChildrenCommentsByLessonOutput(output);
  }
}
