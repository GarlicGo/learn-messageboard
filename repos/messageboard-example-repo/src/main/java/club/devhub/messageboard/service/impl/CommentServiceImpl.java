package club.devhub.messageboard.service.impl;

import club.devhub.messageboard.constant.ReportTypeEnum;
import club.devhub.messageboard.constant.ResultCodeEnum;
import club.devhub.messageboard.entity.Comment;
import club.devhub.messageboard.entity.Message;
import club.devhub.messageboard.exception.BusinessException;
import club.devhub.messageboard.exception.IllegalOperationException;
import club.devhub.messageboard.exception.NotFoundException;
import club.devhub.messageboard.mapper.CommentMapper;
import club.devhub.messageboard.mapper.MessageMapper;
import club.devhub.messageboard.mapper.ReportMapper;
import club.devhub.messageboard.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 针对表【t_comment(评论表)】的Service实现
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    @Transactional
    public void publish(Long userId, Long messageId, String content) {
        Message message = messageMapper.getByIdForUpdate(messageId);
        if (message == null) {
            throw new NotFoundException("messageId为" + messageId + "的留言不存在");
        }
        commentMapper.insert(messageId, message.getNextFloor(), userId, content);
        messageMapper.addFloor(messageId);
    }

    @Override
    public void edit(Long userId, Long commentId, String content) {
        Long publisherId = commentMapper.getUserIdById(commentId);
        if (publisherId == null) {
            throw new NotFoundException("commentId为" + commentId + "的评论不存在");
        }
        if (!publisherId.equals(userId)) {
            throw new IllegalOperationException("userId为" + userId + "的用户尝试编辑commentId为" + commentId + "的不属于他的评论");
        }
        commentMapper.updateById(commentId, content);
    }

    @Override
    @Transactional
    public void delete(Long userId, Long commentId) {
        Comment comment = commentMapper.getById(commentId);
        if (comment == null) {
            throw new NotFoundException("commentId为" + commentId + "的评论不存在");
        }
        if (!comment.getUserId().equals(userId)) {
            throw new IllegalOperationException("userId为" + userId + "的用户尝试删除commentId为" + commentId + "的不属于他的评论");
        }
        int deleted = commentMapper.deleteById(commentId);
        if (deleted == 0) {
            throw new NotFoundException("commentId为" + commentId + "的评论不存在");
        }
        messageMapper.reduceFloor(comment.getMessageId());

    }

    @Override
    public void report(Long userId, Long commentId, String reason) {
        Long publisherId = commentMapper.getUserIdById(commentId);
        if (publisherId == null) {
            throw new NotFoundException("commentId为" + commentId + "的评论不存在");
        }
        if (publisherId.equals(userId)) {
            throw new IllegalOperationException("userId为" + userId + "的用户尝试举报自己发布的commentId为" + commentId + "的评论");
        }
        int count = reportMapper.count(ReportTypeEnum.COMMENT.getCode(), commentId, userId);
        if (count > 0) {
            log.info("userId为{}的用户重复举报commentId为{}的评论", userId, commentId);
            throw new BusinessException(ResultCodeEnum.REPEAT_OPERATION);
        }
        try {
            log.info("userId为{}的用户重复举报commentId为{}的评论", userId, commentId);
            reportMapper.insert(ReportTypeEnum.COMMENT.getCode(), commentId, reason, userId);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(ResultCodeEnum.REPEAT_OPERATION);
        }
    }
}




