package club.devhub.messageboard.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 发布留言参数
 */
@Data
public class PublishMessageParam {

    /**
     * 留言类别
     */
    @NotNull(message = "留言类别为必填项")
    @Min(value = 0, message = "留言类别最小为0")
    @Max(value = 4, message = "留言类别最大为4")
    private Integer category;

    /**
     * 留言内容
     */
    @NotBlank(message = "留言内容不能为空")
    @Length(max = 255, message = "留言内容长度最大为255")
    private String content;

}
