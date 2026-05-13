package club.devhub.messageboard.entity;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * 留言表
 * @TableName t_message
 */
@Data
public class Message {
    /**
     * 留言ID
     */
    private Long messageId;

    /**
     * 发布者ID
     */
    private Long userId;

    /**
     * 类别
     */
    private Integer category;

    /**
     * 内容
     */
    private String content;

    /**
     * 评论数
     */
    private Integer commentNum;

    /**
     * 下一楼层数
     */
    private Integer nextFloor;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}