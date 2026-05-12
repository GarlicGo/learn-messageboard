package club.devhub.messageboard.service.impl;

import club.devhub.messageboard.constant.ResultCodeEnum;
import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.exception.BusinessException;
import club.devhub.messageboard.service.UserService;
import club.devhub.messageboard.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhouxinyu
 * @description 针对表【t_user(用户表)】的数据库操作Service实现
 * @createDate 2026-05-06 01:23:41
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void register(String username, String password) {
        User user = userMapper.getByUsername(username);
        if (user != null) {
            throw new BusinessException(ResultCodeEnum.WRONG_USERNAME_OR_PASSWORD, "用户名" + username + "已存在");
        }

        try {
            userMapper.insert(username, passwordEncoder.encode(password));
        } catch (DuplicateKeyException e) {
            throw new BusinessException(ResultCodeEnum.WRONG_USERNAME_OR_PASSWORD, "用户名" + username + "已存在");
        }
    }

    @Override
    public User login(String username, String password) {
        Authentication authentication;

        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (AuthenticationException e) {
            log.warn("[登陆失败] 尝试登陆失败，失败原因：{}", e.getMessage());
            throw new BusinessException(ResultCodeEnum.WRONG_USERNAME_OR_PASSWORD, "用户名或密码错误");
        }

        return (User)authentication.getPrincipal();
    }
}
