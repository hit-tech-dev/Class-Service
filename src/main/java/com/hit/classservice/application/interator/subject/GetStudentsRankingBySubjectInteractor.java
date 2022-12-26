package com.hit.classservice.application.interator.subject;

import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.subject.GetStudentsRankingBySubjectInput;
import com.hit.classservice.application.input_boundary.subject.GetStudentsRankingBySubjectDataCase;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.subject.GetStudentsRankingBySubjectItemOutput;
import com.hit.classservice.application.output.subject.GetStudentsRankingBySubjectOutput;
import com.hit.classservice.config.exception.NotFoundException;
import com.hit.classservice.domain.dto.StudentsRankingDto;
import com.hit.classservice.domain.entity.Subject;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ApplicationGetStudentsRankingBySubjectInteractor")
public class GetStudentsRankingBySubjectInteractor implements GetStudentsRankingBySubjectDataCase {

  private final SubjectRepository subjectRepository;

  private final SubjectMapper subjectMapper;

  public GetStudentsRankingBySubjectInteractor(@Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository) {
    this.subjectRepository = subjectRepository;
    this.subjectMapper = Mappers.getMapper(SubjectMapper.class);
  }

  @SneakyThrows
  @Override
  public GetStudentsRankingBySubjectOutput handle(GetStudentsRankingBySubjectInput input) {
    Subject subject = subjectRepository.findById(input.getSubjectId());

    if (ObjectUtils.isEmpty(subject))
      throw new NotFoundException(UserMessageConstant.Subject.ERR_NOT_FOUND_BY_ID,
          String.format(DevMessageConstant.Subject.ERR_NOT_FOUND_BY_ID, input.getSubjectId()),
          new String[]{input.getSubjectId().toString()});

    //Xử lý trending sau

    List<StudentsRankingDto> rankings = subjectRepository.getStudentsRankingBySubject(input.getSubjectId());
    List<GetStudentsRankingBySubjectItemOutput> output = subjectMapper.toGetStudentsRankingBySubjectItemOutput(rankings);
    return new GetStudentsRankingBySubjectOutput(output);
  }
}
