package club.devhub.messageboard.mapper;

import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author zhouxinyu
* @description 针对表【t_user(用户表)】的数据库操作Mapper
* @createDate 2026-05-06 01:23:41
* @Entity club.devhub.messageboard.entity.User
*/
@Mapper
public interface UserMapper {
    void  insert(@Param("username") String username, @Param("password") String password);

    User getById(@Param("userId") Integer userId);

    int updateById(@Param("userId") Long userId, @Param("nickname") String nickname, @Param("sex") Integer sex);

    int deleteById(@Param("userId") Long userId);

    User getByUsername(String username);

    UserVO getVOById(@Param("userId") Long userId);
}




