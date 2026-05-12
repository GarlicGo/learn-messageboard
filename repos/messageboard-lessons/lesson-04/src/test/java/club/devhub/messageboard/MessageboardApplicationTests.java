package club.devhub.messageboard;

import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.mapper.UserMapper;
import club.devhub.messageboard.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MessageboardApplicationTests {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void testJwtUtil() {
        // 测试生成 token
        //        User user = new User();
        //        user.setUserId(456L);
        //        user.setRole(0);
        //        System.out.println(jwtUtil.getTokenFromUser(user));

        // 测试解析 token
        String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3NzkyMTAyNzMsInVzZXIiOnsicm9sZSI6IjAiLCJpZCI6IjQ1NiJ9fQ.MjWnj-aiXN_vw6sYLESNG4yLF4dCnDxr3oVRovx40Mo";
        User user = jwtUtil.getUserFromToken(token);
        System.out.println(user);
    }

    @Test
    public void testPasswordEncoder() {
        // 测试加密
        String str = passwordEncoder.encode("123456");
        System.out.println("加密后密码:"+str);
        System.out.println("加密后密码长度:"+str.length());

        // 测试相等判断
        String encodedPassword = "$2a$10$wkK9mNUNCIxXkiJd1ezBge0onHC4IKgO6qpoGzkYHv3krzjIGtMoa";
        Boolean isEqual = passwordEncoder.matches("1234568", encodedPassword);
        System.out.println("是否相等:"+isEqual);
    }
}
