package com.hit.classservice.application.interator.subject;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.SubjectRepository;
import com.hit.classservice.application.input.subject.DeleteSubjectInput;
import com.hit.classservice.application.input_boundary.subject.DeleteSubjectDataCase;
import com.hit.classservice.application.output.subject.DeleteSubjectOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Subject;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationDeleteSubjectInteractor")
public class DeleteSubjectInteractor implements DeleteSubjectDataCase {

    private final SubjectRepository subjectRepository;

    public DeleteSubjectInteractor(@Qualifier("DatabaseSubjectRepository") SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @SneakyThrows
    @Override
    public DeleteSubjectOutput handle(DeleteSubjectInput input) {
        Subject subject = subjectRepository.findById(input.getId());
        if (ObjectUtils.isEmpty(subject))
            throw new VsException(UserMessageConstant.Subject.ERR_NOT_FOUND_BY_ID,
                    String.format(DevMessageConstant.Subject.ERR_NOT_FOUND_BY_ID, input.getId()),
                    new String[]{input.getId().toString()});

        subjectRepository.delete(input.getId());
        return new DeleteSubjectOutput(CommonConstant.TRUE, "Delete sucessful");
    }

}
