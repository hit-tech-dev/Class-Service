package com.hit.classservice.application.input.commons;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.utils.SqlUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindDataInput extends PageMetaInput {
  private String keyword;

  public String getKeyword() {
    if (StringUtils.isNotEmpty(keyword)) {
      return SqlUtil.escapeSQLLikeStatement(keyword.trim());
    }
    return CommonConstant.EMPTY_STRING;
  }

}
