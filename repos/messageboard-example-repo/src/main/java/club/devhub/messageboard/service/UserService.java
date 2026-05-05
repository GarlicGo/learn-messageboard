package club.devhub.messageboard.service;

import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.vo.UserVO;

/**
 * 针对表【t_user(用户表)】的Service
 */
public interface UserService {

    /**
     * 用户注册
     */
    void register(String username, String password);

    /**
     * 用户登录(如果用户名和密码匹配,会返回用户信息)
     */
    User login(String username, String password);

    /**
     * 根据userId获取用户的信息
     */
    UserVO getInfo(Long userId);

    /**
     * 根据userId,修改指定用户的信息(昵称和性别)
     */
    void modifyInfo(Long userId, String nickname, Integer sex);
}
