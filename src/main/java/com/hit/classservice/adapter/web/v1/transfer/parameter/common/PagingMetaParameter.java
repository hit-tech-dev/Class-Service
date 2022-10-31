package com.hit.classservice.adapter.web.v1.transfer.parameter.common;

import com.hit.classservice.application.constant.CommonConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagingMetaParameter {

  private Integer pageNum;

  private Integer pageSize;

  private String sortBy = CommonConstant.EMPTY_STRING;

  private String sortType = CommonConstant.EMPTY_STRING;

  private String keyword = CommonConstant.EMPTY_STRING;

}
