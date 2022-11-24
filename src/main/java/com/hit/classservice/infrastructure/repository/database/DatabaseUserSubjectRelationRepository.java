package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.UserSubjectRelationRepository;
import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.domain.dto.UserInSubjectDto;
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
  List<Subject> getListSubjectFromUserByUserId(@Param("userId") String userId);

  long countSearchUserInSubject(@Param("subjectId") Long subjectId, @Param("keyword") String keyword);

  @Override
  List<UserInSubjectDto> searchUserInSubject(@Param("subjectId") Long subjectId, @Param("keyword") String keyword,
                                             @Param("meta") PagingMeta meta);

}
