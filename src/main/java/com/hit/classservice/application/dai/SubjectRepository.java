package com.hit.classservice.application.dai;

import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.domain.dto.CategoryDto;
import com.hit.classservice.domain.dto.SubjectDto;
import com.hit.classservice.domain.entity.Subject;

import java.util.List;

public interface SubjectRepository {

  long countSearchSubject(String keyword);

  List<SubjectDto> searchSubject(String keyword, PagingMeta meta);

  Subject findById(Long id);

  int update(Subject subject);

  Subject findByName(String name);

  int delete(Long id);

  int save(Subject subject);

}
