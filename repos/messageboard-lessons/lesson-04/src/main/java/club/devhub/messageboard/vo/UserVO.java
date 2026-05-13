package club.devhub.messageboard.vo;

import lombok.Data;

@Data
public class UserVO {
    private Long userId;
    private String username;
    private String nickname;
    private Integer sex;
}
