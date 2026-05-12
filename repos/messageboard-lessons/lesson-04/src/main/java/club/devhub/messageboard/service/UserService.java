package club.devhub.messageboard.service;

import club.devhub.messageboard.entity.User;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
* @author zhouxinyu
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2026-05-06 01:23:41
*/
public interface UserService {

    void register(String username, String password);

    User login(@NotBlank(message = "用户名不能为空") @Length(max=20, message = "用户名长度最大是20") String username, @NotBlank(message = "密码不能为空") @Length(max=20, message = "密码长度最大是20") String password);
}
