package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.domain.dto.*;
import com.hit.classservice.domain.entity.Subject;
import com.hit.classservice.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("DatabaseSubjectRepository")
public interface DatabaseSubjectRepository extends SubjectRepository {

  @Override
  long countSearchSubject(@Param("keyword") String keyword);

  @Override
  List<SubjectDto> searchSubject(@Param("keyword") String keyword, @Param("meta") PagingMeta meta);

  @Override
  List<SubjectCustomDTO> getListSubjectIsLeader(@Param("isLeader") Boolean isLeader, String userId);

  @Override
  List<SubjectCustomDTO> getListSubjectByCategoryId(@Param("categoryId") Long categoryId);

  @Override
  Subject findById(@Param("id") Long id);

  @Override
  int update(@Param("item") Subject subject);

  @Override
  Subject findByName(@Param("name") String name);

  @Override
  int delete(@Param("id") Long id);

  @Override
  int save(@Param("item") Subject subject);

  @Override
  List<UserDto> getAllLeader(@Param("id") Long subjectId, @Param("role") String role);

  @Override
  long countStudentSubject(@Param("id") Long subjectId, @Param("role") String role);

  @Override
  ScheduleDto getTimeSubject(@Param("id") Long subjectId);

  @Override
  List<StudentsRankingDto> getStudentsRankingBySubject(@Param("id") Long subjectId);
}
