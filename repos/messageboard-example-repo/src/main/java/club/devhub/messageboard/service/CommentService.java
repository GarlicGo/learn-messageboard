package club.devhub.messageboard.service;


/**
 * 针对表【t_comment(评论表)】的Service
 */
public interface CommentService {
    /**
     * 发表一条评论
     */
    void publish(Long userId, Long messageId, String content);

    /**
     * 编辑指定评论
     */
    void edit(Long userId, Long commentId, String content);

    /**
     * 删除指定留言
     */
    void delete(Long userId, Long commentId);

    /**
     * 举报指定留言
     */
    void report(Long userId, Long commentId, String reason);
}
