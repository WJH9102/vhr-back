package cn.junhaox.vhrBack.controller;

import cn.junhaox.vhrBack.model.RespBeen;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/5/31 8:58
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public RespBeen login() {
        return RespBeen.error("未登录，请先登陆!");
    }
}
