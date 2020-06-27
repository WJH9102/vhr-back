package cn.junhaox.vhrBack.controller.system;

import cn.junhaox.vhrBack.model.Hr;
import cn.junhaox.vhrBack.model.RespBeen;
import cn.junhaox.vhrBack.model.Role;
import cn.junhaox.vhrBack.service.HrService;
import cn.junhaox.vhrBack.service.RoleService;
import org.apache.ibatis.annotations.Arg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/6/25 9:26
 */
@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;

    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keyword) {
        return hrService.getAllHrs(keyword);
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/")
    public RespBeen updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBeen.ok("更新成功!");
        }
        return RespBeen.error("更新失败!");
    }

    @PutMapping("/role")
    public RespBeen updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBeen.ok("更新成功!");
        }
        return RespBeen.error("更新失败!");
    }

}
