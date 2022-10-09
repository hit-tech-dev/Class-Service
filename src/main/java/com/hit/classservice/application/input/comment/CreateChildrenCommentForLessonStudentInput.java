package com.hit.classservice.application.input.comment;

import com.hit.classservice.application.input.Input;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateChildrenCommentForLessonStudentInput implements Input {
    private String content;
    private Long lessonStudentId;
    private Long parentCommentId;
}
