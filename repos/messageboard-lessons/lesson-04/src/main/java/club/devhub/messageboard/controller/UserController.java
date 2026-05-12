package club.devhub.messageboard.controller;

import club.devhub.messageboard.param.RegisterParam;
import club.devhub.messageboard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/api/msgboard/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid RegisterParam registerParam) {
        userService.register(registerParam.getUsername(), registerParam.getPassword());
    }
}
