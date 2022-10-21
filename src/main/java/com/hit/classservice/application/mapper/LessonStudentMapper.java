package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.lesson_student.CreateLessonStudentParameter;
import com.hit.classservice.application.input.lesson_student.CreateLessonStudentInput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonStudentMapper {

  CreateLessonStudentInput toCreateLessonStudentInput(CreateLessonStudentParameter parameter);

}
