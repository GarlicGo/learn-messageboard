package club.devhub.messageboard.service.impl;

import club.devhub.messageboard.constant.ResultCodeEnum;
import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.exception.BusinessException;
import club.devhub.messageboard.exception.NotFoundException;
import club.devhub.messageboard.mapper.UserMapper;
import club.devhub.messageboard.service.UserService;
import club.devhub.messageboard.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 针对表【t_user(用户表)】的Service实现
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * PasswordEncoder用于用户注册，把用户密码加密后，也即是passwordEncoder.encode()之后，
     * 再存入数据库，不应该存储密码明文到数据库
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(String username, String password) {
        User user = userMapper.getByUsername(username);
        if (user != null) {
            throw new BusinessException(ResultCodeEnum.USERNAME_ALREADY_EXIST, "用户名" + username + "已存在");
        }
        try {
            userMapper.insert(username, passwordEncoder.encode(password));
        } catch (DuplicateKeyException e) {
            throw new BusinessException(ResultCodeEnum.USERNAME_ALREADY_EXIST, "用户名" + username + "已存在");
        }

    }

    @Override
    public User login(String username, String password) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (AuthenticationException e) {
            log.warn("[登录失败]  尝试登录失败，失败原因：{}", e.getMessage());
            throw new BusinessException(ResultCodeEnum.WRONG_USERNAME_OR_PASSWORD);
        }
        return (User) authentication.getPrincipal();
    }

    @Override
    public UserVO getInfo(Long userId) {
        UserVO userVO = userMapper.getVOById(userId);
        if (userVO == null) {
            throw new NotFoundException("userId为" + userId + "的用户不存在");
        }
        return userVO;
    }

    @Override
    public void modifyInfo(Long userId, String nickname, Integer sex) {
        int matched = userMapper.updateById(userId, nickname, sex);
        if (matched == 0) {
            throw new NotFoundException("userId为" + userId + "的用户不存在");
        }
    }
}




