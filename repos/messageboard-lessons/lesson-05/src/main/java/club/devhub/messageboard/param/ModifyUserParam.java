package club.devhub.messageboard.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ModifyUserParam {
    @NotBlank(message = "昵称不能为空")
    @Length(max = 10, message = "昵称最大长度为10")
    private String nickname;

    @Min(value = 0, message = "性别最小是0")
    @Max(value = 2, message = "性别最大是2")
    private Integer sex;
}
