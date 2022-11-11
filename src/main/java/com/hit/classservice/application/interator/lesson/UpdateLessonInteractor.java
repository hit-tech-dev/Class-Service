package com.hit.classservice.application.interator.lesson;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.input.lesson.UpdateLessonInput;
import com.hit.classservice.application.input_boundary.lesson.UpdateLessonDataCase;
import com.hit.classservice.application.output.lesson.UpdateLessonOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Lesson;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationUpdateLessonInteractor")
public class UpdateLessonInteractor implements UpdateLessonDataCase {

  private final LessonRepository lessionRepository;

  public UpdateLessonInteractor(@Qualifier("DatabaseLessonRepository") LessonRepository lessionRepository) {
    this.lessionRepository = lessionRepository;
  }

  @Override
  public UpdateLessonOutput handle(UpdateLessonInput input) throws Exception {
    Lesson lesson = lessionRepository.findById(input.getId());

    if(ObjectUtils.isEmpty(lesson)) {
      throw new NotFoundException(UserMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID, input.getId()),
          new String[]{input.getId().toString()});
    }

    lesson.setName(input.getName());
    lesson.setContent(input.getContent());
    lesson.setExpiredTimeHomework(input.getExpiredTimeHomework());
    lessionRepository.update(lesson);
    return new UpdateLessonOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }
}
