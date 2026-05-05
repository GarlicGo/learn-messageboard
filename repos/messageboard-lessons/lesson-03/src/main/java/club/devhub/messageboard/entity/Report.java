package club.devhub.messageboard.entity;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * 举报表
 * @TableName t_report
 */
@Data
public class Report {
    /**
     * 举报ID
     */
    private Long reportId;

    /**
     * 被举报事物的种类
     */
    private Integer reportType;

    /**
     * 被举报事物的ID
     */
    private Long targetId;

    /**
     * 举报理由
     */
    private String reason;

    /**
     * 举报人ID
     */
    private Long userId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}