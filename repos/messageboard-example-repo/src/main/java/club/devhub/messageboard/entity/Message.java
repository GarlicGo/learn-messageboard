package club.devhub.messageboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 留言实体类
 * 对应t_message
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
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

    private static final long serialVersionUID = 1L;
}