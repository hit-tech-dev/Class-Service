package com.hit.classservice.application.output.category;

import com.hit.classservice.application.output.common.CreatedBy;
import com.hit.classservice.application.output.common.LastModifiedBy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListCategoryItemOutput {

  private Long id;

  private String name;

  private String description;

  private Long createdDate;

  private CreatedBy createdBy;

  private LastModifiedBy lastModifiedBy;

}
