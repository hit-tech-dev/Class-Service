package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.domain.dto.SubjectDto;
import com.hit.classservice.domain.entity.Subject;
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
  Subject findById(@Param("id") Long id);

  @Override
  int update(@Param("item") Subject subject);

  @Override
  Subject findByName(@Param("name") String name);

  @Override
  int delete(@Param("id") Long id);

  @Override
  int save(@Param("item") Subject subject);

}
