package com.hit.classservice.application.output.subject;

import com.hit.classservice.application.output.Output;
import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.domain.dto.SubjectDto;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListSubjectDetailOutput implements Output {

  JSONObject results;

}
