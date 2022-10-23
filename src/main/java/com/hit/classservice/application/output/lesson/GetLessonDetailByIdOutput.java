package com.hit.classservice.application.output.lesson;

import com.hit.classservice.application.output.Output;
import com.hit.classservice.domain.entity.Comment;
import com.hit.classservice.domain.entity.Document;
import com.hit.classservice.domain.entity.LessonStudent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetLessonDetailByIdOutput implements Output {

  private List<GetLessonDetailByIdItemOutput> items;
}
