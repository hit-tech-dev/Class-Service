package com.hit.classservice.application.interator.user_subject;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.dai.UserRepository;
import com.hit.classservice.application.dai.UserSubjectRelationRepository;
import com.hit.classservice.application.input.user_subject.RemoveUserFromSubjectInput;
import com.hit.classservice.application.input_boundary.user_subject.RemoveUserFromSubjectDataCase;
import com.hit.classservice.application.output.user_subject.RemoveUserFromSubjectOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Subject;
import com.hit.classservice.domain.entity.User;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationRemoveUserFromSubjectInteractor")
public class RemoveUserFromFromSubjectInteractor implements RemoveUserFromSubjectDataCase {
  private final UserSubjectRelationRepository userSubjectRelationRepository;
  private final UserRepository userRepository;
  private final SubjectRepository subjectRepository;

  public RemoveUserFromFromSubjectInteractor(@Qualifier("DatabaseUserSubjectRelationRepository") UserSubjectRelationRepository userSubjectRelationRepository, @Qualifier("DatabaseUserRepository") UserRepository userRepository, @Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository) {
    this.userSubjectRelationRepository = userSubjectRelationRepository;
    this.userRepository = userRepository;
    this.subjectRepository = subjectRepository;
  }

  @SneakyThrows
  @Override
  public RemoveUserFromSubjectOutput handle(RemoveUserFromSubjectInput input) {
    User user = userRepository.findById(input.getUserId());
    if (ObjectUtils.isEmpty(user)) {
      throw new VsException(UserMessageConstant.User.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.User.ERR_NOT_FOUND_BY_ID, input.getUserId()),
          new String[]{input.getUserId()});
    }

    Subject subject = subjectRepository.findById(input.getSubjectId());
    if (ObjectUtils.isEmpty(subject)) {
      throw new VsException(UserMessageConstant.Subject.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Subject.ERR_NOT_FOUND_BY_ID, input.getSubjectId()),
          new String[]{input.getSubjectId().toString()});
    }

    // Delete relation
    int res = userSubjectRelationRepository.deleteByUserIdAndSubjectId(input.getUserId(), input.getSubjectId());

    if (res == 0) {
      throw new VsException(UserMessageConstant.ERR_EXCEPTION_GENERAL,
          String.format(DevMessageConstant.UserSubjectRelation.CAN_NOT_REMOVE_OBJECT, input.getUserId(), input.getSubjectId()));
    }

    return new RemoveUserFromSubjectOutput(CommonConstant.TRUE, "Delete successful");
  }
}
