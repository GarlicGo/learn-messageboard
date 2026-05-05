package club.devhub.messageboard.param;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 评审举报参数
 */
@Data
public class ReviewParam {

    /**
     * 要评审的举报ID
     */
    @NotNull(message = "举报ID为必填项")
    @Min(value = 1, message = "举报ID不能小于1")
    private Long reportId;

    /**
     * 评审意见(被举报内容是否违法)
     */
    @NotNull(message = "是否违法是必填项")
    private Boolean illegal;
}
