package club.devhub.messageboard.mapper;


import club.devhub.messageboard.entity.Comment;
import club.devhub.messageboard.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 针对表【t_comment(评论表)】的数据库操作Mapper
 */
@Mapper
public interface CommentMapper {

    /**
     * 创建一个新评论(不仅需要用户ID和内容,还需要所属的留言ID和这条评论的楼层数)
     */
    void insert(@Param("messageId") Long messageId, @Param("floor") Integer floor, @Param("userId") Long userId, @Param("content") String content);

    /**
     * 根据commentId获取指定评论
     */
    Comment getById(@Param("commentId") Long commentId);

    /**
     * 根据messageId获取指定留言下面的所有评论列表
     */
    List<CommentVO> listVOByMessageId(@Param("messageId") Long messageId);

    /**
     * 根据commentId获取指定评论的发布者ID(如果指定评论不存在则返回null)
     */
    Long getUserIdById(@Param("commentId") Long commentId);

    /**
     * 根据commentId,更新指定评论的内容
     */
    void updateById(@Param("commentId") Long commentId, @Param("content") String content);

    /**
     * 根据commentId,删除指定的评论
     */
    int deleteById(@Param("commentId") Long commentId);

    /**
     * 根据messageId,删除指定留言下面的所有评论
     */
    void deleteBatchByMessageId(@Param("messageId") Long messageId);

    /**
     * 根据commentId,获取指定评论的内容
     */
    String getContentById(@Param("commentId") Long commentId);

    /**
     * 根据commentId,获取这条评论所属的留言ID
     */
    Long getMessageIdById(@Param("commentId") Long commentId);

}




