package com.hit.classservice.application.output.schedule;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetScheduleByIdOutput implements Output {

  private Long id;

  private String name;

  private String internalName;

  private String session;

  private String timeDetail;

}
