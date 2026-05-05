package club.devhub.messageboard.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 举报视图对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportVO {
    /**
     * 举报ID
     */
    private Long reportId;

    /**
     * 被举报的内容（不在表t_report中存储）
     */
    private String content;

    /**
     * 举报理由
     */
    private String reason;

    /**
     * 举报的时间
     */
    private LocalDateTime createTime;


}
