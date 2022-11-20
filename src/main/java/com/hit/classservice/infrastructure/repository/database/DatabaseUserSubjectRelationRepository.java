package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.UserSubjectRelationRepository;
import com.hit.classservice.domain.entity.Subject;
import com.hit.classservice.domain.entity.UserSubjectRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository("DatabaseUserSubjectRelationRepository")
public interface DatabaseUserSubjectRelationRepository extends UserSubjectRelationRepository {

  @Override
  List<UserSubjectRelation> getListUserSubjectRelationBySubjectId(@Param("subjectId") Long subjectId);

  @Override
  int deleteByUserIdAndSubjectId(@Param("userId") String userId, @Param("subjectId") Long subjectId);

  @Override
  List<Subject> getListSubjectFromUserByUserId(@Param("user_id") String user_id);
}
