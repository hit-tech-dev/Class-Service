package com.hit.classservice.adapter.web.v1.controller;

import com.hit.classservice.adapter.web.base.RestApiV1;
import com.hit.classservice.adapter.web.base.VsResponseUtil;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateParentCommentForLessonParameter;
import com.hit.classservice.adapter.web.v1.transfer.parameter.comment.CreateParentCommentForLessonStudentParameter;
import com.hit.classservice.adapter.web.v1.transfer.response.ResponseHeader;
import com.hit.classservice.application.UseCaseBus;
import com.hit.classservice.application.constant.UrlConstant;
import com.hit.classservice.application.input.comment.CreateParentCommentForLessonInput;
import com.hit.classservice.application.input.comment.CreateParentCommentForLessonStudentInput;
import com.hit.classservice.application.mapper.CommentMapper;
import com.hit.classservice.application.output.comment.CreateParentCommentForLessonOutput;
import com.hit.classservice.application.output.comment.CreateParentCommentForLessonStudentOutput;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestApiV1
public class CommentController {
    private final UseCaseBus useCaseBus;
    private final ResponseHeader responseHeader;
    private final CommentMapper commentMapper;

    public CommentController(@Qualifier("ApplicationUseCaseBus") UseCaseBus useCaseBus,
                             @Qualifier("WebV1TransferResponseHeader") ResponseHeader responseHeader) {
        this.useCaseBus = useCaseBus;
        this.responseHeader = responseHeader;
        this.commentMapper = Mappers.getMapper(CommentMapper.class);
    }

    @PostMapping(UrlConstant.Comment.CREATE_PARENT_FOR_LESSON)
    public ResponseEntity<?> createParentCommentForLesson(@Valid @RequestBody CreateParentCommentForLessonParameter parameter) throws Exception {
        // Create input
        CreateParentCommentForLessonInput input = commentMapper.toCreateParentCommentForLessonInput(parameter);
        // Get output
        CreateParentCommentForLessonOutput output = useCaseBus.handle(input);
        // Return output
        return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
    }

    @PostMapping(UrlConstant.Comment.CREATE_PARENT_FOR_LESSON_STUDENT)
    public ResponseEntity<?> createParentCommentForLessonStudent(@Valid @RequestBody CreateParentCommentForLessonStudentParameter parameter) throws Exception {
        // Create input
        CreateParentCommentForLessonStudentInput input = commentMapper.toCreateParentCommentForLessonStudentInput(parameter);
        // Get output
        CreateParentCommentForLessonStudentOutput output = useCaseBus.handle(input);
        // Return output
        return VsResponseUtil.ok(this.responseHeader.getHeader(), output);
    }

}
