package club.devhub.messageboard.mapper;


import club.devhub.messageboard.entity.Message;
import club.devhub.messageboard.vo.MessageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 针对表【t_message(留言表)】的数据库操作Mapper
 */
@Mapper
public interface MessageMapper {

    /**
     * 创建一个新留言
     */
    void insert(@Param("userId") Long userId, @Param("category") Integer category, @Param("content") String content);

    /**
     * 根据messageId获取指定留言的发布者ID(如果指定留言不存在则返回null)
     */
    Long getUserIdById(@Param("messageId") Long messageId);

    /**
     * 根据messageId,更新指定留言的信息(留言种类,留言内容)
     */
    void updateById(@Param("messageId") Long messageId, @Param("category") Integer category, @Param("content") String content);

    /**
     * 根据messageId,删除指定的留言
     */
    void deleteById(@Param("messageId") Long messageId);

    /**
     * 获取留言VO的列表,根据可选的留言种类(不提供则表示不限制种类)和可选的发布者ID(不提供则表示不限制发布者ID)进行筛选
     */
    List<MessageVO> getList(@Param("category") Integer category, @Param("userId") Long userId);

    /**
     * 根据messageId获取指定留言VO,包括其评论列表也一并获取
     */
    MessageVO getVOById(@Param("messageId") Long messageId);

    /**
     * 根据messageId获取指定留言信息,并加上锁
     */
    Message getByIdForUpdate(@Param("messageId") Long messageId);

    /**
     * 根据messageId,把指定留言的"当前已有评论数"加一,"用于分配的下一楼层数"加一
     */
    void addFloor(@Param("messageId") Long messageId);

    /**
     * 根据messageId,把指定留言的"当前已有评论数"减一
     */
    void reduceFloor(@Param("messageId") Long messageId);

    /**
     * 根据messageId,获取指定留言的内容
     */
    String getContentById(@Param("messageId") Long messageId);


}




