package club.devhub.messageboard.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 举报参数
 */
@Data
public class ReportParam {

    /**
     * 举报理由
     */
    @NotBlank(message = "举报理由不能为空")
    @Length(max = 255, message = "举报理由长度最大为255")
    private String reason;
}
