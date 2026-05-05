package club.devhub.messageboard.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 评论视图对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {

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
     * 发布者昵称（不在表t_comment中存储）
     */
    private String nickname;

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
