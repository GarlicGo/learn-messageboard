package club.devhub.messageboard.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 发布评论参数
 */
@Data
public class PublishCommentParam {

    /**
     * 所属的留言ID
     */
    @NotNull(message = "留言ID为必填项")
    @Min(value = 1, message = "留言ID不能小于1")
    private Long messageId;
    /**
     * 评论内容
     */
    @NotBlank(message = "评论内容不能为空")
    @Length(max = 255, message = "评论内容长度最大为255")
    private String content;
}
