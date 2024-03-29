package com.hit.classservice.application.output.lesson;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListLessonDetailOutput implements Output {

  private List<GetListLessonDetailItemOutput> items;

}
