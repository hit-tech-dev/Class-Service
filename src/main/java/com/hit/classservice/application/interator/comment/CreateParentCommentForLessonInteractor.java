package com.hit.classservice.application.interator.comment;

import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.input.comment.CreateParentCommentForLessonInput;
import com.hit.classservice.application.input_boundary.comment.CreateParentCommentForLessonDataCase;
import com.hit.classservice.application.output.comment.CreateParentCommentForLessonOutput;
import com.hit.classservice.domain.entity.Comment;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateParentCommentForLessonInteractor")
public class CreateParentCommentForLessonInteractor implements CreateParentCommentForLessonDataCase {

    private final CommentRepository commentRepository;

    public CreateParentCommentForLessonInteractor(@Qualifier("DatabaseCommentRepository") CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @SneakyThrows
    @Override
    public CreateParentCommentForLessonOutput handle(CreateParentCommentForLessonInput input) {
        Comment comment = new Comment();
        comment.setContent(input.getContent());
        comment.setLessonId(input.getLessonId());
        comment.setUserId(input.getUserId());
        comment.setParentId(null);
        commentRepository.createParentCommentForLesson(comment);
        return new CreateParentCommentForLessonOutput(true, "");
    }
}
