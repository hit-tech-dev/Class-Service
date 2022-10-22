package com.hit.classservice.application.interator.comment;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.input.comment.GetParentCommentsByLessonInput;
import com.hit.classservice.application.input_boundary.comment.GetParentCommentByLessonDataCase;
import com.hit.classservice.application.mapper.CommentMapper;
import com.hit.classservice.application.output.comment.GetParentCommentsByLessonItemOutput;
import com.hit.classservice.application.output.comment.GetParentCommentsByLessonOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.dto.ParentCommentDTO;
import com.hit.classservice.domain.entity.Lesson;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationGetParentCommentsByLessonInteractor")
public class GetParentCommentsByLessonInteractor implements GetParentCommentByLessonDataCase {
  private final CommentRepository commentRepository;
  private final LessonRepository lessonRepository;
  private final CommentMapper commentMapper;

  public GetParentCommentsByLessonInteractor(@Qualifier("DatabaseCommentRepository") CommentRepository commentRepository,
                                             @Qualifier("DatabaseLessonRepository") LessonRepository lessonRepository) {
    this.commentRepository = commentRepository;
    this.lessonRepository = lessonRepository;
    this.commentMapper = Mappers.getMapper(CommentMapper.class);
  }

  @SneakyThrows
  @Override
  public GetParentCommentsByLessonOutput handle(GetParentCommentsByLessonInput input) {
    Lesson oldLesson = lessonRepository.findById(input.getLessonId());
    //Check if lesson exists
    if (ObjectUtils.isEmpty(oldLesson)) {
      throw new VsException(UserMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID, input.getLessonId()),
          new String[]{input.getLessonId().toString()});
    }
    List<ParentCommentDTO> comments = commentRepository.findParentCommentByLesson(input.getLessonId());

    //Mapper to output
    List<GetParentCommentsByLessonItemOutput> output = commentMapper.toGetCommentsByLessonItemOutput(comments);
    return new GetParentCommentsByLessonOutput(output);
  }

}
