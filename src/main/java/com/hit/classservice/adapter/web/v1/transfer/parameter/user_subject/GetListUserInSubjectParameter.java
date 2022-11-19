package com.hit.classservice.adapter.web.v1.transfer.parameter.user_subject;

import com.hit.classservice.adapter.web.v1.transfer.parameter.common.PagingMetaParameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetListUserInSubjectParameter extends PagingMetaParameter {

  private Long subjectId;

}
