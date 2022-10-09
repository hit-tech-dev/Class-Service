package com.hit.classservice.application.output.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListSubjectItemOutput {

    private Long id;

    private String name;

    private String avatar;

    private String description;
}
