package club.devhub.messageboard.service;

import club.devhub.messageboard.entity.User;
import org.apache.ibatis.annotations.Param;

/**
* @author zhouxinyu
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2026-05-06 01:23:41
*/
public interface UserService {

    void register(String username, String password);
}
