package com.hit.classservice.application.interator.lesson_student;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.dai.LessonStudentRepository;
import com.hit.classservice.application.dai.UserRepository;
import com.hit.classservice.application.input.lesson_student.CreateTicketCheckAttendanceInput;
import com.hit.classservice.application.input_boundary.lesson_student.CreateTicketCheckAttendanceDataCase;
import com.hit.classservice.application.output.lesson_student.CreateTicketCheckAttendanceOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.domain.entity.Lesson;
import com.hit.classservice.domain.entity.LessonStudent;
import com.hit.classservice.domain.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service("ApplicationCreateTicketCheckInteractor")
public class CreateTicketCheckInteractor implements CreateTicketCheckAttendanceDataCase {

  private final LessonRepository lessonRepository;
  private final UserRepository userRepository;
  private final LessonStudentRepository lessonStudentRepository;

  public CreateTicketCheckInteractor(@Qualifier("DatabaseLessonRepository") LessonRepository lessonRepository,
                                     @Qualifier("DatabaseUserRepository") UserRepository userRepository,
                                     @Qualifier("DatabaseLessonStudentRepository") LessonStudentRepository lessonStudentRepository) {
    this.lessonRepository = lessonRepository;
    this.userRepository = userRepository;
    this.lessonStudentRepository = lessonStudentRepository;
  }


  @Override
  public CreateTicketCheckAttendanceOutput handle(CreateTicketCheckAttendanceInput input) throws Exception {
    Lesson lesson = lessonRepository.findById(input.getLessonId());
    if (ObjectUtils.isEmpty(lesson)) {
      throw new NotFoundException(UserMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID, input.getLessonId()),
          new String[]{input.getLessonId().toString()});
    }
    User user = userRepository.findById(input.getUserId());
    if (ObjectUtils.isEmpty(user)) {
      throw new NotFoundException(UserMessageConstant.User.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.User.ERR_NOT_FOUND_BY_ID, input.getUserId()),
          new String[]{input.getUserId().toString()});
    }
    LessonStudent lessonStudent = new LessonStudent(input.getLessonId(), input.getUserId(),input.isAttendance());
    lessonStudentRepository.update(lessonStudent);
    return new CreateTicketCheckAttendanceOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }
}
