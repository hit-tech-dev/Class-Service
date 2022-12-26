package com.hit.classservice.application.output.subject;

import com.hit.classservice.application.output.Output;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetStudentsRankingBySubjectItemOutput implements Output {

   private String id;

   private String fullName;

   private String avatar;

   private Boolean isIncrement;

   private String totalMark;
}
