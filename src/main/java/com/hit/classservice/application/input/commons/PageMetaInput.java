package com.hit.classservice.application.input.commons;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.SortByDataConstant;
import com.hit.classservice.application.input.Input;
import com.hit.classservice.application.utils.DataUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageMetaInput implements Input {

  private int pageNum;

  private int pageSize;

  private String sortType;

  private String sortBy;

  public String getSortType() {
    return DataUtil.standardizedSortType(sortType);
  }

  public String getSortBy(SortByDataConstant constant)  {
    return DataUtil.standardizedSortBy(sortBy, constant);
  }

  public int getPageNum() {
    if (pageNum <= 0) {
      pageNum = CommonConstant.ONE_VALUE.intValue();
    }
    return pageNum;
  }

  public int getPageSize() {
    if (pageSize <= 0) {
      pageSize = CommonConstant.PAGE_SIZE_DEFAULT;
    }
    return pageSize;
  }

}
