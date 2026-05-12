package club.devhub.messageboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 留言板应用启动类
 */
@SpringBootApplication
public class MessageboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageboardApplication.class, args);
    }
}
