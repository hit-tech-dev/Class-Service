package com.hit.classservice.application.output.subject;

import com.hit.classservice.application.output.Output;
import com.hit.classservice.application.output.common.PagingMeta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListSubjectOutput implements Output {

  List<GetListSubjectItemOutput> items;

  private PagingMeta meta;

}
