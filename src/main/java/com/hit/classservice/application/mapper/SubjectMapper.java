package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.common.PagingMetaParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.subject.CreateSubjectParam;
import com.hit.classservice.adapter.web.v1.transfer.parameter.subject.GetStudentsRankingBySubjectParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.subject.UpdateSubjectParameter;
import com.hit.classservice.application.input.subject.CreateSubjectInput;
import com.hit.classservice.application.input.subject.GetListSubjectInput;
import com.hit.classservice.application.input.subject.GetStudentsRankingBySubjectInput;
import com.hit.classservice.application.input.subject.UpdateSubjectInput;
import com.hit.classservice.application.output.subject.GetListSubjectItemOutput;
import com.hit.classservice.application.output.subject.GetStudentsRankingBySubjectItemOutput;
import com.hit.classservice.application.output.subject.GetSubjectOutput;
import com.hit.classservice.application.output.user_subject.GetAllLeaderItemOutput;
import com.hit.classservice.domain.dto.StudentsRankingDto;
import com.hit.classservice.domain.dto.SubjectDto;
import com.hit.classservice.domain.dto.UserDto;
import com.hit.classservice.domain.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

  List<GetListSubjectItemOutput> toGetListSubjectItemOutputs(List<SubjectDto> subjectDtos);

  List<GetAllLeaderItemOutput> toGetAllLeaderItemOutputs(List<UserDto> userDtos);

  List<GetStudentsRankingBySubjectItemOutput> toGetStudentsRankingBySubjectItemOutput(List<StudentsRankingDto> rankingDtos);

  GetSubjectOutput toGetSubjectOutput(Subject subject);

  @Mappings({
      @Mapping(target = "id", source = "input.id"),
      @Mapping(target = "name", source = "input.name"),
      @Mapping(target = "description", source = "input.description"),
      @Mapping(target = "studyForm", source = "input.studyForm"),
      @Mapping(target = "studyPlace", source = "input.studyPlace")
  })
  Subject toSubject(UpdateSubjectInput input);

  @Mappings({
      @Mapping(target = "id", source = "parameter.id"),
      @Mapping(target = "name", source = "parameter.name"),
      @Mapping(target = "file", source = "parameter.file"),
      @Mapping(target = "description", source = "parameter.description")
  })
  UpdateSubjectInput toUpdateSubjectInput(UpdateSubjectParameter parameter);

  @Mappings({
      @Mapping(target = "name", source = "createSubjectParam.name"),
      @Mapping(target = "file", source = "createSubjectParam.file"),
      @Mapping(target = "description", source = "createSubjectParam.description"),
      @Mapping(target = "categoryId", source = "createSubjectParam.categoryId"),
      @Mapping(target = "studyForm", source = "createSubjectParam.studyForm"),
      @Mapping(target = "studyPlace", source = "createSubjectParam.studyPlace")})
  CreateSubjectInput toCreateSubjectInput(CreateSubjectParam createSubjectParam);

  GetListSubjectInput toGetListSubjectInput(PagingMetaParameter parameter);

  Subject toSubject(CreateSubjectInput input);

  GetStudentsRankingBySubjectInput toGetStudentsRankingBySubjectInput(GetStudentsRankingBySubjectParameter parameter);

}
