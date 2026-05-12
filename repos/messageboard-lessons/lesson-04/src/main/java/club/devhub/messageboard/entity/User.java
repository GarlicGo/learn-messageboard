package club.devhub.messageboard.entity;

import club.devhub.messageboard.constant.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 用户实体类
 * 对于t_user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable, UserDetails {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 角色
     */
    private Integer role;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Assert.notNull(this.role, "role不能为null");
        for (UserRoleEnum roleEnum : UserRoleEnum.values()) {
            if (roleEnum.getRole() == this.role) {
                return roleEnum.getAuthorities();
            }
        }
        return new ArrayList<>(0);
    }

    //必须为true！
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //必须为true！
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //必须为true！
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //必须为true！
    @Override
    public boolean isEnabled() {
        return true;
    }
}