package club.devhub.messageboard.service;

import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
* @author zhouxinyu
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2026-05-06 01:23:41
*/
public interface UserService {

    void register(String username, String password);

    User login(@NotBlank(message = "用户名不能为空") @Length(max=20, message = "用户名长度最大是20") String username, @NotBlank(message = "密码不能为空") @Length(max=20, message = "密码长度最大是20") String password);

    UserVO getInfo(Long userId);

    void modifyInfo(Long userId, @NotBlank(message = "昵称不能为空") @Length(max = 10, message = "昵称最大长度为10") String nickname, @Min(value = 0, message = "性别最小是0") @Max(value = 2, message = "性别最大是2") Integer sex);
}
