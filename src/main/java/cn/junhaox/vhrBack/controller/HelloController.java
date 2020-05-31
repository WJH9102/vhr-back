package cn.junhaox.vhrBack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/5/30 22:00
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
