package com.hit.classservice.application.interator.subject;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.SortByDataConstant;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.subject.GetListSubjectInput;
import com.hit.classservice.application.input_boundary.subject.GetListSubjectDataCase;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.application.output.subject.GetListSubjectItemOutput;
import com.hit.classservice.application.output.subject.GetListSubjectOutput;
import com.hit.classservice.domain.dto.SubjectDto;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ApplicationGetListSubjectInteractor")
public class GetListSubjectInteractor implements GetListSubjectDataCase {
  private final SubjectRepository subjectRepository;
  private final SubjectMapper subjectMapper;

  public GetListSubjectInteractor(@Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository) {
    this.subjectRepository = subjectRepository;
    this.subjectMapper = Mappers.getMapper(SubjectMapper.class);
  }

  @SneakyThrows
  @Override
  public GetListSubjectOutput handle(GetListSubjectInput input) {

    String keyword = input.getKeyword().trim();
    Long total = subjectRepository.countSearchSubject(keyword);

    PagingMeta meta = new PagingMeta(total, input.getPageNum(), input.getPageSize(),
        input.getSortBy(SortByDataConstant.SUBJECT), input.getSortType());

    if (total.equals(CommonConstant.ZERO_VALUE)) {
      return new GetListSubjectOutput(new ArrayList<>(), meta);
    }

    List<SubjectDto> lstSubject = subjectRepository.searchSubject(keyword, meta);
    List<GetListSubjectItemOutput> output = subjectMapper.toGetListSubjectItemOutputs(lstSubject);

    return new GetListSubjectOutput(output, meta);
  }

}
