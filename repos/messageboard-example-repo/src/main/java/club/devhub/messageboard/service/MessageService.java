package club.devhub.messageboard.service;


import club.devhub.messageboard.vo.MessageVO;
import club.devhub.messageboard.vo.PageResult;

/**
 * 针对表【t_message(留言表)】的Service
 */
public interface MessageService {

    /**
     * 发表一条留言
     */
    void publish(Long userId, Integer category, String content);

    /**
     * 编辑指定留言
     */
    void edit(Long userId, Long messageId, Integer category, String content);

    /**
     * 删除指定留言(会连带删除其下面所有评论)
     */
    void delete(Long userId, Long messageId);

    /**
     * 按照指定的搜索条件获取留言列表(提供分页)
     */
    PageResult<MessageVO> search(Integer category, Long userId, Integer current, Integer pageSize);

    /**
     * 获取指定留言的详情页
     */
    MessageVO getDetails(Long messageId);

    /**
     * 举报指定留言
     */
    void report(Long userId, Long messageId, String reason);
}
