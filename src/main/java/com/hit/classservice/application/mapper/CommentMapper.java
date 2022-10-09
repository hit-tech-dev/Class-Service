package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateChildrenCommentForLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateChildrenCommentForLessonStudentParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateParentCommentForLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateParentCommentForLessonStudentParameter;
import com.hit.classservice.application.input.comment.CreateChildrenCommentForLessonInput;
import com.hit.classservice.application.input.comment.CreateChildrenCommentForLessonStudentInput;
import com.hit.classservice.application.input.comment.CreateParentCommentForLessonInput;
import com.hit.classservice.application.input.comment.CreateParentCommentForLessonStudentInput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CreateParentCommentForLessonInput toCreateParentCommentForLessonInput(CreateParentCommentForLessonParameter parameter);

    CreateChildrenCommentForLessonInput toCreateChildrenCommentForLessonInput(CreateChildrenCommentForLessonParameter parameter);

    CreateParentCommentForLessonStudentInput toCreateParentCommentForLessonStudentInput(CreateParentCommentForLessonStudentParameter parameter);

    CreateChildrenCommentForLessonStudentInput toCreateChildrenCommentForLessonStudentInput(CreateChildrenCommentForLessonStudentParameter parameter);
}
