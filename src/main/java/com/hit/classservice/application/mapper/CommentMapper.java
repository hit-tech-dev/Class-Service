package com.hit.classservice.application.mapper;

import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateChildrenCommentForLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateChildrenCommentForLessonStudentParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateParentCommentForLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateParentCommentForLessonStudentParameter;
import com.hit.classservice.application.input.comment.CreateChildrenCommentForLessonInput;
import com.hit.classservice.application.input.comment.CreateChildrenCommentForLessonStudentInput;
import com.hit.classservice.application.input.comment.CreateParentCommentForLessonInput;
import com.hit.classservice.application.input.comment.CreateParentCommentForLessonStudentInput;
import com.hit.classservice.application.output.comment.GetChildrenCommentsByLessonItemOutput;
import com.hit.classservice.application.output.comment.GetParentCommentsByLessonItemOutput;
import com.hit.classservice.domain.dto.ChildrenCommentDTO;
import com.hit.classservice.domain.dto.ParentCommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

  CreateParentCommentForLessonInput toCreateParentCommentForLessonInput(CreateParentCommentForLessonParameter parameter);

  CreateChildrenCommentForLessonInput toCreateChildrenCommentForLessonInput(CreateChildrenCommentForLessonParameter parameter);

  CreateParentCommentForLessonStudentInput toCreateParentCommentForLessonStudentInput(CreateParentCommentForLessonStudentParameter parameter);

  CreateChildrenCommentForLessonStudentInput toCreateChildrenCommentForLessonStudentInput(CreateChildrenCommentForLessonStudentParameter parameter);

  @Mappings({
      @Mapping(target = "id", source = "comments.id"),
      @Mapping(target = "content", source = "comments.content"),
      @Mapping(target = "authorName", source = "comments.authorName"),
      @Mapping(target = "authorAvatar", source = "comments.authorAvatar"),
      @Mapping(target = "createdDate", source = "comments.createdDate"),
      @Mapping(target = "createdBy", source = "comments.createdBy"),
      @Mapping(target = "totalNumberChild", source = "comments.totalNumberChild"),
      @Mapping(target = "userId", source = "comments.userId")
  })
  List<GetParentCommentsByLessonItemOutput> toGetCommentsByLessonItemOutput(List<ParentCommentDTO> comments);

  List<GetChildrenCommentsByLessonItemOutput> toGetChildrenCommentsByLessonOutput(List<ChildrenCommentDTO> comments);
}
