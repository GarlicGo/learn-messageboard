package club.devhub.messageboard.mapper;


import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 针对表【t_user(用户表)】的数据库操作Mapper
 */
@Mapper
public interface UserMapper {

    /**
     * 创建一个新用户(除了用户名和密码,其他字段均设置为默认值)
     */
    void insert(@Param("username") String username, @Param("password") String password);

    /**
     * 根据userId获取用户VO
     */
    UserVO getVOById(@Param("userId") Long userId);

    /**
     * 根据username获取用户
     */
    User getByUsername(@Param("username") String username);

    /**
     * 根据userId,更新指定用户的信息(昵称和性别)
     */
    int updateById(@Param("userId") Long userId, @Param("nickname") String nickname, @Param("sex") Integer sex);

}




