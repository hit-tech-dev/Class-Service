package com.hit.classservice.application.interator.lesson;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.input.lesson.GetListLessonBySubjectIdInput;
import com.hit.classservice.application.input_boundary.lesson.GetListLessonBySubjectIdDataCase;
import com.hit.classservice.application.mapper.LessonMapper;
import com.hit.classservice.application.output.lesson.GetListLessonBySubjectIdOutput;
import com.hit.classservice.application.output.lesson.GetListLessonItemOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Lesson;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationGetListLessonBySubjectIdInteractor")
public class GetListLessonBySubjectIdInteractor implements GetListLessonBySubjectIdDataCase {
  private final LessonRepository lessonRepository;
  private final LessonMapper lessonMapper;

  public GetListLessonBySubjectIdInteractor(@Qualifier("DatabaseLessonRepository") LessonRepository lessonRepository) {
    this.lessonRepository = lessonRepository;
    this.lessonMapper = Mappers.getMapper(LessonMapper.class);
  }

  @Override
  public GetListLessonBySubjectIdOutput handle(GetListLessonBySubjectIdInput input) throws Exception {
    List<Lesson> list = lessonRepository.getListLessonBySubjectId(input.getId());
    if (ObjectUtils.isEmpty(list)) {
      throw new VsException(UserMessageConstant.Lesson.ERR_NOT_FOUND_LESSON_BY_SUBJECT_ID,
          String.format(DevMessageConstant.Lesson.ERR_NOT_FOUND_LESSON_BY_SUBJECT_ID, input.getId()),
          new String[]{input.getId().toString()});
    }
    List<GetListLessonItemOutput> output = lessonMapper.toGetListLessonBySubjectIdOutput(list);
    return new GetListLessonBySubjectIdOutput(output);
  }

}
