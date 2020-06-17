package cn.junhaox.vhrBack.controller.config;

import cn.junhaox.vhrBack.model.Hr;
import cn.junhaox.vhrBack.model.Menu;
import cn.junhaox.vhrBack.model.RespBeen;
import cn.junhaox.vhrBack.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/6/2 21:11
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public RespBeen getMenusByHrId() {
        Integer id = ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<Menu> menus = menuService.getMenusByHrId(id);
        List<Menu> menuWithRole = menuService.getMenuWithRole();
        Map<String, Object> data = new HashMap<>();
        data.put("menus", menus);
        data.put("menuWithRole", menuWithRole);
        return RespBeen.ok("获取菜单成功!", data);

    }

}
