package club.devhub.messageboard.entity;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * 评论表
 * @TableName t_comment
 */
@Data
public class Comment {
    /**
     * 评论ID
     */
    private Long commentId;

    /**
     * 所属于的留言ID
     */
    private Long messageId;

    /**
     * 楼层数
     */
    private Integer floor;

    /**
     * 发布者ID
     */
    private Long userId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}