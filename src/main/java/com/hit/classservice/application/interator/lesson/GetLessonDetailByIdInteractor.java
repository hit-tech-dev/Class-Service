package com.hit.classservice.application.interator.lesson;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.dai.DocumentRepository;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.dai.LessonStudentRepository;
import com.hit.classservice.application.input.lesson.GetLessonDetailByIdInput;
import com.hit.classservice.application.input_boundary.lesson.GetLessonDetailByIdDatacase;
import com.hit.classservice.application.mapper.LessonMapper;
import com.hit.classservice.application.output.lesson.GetLessonDetailByIdOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Comment;
import com.hit.classservice.domain.entity.Document;
import com.hit.classservice.domain.entity.Lesson;
import com.hit.classservice.domain.entity.LessonStudent;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationGetLessonDetailByIdInteractor")
public class GetLessonDetailByIdInteractor implements GetLessonDetailByIdDatacase {

  private final LessonRepository lessonRepository;
  private final DocumentRepository documentRepository;
  private final LessonStudentRepository lessonStudentRepository;
  private final LessonMapper lessonMapper;
  private final CommentRepository commentRepository;

  public GetLessonDetailByIdInteractor(LessonRepository lessonRepository, DocumentRepository documentRepository, LessonStudentRepository lessonStudentRepository, CommentRepository commentRepository) {
    this.lessonRepository = lessonRepository;
    this.documentRepository = documentRepository;
    this.lessonStudentRepository = lessonStudentRepository;
    this.commentRepository = commentRepository;
    this.lessonMapper = Mappers.getMapper(LessonMapper.class);
  }

  @Override
  public GetLessonDetailByIdOutput handle(GetLessonDetailByIdInput input) throws Exception {
    List<Document> documents = documentRepository.getListDocumentByLessonId(input.getId());
    List<LessonStudent> lessonStudents = lessonStudentRepository.getListLessonStudentByLessonId(input.getId());
    List<Comment> comments = commentRepository.getListCommentByLessonId(input.getId());
    Lesson lesson = lessonRepository.findLessonDetailById(input.getId());
    if (ObjectUtils.isEmpty(lesson))
      throw new VsException(UserMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    lesson.setDocuments(documents);
    lesson.setLessonStudents(lessonStudents);
    lesson.setComments(comments);
    return lessonMapper.toGetLessonDetailByIdOutput(lesson);
  }
}
