package com.hit.classservice.application.input_boundary.comment;

import com.hit.classservice.application.input.comment.GetParentCommentsByLessonInput;
import com.hit.classservice.application.input_boundary.UseCase;
import com.hit.classservice.application.output.comment.GetParentCommentsByLessonOutput;

public interface GetParentCommentByLessonDataCase extends UseCase<GetParentCommentsByLessonInput,
    GetParentCommentsByLessonOutput> {
}
