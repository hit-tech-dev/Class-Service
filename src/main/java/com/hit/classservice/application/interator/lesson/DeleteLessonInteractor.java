package com.hit.classservice.application.interator.lesson;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.constant.UserMessageConstant;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.input.lesson.DeleteLessonInput;
import com.hit.classservice.application.input_boundary.lesson.DeleteLessonDataCase;
import com.hit.classservice.application.mapper.LessonMapper;
import com.hit.classservice.application.output.lesson.DeleteLessonOutput;
import com.hit.classservice.application.output.subject.DeleteSubjectOutput;
import com.hit.classservice.config.exception.VsException;
import com.hit.classservice.domain.entity.Lesson;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationDeleteLessonInteractor")
public class DeleteLessonInteractor implements DeleteLessonDataCase {

    private final LessonRepository repository;
    private final LessonMapper mapper;

    public DeleteLessonInteractor(@Qualifier("DatabaseLessonRepository") LessonRepository repository) {
        this.repository = repository;
        this.mapper = Mappers.getMapper(LessonMapper.class);
    }


    @SneakyThrows
    @Override
    public DeleteLessonOutput handle(DeleteLessonInput input) {
        Lesson lesson = repository.findById(input.getId());
        if (ObjectUtils.isEmpty(lesson))
            throw new VsException(UserMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID,
                    String.format(DevMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID, input.getId()),
                    new String[]{input.getId().toString()});

        repository.deleteById(input.getId());
        return new DeleteLessonOutput(CommonConstant.TRUE, "Delete successfully!");
    }
}
