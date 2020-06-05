package cn.junhaox.vhrBack.controller;

import cn.junhaox.vhrBack.model.Menu;
import cn.junhaox.vhrBack.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/5/30 22:00
 */
@RestController
public class HelloController {

    @Autowired
    MenuService menuService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/menu")
    public List<Menu> menu() {
        return menuService.getMenuWithRole();
    }


    @GetMapping("/employee/basic/hello1")
    public String hello1() {
        return "/employee/basic/hello1";
    }

    @GetMapping("/system/init/hello2")
    public String hello2() {
        return "/system/init/hello2";
    }
}
