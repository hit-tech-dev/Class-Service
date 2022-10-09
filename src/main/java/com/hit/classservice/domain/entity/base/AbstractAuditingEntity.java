package com.hit.classservice.domain.entity.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hit.classservice.application.utils.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractAuditingEntity implements Serializable {

  @JsonProperty("createdBy")
  private String createdBy = SecurityUtil.getCurrentUserLogin();

  @JsonProperty("createdDate")
  private Long createdDate;

  @JsonProperty("lastModifiedBy")
  private String lastModifiedBy = SecurityUtil.getCurrentUserLogin();

  @JsonProperty("lastModifiedDate")
  private Long lastModifiedDate;

  @JsonProperty("activeFlag")
  private boolean activeFlag;

  @JsonProperty("deleteFlag")
  private boolean deleteFlag;

}
