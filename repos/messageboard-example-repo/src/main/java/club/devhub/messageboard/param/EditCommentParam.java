package club.devhub.messageboard.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 编辑评论参数
 */
@Data
public class EditCommentParam {

    /**
     * 评论内容
     */
    @NotBlank(message = "评论不能为空")
    @Length(max = 255, message = "评论长度不能超过255")
    private String content;

}
