package club.devhub.messageboard.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 留言视图对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageVO {
    /**
     * 留言ID
     */
    private Long messageId;

    /**
     * 发布者ID
     */
    private Long userId;

    /**
     * 发布者昵称（不在表t_message中存储）
     */
    private String nickname;

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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 包含所有评论的列表（不在表t_message中存储，仅在留言详情页才会显示出这个列表）
     */
    private List<CommentVO> commentList;
}
