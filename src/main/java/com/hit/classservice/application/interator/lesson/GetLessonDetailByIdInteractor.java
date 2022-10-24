package com.hit.classservice.application.interator.lesson;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.lesson.GetListLessonDetailBySubjectIdInput;
import com.hit.classservice.application.input_boundary.lesson.GetLessonDetailByIdDataCase;
import com.hit.classservice.application.mapper.LessonMapper;
import com.hit.classservice.application.output.lesson.GetListLessonDetailOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.domain.dto.LessonDetailDto;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationGetLessonDetailByIdInteractor")
public class GetLessonDetailByIdInteractor implements GetLessonDetailByIdDataCase {
  private final LessonRepository lessonRepository;
  private final SubjectRepository subjectRepository;
  private final LessonMapper lessonMapper;

  public GetLessonDetailByIdInteractor(@Qualifier("DatabaseLessonRepository") LessonRepository lessonRepository,
                                       @Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository) {
    this.lessonRepository = lessonRepository;
    this.subjectRepository = subjectRepository;
    this.lessonMapper = Mappers.getMapper(LessonMapper.class);
  }

  @Override
  public GetListLessonDetailOutput handle(GetListLessonDetailBySubjectIdInput input) throws Exception {
    if (ObjectUtils.isEmpty(subjectRepository.findById(input.getSubjectId()))) {
      throw new NotFoundException(UserMessageConstant.Subject.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Subject.ERR_NOT_FOUND_BY_ID, input.getSubjectId()),
          new String[]{String.valueOf(input.getSubjectId())});
    }

    List<LessonDetailDto> items = lessonRepository.findAllLessonDetailBySubjectId(input.getSubjectId());

    return new GetListLessonDetailOutput(lessonMapper.toGetListLessonDetailItemOutputs(items));
  }
}
