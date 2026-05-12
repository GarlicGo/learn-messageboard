package club.devhub.messageboard.controller;

import club.devhub.messageboard.constant.ResultCodeEnum;
import club.devhub.messageboard.constant.UserRoleEnum;
import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.exception.BusinessException;
import club.devhub.messageboard.param.LoginParam;
import club.devhub.messageboard.param.RegisterParam;
import club.devhub.messageboard.service.UserService;
import club.devhub.messageboard.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/api/msgboard/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterParam registerParam) {
        userService.register(registerParam.getUsername(), registerParam.getPassword());
    }

    @PostMapping("/login")
    public Object login(@RequestBody @Valid LoginParam loginParam, HttpServletResponse response) {
        User user = userService.login(loginParam.getUsername(), loginParam.getPassword());
        if (UserRoleEnum.ORDINARY_USER.getRole() != user.getRole()) {
            throw new BusinessException(ResultCodeEnum.WRONG_USERNAME_OR_PASSWORD, "非普通用户无法在此登陆");
        }
        String token = jwtUtil.getTokenFromUser(user);
        response.setHeader("token", token);
        return new Object();
    }
}
