package com.hit.classservice.application.output.role;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetListRoleOutput implements Output {

  private List<GetListRoleItemOutput> items;

}
