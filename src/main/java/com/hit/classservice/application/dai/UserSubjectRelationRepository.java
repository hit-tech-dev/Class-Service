package com.hit.classservice.application.dai;

import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.domain.dto.UserInSubjectDto;
import com.hit.classservice.domain.entity.UserSubjectRelation;

import java.util.List;

public interface UserSubjectRelationRepository {

  List<UserSubjectRelation> getListUserSubjectRelationBySubjectId(Long subjectId);

  int deleteByUserIdAndSubjectId(String userId, Long subjectId);

  long countSearchUserInSubject(Long subjectId, String keyword);

  List<UserInSubjectDto> searchUserInSubject(Long subjectId, String keyword, PagingMeta meta);

}
