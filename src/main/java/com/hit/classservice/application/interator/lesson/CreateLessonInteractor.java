package com.hit.classservice.application.interator.lesson;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.dai.LessonStudentRepository;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.dai.UserSubjectRelationRepository;
import com.hit.classservice.application.input.lesson.CreateLessonInput;
import com.hit.classservice.application.input_boundary.lesson.CreateLessonDataCase;
import com.hit.classservice.application.output.lesson.CreateLessonOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.domain.entity.Lesson;
import com.hit.classservice.domain.entity.LessonStudent;
import com.hit.classservice.domain.entity.Subject;
import com.hit.classservice.domain.entity.UserSubjectRelation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationCreateLessonInteractor")
public class CreateLessonInteractor implements CreateLessonDataCase {
  private final LessonRepository lessonRepository;
  private final SubjectRepository subjectRepository;
  private final LessonStudentRepository lessonStudentRepository;
  private final UserSubjectRelationRepository userSubjectRelationRepository;

  public CreateLessonInteractor(@Qualifier("DatabaseLessonRepository") LessonRepository lessonRepository,
                                @Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository,
                                @Qualifier("DatabaseLessonStudentRepository") LessonStudentRepository lessonStudentRepository,
                                @Qualifier("DatabaseUserSubjectRelationRepository") UserSubjectRelationRepository userSubjectRelationRepository) {
    this.lessonRepository = lessonRepository;
    this.subjectRepository = subjectRepository;
    this.lessonStudentRepository = lessonStudentRepository;
    this.userSubjectRelationRepository = userSubjectRelationRepository;
  }

  @Override
  public CreateLessonOutput handle(CreateLessonInput input) throws Exception {
    Subject oldSubject = subjectRepository.findById(input.getSubjectId());
    if (ObjectUtils.isEmpty(oldSubject)) {
      throw new NotFoundException(UserMessageConstant.Subject.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Subject.ERR_NOT_FOUND_BY_ID, input.getSubjectId()),
          new String[]{input.getSubjectId().toString()});
    }

    // Save lesson
    Lesson lesson = new Lesson(input.getName(), input.getContent(), input.getExpiredTimeHomework(),
        input.getSubjectId());
    lessonRepository.save(lesson);

    /**
     * Get list UserSubjectRelation by subjectId
     * to get User already registered for that subject
     */
    List<UserSubjectRelation> userSubjectRelations =
        userSubjectRelationRepository.getListUserSubjectRelationBySubjectId(input.getSubjectId());

    // Create records LessonStudent to manage user per lesson
    for (UserSubjectRelation userSubjectRelation : userSubjectRelations) {
      LessonStudent lessonStudent = new LessonStudent(lesson.getId(), userSubjectRelation.getUserId(), false);
      lessonStudentRepository.save(lessonStudent);
    }

    return new CreateLessonOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
  }

}
