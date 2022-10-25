package com.hit.classservice.application.input_boundary.lesson;

import com.hit.classservice.application.input.lesson.GetListLessonDetailBySubjectIdInput;
import com.hit.classservice.application.input_boundary.UseCase;
import com.hit.classservice.application.output.lesson.GetListLessonDetailOutput;

public interface GetLessonDetailByIdDataCase extends UseCase<GetListLessonDetailBySubjectIdInput,
    GetListLessonDetailOutput> {
}
