package club.devhub.messageboard.controller;

import club.devhub.messageboard.constant.ResultCodeEnum;
import club.devhub.messageboard.constant.UserRoleEnum;
import club.devhub.messageboard.entity.User;
import club.devhub.messageboard.exception.BusinessException;
import club.devhub.messageboard.param.LoginParam;
import club.devhub.messageboard.param.PagingParam;
import club.devhub.messageboard.param.ReviewParam;
import club.devhub.messageboard.service.ReportService;
import club.devhub.messageboard.service.UserService;
import club.devhub.messageboard.utils.JwtUtil;
import club.devhub.messageboard.vo.PageResult;
import club.devhub.messageboard.vo.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 管理员相关的Controller
 */
@RestController
@Validated
@RequestMapping("/api/msgboard/v1/admins")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Object login(@RequestBody @Valid LoginParam loginParam, HttpServletResponse response) {
        User user = userService.login(loginParam.getUsername(), loginParam.getPassword());
        if (UserRoleEnum.ADMINISTRATOR.getRole() != user.getRole()) {
            throw new BusinessException(ResultCodeEnum.WRONG_USERNAME_OR_PASSWORD, "非管理员账户无法在此登录");
        }
        String token = jwtUtil.getTokenFromUser(user);
        response.setHeader("token", token);
        return new Object();
    }

    @GetMapping("/reports")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public PageResult<ReportVO> getReportList(@Valid PagingParam pagingParam) {
        return reportService.getList(pagingParam.getCurrent(), pagingParam.getPageSize());
    }


    @PostMapping("/review")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void review(@AuthenticationPrincipal User user, @RequestBody @Valid ReviewParam reviewParam) {
        reportService.review(user.getUserId(), reviewParam.getReportId(), reviewParam.getIllegal());
    }


}
