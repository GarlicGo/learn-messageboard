package club.devhub.messageboard.param;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterParam {
    @NotBlank(message = "用户名不能为空")
    @Length(max=20, message = "用户名长度最大是20")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Length(max=20, message = "密码长度最大是20")
    private String password;
}
