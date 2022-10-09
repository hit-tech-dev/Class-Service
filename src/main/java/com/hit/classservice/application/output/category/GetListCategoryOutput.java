package com.hit.classservice.application.output.category;

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
public class GetListCategoryOutput implements Output {

  private List<GetListCategoryItemOutput> items;

}
