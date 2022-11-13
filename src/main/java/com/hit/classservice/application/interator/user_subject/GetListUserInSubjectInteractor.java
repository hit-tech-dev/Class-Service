package com.hit.classservice.application.interator.user_subject;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.SortByDataConstant;
import com.hit.classservice.application.dai.UserSubjectRelationRepository;
import com.hit.classservice.application.input.user_subject.GetListUserInSubjectInput;
import com.hit.classservice.application.input_boundary.user_subject.GetListUserInSubjectRepositoryDataCase;
import com.hit.classservice.application.mapper.UserSubjectMapper;
import com.hit.classservice.application.output.common.PagingMeta;
import com.hit.classservice.application.output.user_subject.GetListUserInSubjectItemOutput;
import com.hit.classservice.application.output.user_subject.GetListUserInSubjectOutput;
import com.hit.classservice.domain.dto.UserInSubjectDto;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ApplicationGetListUserInSubjectInteractor")
public class GetListUserInSubjectInteractor implements GetListUserInSubjectRepositoryDataCase {

  private final UserSubjectRelationRepository userSubjectRelationRepository;
  private final UserSubjectMapper userSubjectMapper;


  public GetListUserInSubjectInteractor(@Qualifier("DatabaseUserSubjectRelationRepository") UserSubjectRelationRepository userSubjectRelationRepository) {
    this.userSubjectRelationRepository = userSubjectRelationRepository;
    this.userSubjectMapper = Mappers.getMapper(UserSubjectMapper.class);
  }

  @SneakyThrows
  @Override
  public GetListUserInSubjectOutput handle(GetListUserInSubjectInput input) {
    String keyword = input.getKeyword().trim();
    Long total = userSubjectRelationRepository.countSearchUserInSubject(input.getSubjectId(), keyword);

    PagingMeta meta = new PagingMeta(total, input.getPageNum(), input.getPageSize(), input.getSortBy(SortByDataConstant.USER_SUBJECT), input.getSortType());

    if (total.equals(CommonConstant.ZERO_VALUE)) {
      return new GetListUserInSubjectOutput(new ArrayList<>(), meta);
    }

    List<UserInSubjectDto> lst = userSubjectRelationRepository.searchUserInSubject(input.getSubjectId(), keyword, meta);

    List<GetListUserInSubjectItemOutput> output = userSubjectMapper.toGetListUserInSubjectItemOutputs(lst);

    return new GetListUserInSubjectOutput(output, meta);
  }
}
