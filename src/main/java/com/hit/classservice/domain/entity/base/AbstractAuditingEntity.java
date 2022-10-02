package com.hit.classservice.domain.entity.base;

import com.fasterxml.jackson.annotation.JsonProperty;
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
  private String createdBy;

  @JsonProperty("createdDate")
  private Long createdDate;

  @JsonProperty("lastModifiedBy")
  private String lastModifiedBy;

  @JsonProperty("lastModifiedDate")
  private Long lastModifiedDate;

}
