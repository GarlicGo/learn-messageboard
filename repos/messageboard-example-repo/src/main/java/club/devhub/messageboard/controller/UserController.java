package club.devhub.messageboard.controller;

import club.devhub.messageboard.constant.ResultCodeEnum;
import club.devhub.messageboard.constant.UserRoleEnum;
import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.exception.BusinessException;
import club.devhub.messageboard.param.LoginParam;
import club.devhub.messageboard.param.ModifyUserParam;
import club.devhub.messageboard.param.RegisterParam;
import club.devhub.messageboard.service.UserService;
import club.devhub.messageboard.utils.JwtUtil;
import club.devhub.messageboard.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 用户相关的Controller
 */
@RestController
@Slf4j
@Validated
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
            throw new BusinessException(ResultCodeEnum.WRONG_USERNAME_OR_PASSWORD, "非普通用户账户无法在此登录");
        }
        String token = jwtUtil.getTokenFromUser(user);
        response.setHeader("token", token);
        return new Object();
    }

    @GetMapping("/info")
    @PreAuthorize("hasAnyRole('USER')")
    public UserVO getOwnInfo(@AuthenticationPrincipal User user) {
        return userService.getInfo(user.getUserId());
    }

    @GetMapping("/{userId}")
    public UserVO getUserInfo(@PathVariable @Valid @Min(1) Long userId) {
        return userService.getInfo(userId);
    }

    @PutMapping("/info")
    @PreAuthorize("hasAnyRole('USER')")
    public void modifyOwnInfo(@AuthenticationPrincipal User user, @RequestBody @Valid ModifyUserParam modifyUserParam) {
        userService.modifyInfo(user.getUserId(), modifyUserParam.getNickname(), modifyUserParam.getSex());
    }

}
