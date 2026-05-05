package club.devhub.messageboard.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求参数演示接口
 */
@RestController
@RequestMapping("/api/v1/demo")
public class RequestDemoController {

    @GetMapping("/header")
    public String header(@RequestHeader(value = "authorization", required = false, defaultValue = "authorization") String authorization) {
        return authorization;
    }

    @GetMapping("/param")
    public String param(@RequestParam(value = "name", required = false, defaultValue = "messageboard") String name) {
        return name;
    }

    @PostMapping("/body")
    public DemoUser body(@RequestBody DemoUser user) {
        return user;
    }

    @GetMapping("/path/{id}")
    public Long path(@PathVariable Long id) {
        return id;
    }

    @Data
    public static class DemoUser {
        private String name;
        private Integer age;
    }
}
