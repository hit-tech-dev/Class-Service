package com.hit.classservice.application.interator.comment;

import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.input.comment.CreateParentCommentForLessonStudentInput;
import com.hit.classservice.application.input_boundary.comment.CreateParentCommentForLessonStudentDataCase;
import com.hit.classservice.application.output.comment.CreateParentCommentForLessonOutput;
import com.hit.classservice.application.output.comment.CreateParentCommentForLessonStudentOutput;
import com.hit.classservice.domain.entity.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateParentCommentForLessonStudentInteractor")
public class CreateParentCommentForLessonStudentInteractor implements CreateParentCommentForLessonStudentDataCase {

    private final CommentRepository commentRepository;

    public CreateParentCommentForLessonStudentInteractor(@Qualifier("DatabaseCommentRepository") CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CreateParentCommentForLessonStudentOutput handle(CreateParentCommentForLessonStudentInput input) throws Exception {
        Comment comment = new Comment();
        comment.setContent(input.getContent());
        comment.setLessonStudentId(input.getLessonStudentId());
        comment.setUserId(input.getUserId());
        comment.setParentId(null);
        commentRepository.createParentCommentForLessonStudent(comment);
        return new CreateParentCommentForLessonStudentOutput(true, "");
    }
}
