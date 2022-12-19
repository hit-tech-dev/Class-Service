package com.hit.classservice.application.output.subject;

import com.hit.classservice.application.output.Output;
import com.hit.classservice.domain.dto.UserDto;
import com.hit.classservice.domain.entity.User;
import com.nimbusds.jose.shaded.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetSubjectOutput implements Output {

  private Long id;

  private String name;

  private List<UserDto> leaders;

  private JSONObject detail;

}
