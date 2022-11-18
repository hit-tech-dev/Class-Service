package com.hit.classservice.application.output.setting_by_key;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetSettingByKeyOutput implements Output {
  private Long id;

  private String key;

  private String value;
}
