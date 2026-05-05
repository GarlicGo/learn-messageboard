package club.devhub.messageboard.service.impl;

import club.devhub.messageboard.constant.ReportTypeEnum;
import club.devhub.messageboard.constant.ResultCodeEnum;
import club.devhub.messageboard.exception.BusinessException;
import club.devhub.messageboard.exception.IllegalOperationException;
import club.devhub.messageboard.exception.NotFoundException;
import club.devhub.messageboard.mapper.CommentMapper;
import club.devhub.messageboard.mapper.MessageMapper;
import club.devhub.messageboard.mapper.ReportMapper;
import club.devhub.messageboard.service.MessageService;
import club.devhub.messageboard.vo.MessageVO;
import club.devhub.messageboard.vo.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 针对表【t_message(留言表)】的Service实现
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public void publish(Long userId, Integer category, String content) {
        messageMapper.insert(userId, category, content);
    }

    @Override
    public void edit(Long userId, Long messageId, Integer category, String content) {
        Long publisherId = messageMapper.getUserIdById(messageId);
        if (publisherId == null) {
            throw new NotFoundException("messageId为" + messageId + "的留言不存在");
        }
        if (!publisherId.equals(userId)) {
            throw new IllegalOperationException("userId为" + userId + "的用户尝试编辑messageId为" + messageId + "的不属于他的留言");
        }
        messageMapper.updateById(messageId, category, content);
    }

    @Override
    @Transactional
    public void delete(Long userId, Long messageId) {
        Long publisherId = messageMapper.getUserIdById(messageId);
        if (publisherId == null) {
            throw new NotFoundException("messageId为" + messageId + "的留言不存在");
        }
        if (!publisherId.equals(userId)) {
            throw new IllegalOperationException("userId为" + userId + "的用户尝试删除messageId为" + messageId + "的不属于他的留言");
        }

        messageMapper.deleteById(messageId);
        commentMapper.deleteBatchByMessageId(messageId);
    }

    @Override
    public PageResult<MessageVO> search(Integer category, Long userId, Integer current, Integer pageSize) {
        PageHelper.startPage(current, pageSize);
        List<MessageVO> list = messageMapper.getList(category, userId);
        PageInfo<MessageVO> pageInfo = new PageInfo<>(list);

        PageResult<MessageVO> result = new PageResult<>();
        result.setTotal(pageInfo.getTotal());
        result.setPrev(pageInfo.isHasPreviousPage() ? pageInfo.getPrePage() : -1);
        result.setNext(pageInfo.isHasNextPage() ? pageInfo.getNextPage() : -1);
        result.setList(list);
        return result;

    }

    @Override
    public MessageVO getDetails(Long messageId) {
        MessageVO messageVO = messageMapper.getVOById(messageId);
        if (messageVO == null) {
            throw new NotFoundException("messageId为" + messageId + "的留言不存在");
        }
        return messageVO;
    }

    @Override
    public void report(Long userId, Long messageId, String reason) {
        Long publisherId = messageMapper.getUserIdById(messageId);
        if (publisherId == null) {
            throw new NotFoundException("messageId为" + messageId + "的留言不存在");
        }
        if (publisherId.equals(userId)) {
            throw new IllegalOperationException("userId为" + userId + "的用户尝试举报自己发布的messageId为" + messageId + "的留言");
        }
        int count = reportMapper.count(ReportTypeEnum.MESSAGE.getCode(), messageId, userId);
        if (count > 0) {
            log.info("userId为{}的用户重复举报messageId为{}的留言", userId, messageId);
            throw new BusinessException(ResultCodeEnum.REPEAT_OPERATION);
        }
        try {
            reportMapper.insert(ReportTypeEnum.MESSAGE.getCode(), messageId, reason, userId);
        } catch (DuplicateKeyException e) {
            log.info("userId为{}的用户重复举报messageId为{}的留言", userId, messageId);
            throw new BusinessException(ResultCodeEnum.REPEAT_OPERATION);
        }
    }
}




