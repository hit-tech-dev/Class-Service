package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.lesson.UpdateLessonParameter;
import com.hit.classservice.application.input.lesson.UpdateLessonInput;
import com.hit.classservice.adapter.web.v1.transfer.parameter.lesson.CreateLessonParameter;
import com.hit.classservice.application.input.lesson.CreateLessonInput;
import com.hit.classservice.application.output.lesson.GetLessonDetailByIdItemOutput;
import com.hit.classservice.application.output.lesson.GetLessonDetailByIdOutput;
import com.hit.classservice.application.output.lesson.GetListLessonItemOutput;
import com.hit.classservice.domain.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {

  @Mappings({
      @Mapping(target = "id", source = "lesson.id"),
      @Mapping(target = "name", source = "lesson.name"),
      @Mapping(target = "content", source = "lesson.content"),
      @Mapping(target = "expiredTimeHomework", source = "lesson.expiredTimeHomework")
  })
  GetListLessonItemOutput toGetListLessonItemOutput(Lesson lesson);

  List<GetListLessonItemOutput> toGetListLessonBySubjectIdOutput(List<Lesson> lessons);

  UpdateLessonInput toUpdateLessonInput(UpdateLessonParameter parameter);
  CreateLessonInput toCreateLessonInput(CreateLessonParameter parameter);

  @Mappings({
      @Mapping(target = "id", source = "lesson.id"),
      @Mapping(target = "subjectId", source = "lesson.subjectId"),
      @Mapping(target = "name", source = "lesson.name"),
      @Mapping(target = "content", source = "lesson.content"),
      @Mapping(target = "expiredTimeHomework", source = "lesson.expiredTimeHomework"),
      @Mapping(target = "documents", source = "lesson.documents")
  })
  GetLessonDetailByIdItemOutput toGetLessonDetailByIdItemOutput(Lesson lesson);
  List<GetLessonDetailByIdItemOutput> toGetLessonDetailByIdOutput(List<Lesson> lessons);
}
