package club.devhub.messageboard.controller;

import club.devhub.messageboard.annotation.Idempotent;
import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.param.EditCommentParam;
import club.devhub.messageboard.param.PublishCommentParam;
import club.devhub.messageboard.param.ReportParam;
import club.devhub.messageboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 评论相关的Controller
 */
@RestController
@Validated
@RequestMapping("/api/msgboard/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER')")
    @Idempotent
    public void publish(@AuthenticationPrincipal User user, @RequestBody @Valid PublishCommentParam publishCommentParam) {
        commentService.publish(user.getUserId(), publishCommentParam.getMessageId(), publishCommentParam.getContent());
    }

    @PutMapping("/{commentId}")
    @PreAuthorize("hasAnyRole('USER')")
    public void edit(@AuthenticationPrincipal User user, @PathVariable @Valid @Min(1) Long commentId, @RequestBody @Valid EditCommentParam editCommentParam) {
        commentService.edit(user.getUserId(), commentId, editCommentParam.getContent());
    }

    @DeleteMapping("/{commentId}")
    @PreAuthorize("hasAnyRole('USER')")
    public void delete(@AuthenticationPrincipal User user, @PathVariable @Valid @Min(1) Long commentId) {
        commentService.delete(user.getUserId(), commentId);
    }

    @PostMapping("/{commentId}/report")
    @PreAuthorize("hasAnyRole('USER')")
    public void report(@AuthenticationPrincipal User user, @PathVariable @Valid @Min(1) Long commentId, @RequestBody @Valid ReportParam reportParam) {
        commentService.report(user.getUserId(), commentId, reportParam.getReason());
    }
}
