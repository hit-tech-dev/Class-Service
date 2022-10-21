package com.hit.classservice.application.output.lesson;

import com.hit.classservice.application.output.Output;
import com.hit.classservice.domain.entity.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListLessonBySubjectIdOutput implements Output {

  private List<GetListLessonItemOutput> items;
}
