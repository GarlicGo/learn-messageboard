package club.devhub.messageboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 评论实体类
 * 对应t_comment
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
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

    private static final long serialVersionUID = 1L;
}