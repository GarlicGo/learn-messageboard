package club.devhub.messageboard;

import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageboardApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUserMapper() {
        User user = userMapper.getById(2);
        System.out.println(user);

        int res = userMapper.updateById(2L, "new-nick", 1);
        System.out.println("updateById res:" + res);
        int res2 = userMapper.deleteById(2L);
        System.out.println("deleteById res:" + res2);
    }
}
