package com.hit.classservice.application.dai;

import com.hit.classservice.domain.entity.UserSubjectRelation;

import java.util.List;

public interface UserSubjectRelationRepository {

  List<UserSubjectRelation> getListUserSubjectRelationBySubjectId(Long subjectId);

  int deleteByUserIdAndSubjectId(String userId, Long subjectId);

}
