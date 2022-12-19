package com.hit.classservice.application.interator.subject;

import com.hit.classservice.application.dai.CategoryRepository;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.subject.GetListSubjectDetailInput;
import com.hit.classservice.application.input_boundary.subject.GetListSubjectDetailDataCase;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.subject.GetListSubjectDetailOutput;
import com.hit.classservice.application.output.subject.GetListSubjectItemOutput;
import com.hit.classservice.application.output.subject.GetListSubjectOutput;
import com.hit.classservice.application.utils.SecurityUtil;
import com.hit.classservice.domain.dto.CategoryDto;
import com.hit.classservice.domain.dto.SubjectCustomDTO;
import com.hit.classservice.domain.dto.SubjectDto;
import com.hit.classservice.domain.entity.Category;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ApplicationGetListSubjectDetailInteractor")
public class GetListSubjectDetailInteractor implements GetListSubjectDetailDataCase {
  private final SubjectRepository subjectRepository;
  private final CategoryRepository categoryRepository;
  private final SubjectMapper subjectMapper;

  public GetListSubjectDetailInteractor(@Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository,
                                        @Qualifier("DatabaseCategoryRepository") CategoryRepository categoryRepository) {
    this.subjectRepository = subjectRepository;
    this.categoryRepository = categoryRepository;
    this.subjectMapper = Mappers.getMapper(SubjectMapper.class);
  }

  @Override
  public GetListSubjectDetailOutput handle(GetListSubjectDetailInput input) throws Exception {
    String currentUserLogin = SecurityUtil.getCurrentUserLogin();
    JSONObject results = new JSONObject();

    results.put("mySubjectManagement", subjectRepository.getListSubjectIsLeader(true, currentUserLogin));
    results.put("mySubject", subjectRepository.getListSubjectIsLeader(false, currentUserLogin));

    JSONArray lstSubject = new JSONArray();
    List<Category> categories = categoryRepository.getAllCategory();
    categories.forEach(c -> {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("category", c.getName());
      jsonObject.put("items", subjectRepository.getListSubjectByCategoryId(c.getId()));
      lstSubject.add(jsonObject);
    });
    results.put("lstSubject", lstSubject);

    return new GetListSubjectDetailOutput(results);
  }
}
