package club.devhub.messageboard.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 修改用户信息参数
 */
@Data
public class ModifyUserParam {

    /**
     * 新的昵称
     */
    @NotBlank(message = "昵称不能为空")
    @Length(max = 10, message = "昵称的最大长度为10")
    private String nickname;

    /**
     * 新的性别
     */
    @NotNull(message = "性别为必填项")
    @Min(value = 0, message = "性别最小为0")
    @Max(value = 2, message = "性别最大为2")
    private Integer sex;
}
