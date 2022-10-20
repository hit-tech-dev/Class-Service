package com.hit.classservice.application.interator.lesson_student;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.dai.LessonStudentRepository;
import com.hit.classservice.application.dai.UserRepository;
import com.hit.classservice.application.input.lesson_student.CreateLessonStudentInput;
import com.hit.classservice.application.input_boundary.lesson_student.CreateLessonStudentDataCase;
import com.hit.classservice.application.output.lesson_student.CreateLessonStudentOutput;
import com.hit.classservice.domain.entity.Lesson;
import com.hit.classservice.domain.entity.LessonStudent;
import com.hit.classservice.domain.entity.User;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateLessonStudentInteractor")
public class CreateLessonStudentInteractor implements CreateLessonStudentDataCase {


  private final LessonRepository lessonRepository;
  private final LessonStudentRepository lessonStudentRepository;
  private final UserRepository userRepository;

  public CreateLessonStudentInteractor(@Qualifier("DatabaseLessonRepository") LessonRepository lessonRepository,
                                       @Qualifier("DatabaseLessonStudentRepository") LessonStudentRepository lessonStudentRepository,
                                       @Qualifier("DatabaseUserRepository") UserRepository userRepository) {
    this.lessonRepository = lessonRepository;
    this.lessonStudentRepository = lessonStudentRepository;
    this.userRepository = userRepository;
  }

  @Override
  public CreateLessonStudentOutput handle(CreateLessonStudentInput input) throws Exception {
    Lesson oldLesson = lessonRepository.findById(input.getLessonId());
    if (ObjectUtils.isEmpty(oldLesson)) {
      return new CreateLessonStudentOutput(CommonConstant.FALSE,
          String.format(DevMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID, input.getLessonId()));
    }

    User oldUser = userRepository.findById(input.getUserId());
    if (ObjectUtils.isEmpty(oldUser)) {
      return new CreateLessonStudentOutput(CommonConstant.FALSE,
          String.format(DevMessageConstant.User.ERR_NOT_FOUND_BY_ID, input.getUserId()));
    }

    LessonStudent lessonStudent = new LessonStudent(input.getLessonId(), input.getUserId(), input.isAttendance());
    lessonStudentRepository.save(lessonStudent);

    return new CreateLessonStudentOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }
}
