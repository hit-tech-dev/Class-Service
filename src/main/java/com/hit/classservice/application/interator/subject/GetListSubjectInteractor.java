package com.hit.classservice.application.interator.subject;

import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.subject.GetListSubjectInput;
import com.hit.classservice.application.input_boundary.subject.GetListSubjectDataCase;
import com.hit.classservice.application.mapper.SubjectMapper;
import com.hit.classservice.application.output.subject.GetListSubjectItemOutput;
import com.hit.classservice.application.output.subject.GetListSubjectOutput;
import com.hit.classservice.domain.entity.Subject;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

        List<Subject> list = subjectRepository.findAll();

        List<GetListSubjectItemOutput> output = subjectMapper.toGetListSubjectItemOutput(list);
        return new GetListSubjectOutput(output);
    }
}
