package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.*;
import com.hit.classservice.application.input.comment.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

  CreateParentCommentForLessonInput toCreateParentCommentForLessonInput(CreateParentCommentForLessonParameter parameter);

  CreateChildrenCommentForLessonInput toCreateChildrenCommentForLessonInput(CreateChildrenCommentForLessonParameter parameter);

  CreateParentCommentForLessonStudentInput toCreateParentCommentForLessonStudentInput(CreateParentCommentForLessonStudentParameter parameter);

  CreateChildrenCommentForLessonStudentInput toCreateChildrenCommentForLessonStudentInput(CreateChildrenCommentForLessonStudentParameter parameter);

  EditCommentInput toEditCommentInput(EditCommentParameter parameter);
}
