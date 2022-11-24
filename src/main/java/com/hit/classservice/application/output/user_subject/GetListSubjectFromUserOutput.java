package com.hit.classservice.application.output.user_subject;

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
public class GetListSubjectFromUserOutput implements Output {

  private List<GetSubjectFromUserItemOutput> items;

}
