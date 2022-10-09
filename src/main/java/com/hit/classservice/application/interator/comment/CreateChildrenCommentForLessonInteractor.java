package com.hit.classservice.application.interator.comment;

import com.hit.classservice.application.constant.CommonConstant;
import com.hit.classservice.application.constant.DevMessageConstant;
import com.hit.classservice.application.dai.CommentRepository;
import com.hit.classservice.application.dai.LessonRepository;
import com.hit.classservice.application.input.comment.CreateChildrenCommentForLessonInput;
import com.hit.classservice.application.input_boundary.comment.CreateChildrenCommentForLessonDataCase;
import com.hit.classservice.application.output.comment.CreateChildrenCommentForLessonOutput;
import com.hit.classservice.application.utils.SecurityUtil;
import com.hit.classservice.domain.entity.Comment;
import com.hit.classservice.domain.entity.Lesson;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationCreateChildrenCommentForLessonInteractor")
public class CreateChildrenCommentForLessonInteractor implements CreateChildrenCommentForLessonDataCase {

    private final CommentRepository commentRepository;

    private final LessonRepository lessonRepository;

    public CreateChildrenCommentForLessonInteractor(@Qualifier("DatabaseCommentRepository") CommentRepository commentRepository,
                                                    @Qualifier("DatabaseLessonRepository") LessonRepository lessonRepository) {
        this.commentRepository = commentRepository;
        this.lessonRepository = lessonRepository;
    }

    @SneakyThrows
    @Override
    public CreateChildrenCommentForLessonOutput handle(CreateChildrenCommentForLessonInput input) throws Exception {
        Lesson oldLesson = lessonRepository.findById(input.getLessonId());
        Comment parentComment = commentRepository.findById(input.getParentCommentId());
        if (ObjectUtils.isEmpty(oldLesson)) {
            return new CreateChildrenCommentForLessonOutput(CommonConstant.FALSE, String.format(
                    DevMessageConstant.Lesson.ERR_NOT_FOUND_BY_ID, input.getLessonId()));
        }
        if (ObjectUtils.isEmpty(parentComment)) {
            return new CreateChildrenCommentForLessonOutput(CommonConstant.FALSE, String.format(
                    DevMessageConstant.Comment.ERR_NOT_FOUND_BY_ID, input.getParentCommentId()));
        }

        Comment comment = new Comment();
        comment.setContent(input.getContent());
        comment.setLessonId(input.getLessonId());
        comment.setUserId(SecurityUtil.getCurrentUserLogin());

        //stop comment level 2
        int count = 0;
        Comment checkComment = commentRepository.findById(parentComment.getParentId());
        for(int i = 1; i < 2; i++) {
            if(checkComment == null) {
                break;
            }
            count++;
            checkComment = commentRepository.findById(checkComment.getParentId());
        }
        if(count == 1) {
            comment.setParentId(parentComment.getParentId());
        } else {
            comment.setParentId(input.getParentCommentId());
        }
        commentRepository.createCommentForLesson(comment);
        return new CreateChildrenCommentForLessonOutput(CommonConstant.TRUE, CommonConstant.EMPTY_STRING);
    }
}
