package com.hit.classservice.application.dai;

import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.domain.dto.CategoryDto;
import com.hit.classservice.domain.dto.ScheduleDto;
import com.hit.classservice.domain.dto.SubjectCustomDTO;
import com.hit.classservice.domain.dto.SubjectDto;
import com.hit.classservice.domain.dto.UserDto;
import com.hit.classservice.domain.entity.Schedule;
import com.hit.classservice.domain.entity.Subject;
import com.hit.classservice.domain.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectRepository {

  long countSearchSubject(String keyword);

  List<SubjectDto> searchSubject(String keyword, PagingMeta meta);

  List<SubjectCustomDTO> getListSubjectIsLeader(@Param("isLeader") Boolean isLeader, @Param("userId") String userId);

  List<SubjectCustomDTO> getListSubjectByCategoryId(@Param("categoryId") Long categoryId);

  Subject findById(Long id);

  int update(Subject subject);

  Subject findByName(String name);

  int delete(Long id);

  int save(Subject subject);

  List<UserDto> getAllLeader(Long subjectId, String role);

  long countStudentSubject(Long id, String role);

  ScheduleDto getTimeSubject(Long id);

}
