package club.devhub.messageboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 举报实体类
 * 对应t_report
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report implements Serializable {
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

    private static final long serialVersionUID = 1L;
}