package com.hit.classservice.application.output.user_subject;

import com.hit.classservice.application.output.Output;
import com.hit.classservice.application.output.common.PagingMeta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetListUserInSubjectOutput implements Output {

  private List<GetListUserInSubjectItemOutput> item;

  private PagingMeta meta;

}
