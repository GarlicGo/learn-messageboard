package club.devhub.messageboard.controller;

import club.devhub.messageboard.annotation.Idempotent;
import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.param.*;
import club.devhub.messageboard.service.MessageService;
import club.devhub.messageboard.vo.MessageVO;
import club.devhub.messageboard.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 留言相关的Controller
 */
@RestController
@Validated
@RequestMapping("/api/msgboard/v1/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    @PreAuthorize("hasAnyRole('USER')")
    @Idempotent
    public void publish(@AuthenticationPrincipal User user, @RequestBody @Valid PublishMessageParam publishMessageParam) {
        messageService.publish(user.getUserId(), publishMessageParam.getCategory(), publishMessageParam.getContent());
    }

    @PutMapping("/{messageId}")
    @PreAuthorize("hasAnyRole('USER')")
    public void edit(@AuthenticationPrincipal User user, @PathVariable @Valid @Min(1) Long messageId, @RequestBody @Valid EditMessageParam editMessageParam) {
        messageService.edit(user.getUserId(), messageId, editMessageParam.getCategory(), editMessageParam.getContent());
    }

    @DeleteMapping("/{messageId}")
    @PreAuthorize("hasAnyRole('USER')")
    public void delete(@AuthenticationPrincipal User user, @PathVariable @Valid @Min(1) Long messageId) {
        messageService.delete(user.getUserId(), messageId);
    }

    @GetMapping
    public PageResult<MessageVO> search(@Valid SearchMessageParam searchMessageParam, @Valid PagingParam pagingParam) {
        return messageService.search(searchMessageParam.getCategory(), searchMessageParam.getUserId(), pagingParam.getCurrent(), pagingParam.getPageSize());
    }

    @GetMapping("/{messageId}")
    public MessageVO getDetails(@PathVariable @Valid @Min(1) Long messageId) {
        return messageService.getDetails(messageId);
    }

    @PostMapping("/{messageId}/report")
    @PreAuthorize("hasAnyRole('USER')")
    public void report(@AuthenticationPrincipal User user, @PathVariable @Valid @Min(1) Long messageId, @RequestBody @Valid ReportParam reportParam) {
        messageService.report(user.getUserId(), messageId, reportParam.getReason());
    }


}
