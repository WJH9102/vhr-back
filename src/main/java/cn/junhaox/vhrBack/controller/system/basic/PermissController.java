package cn.junhaox.vhrBack.controller.system.basic;

import cn.junhaox.vhrBack.mapper.MenuMapper;
import cn.junhaox.vhrBack.mapper.RoleMapper;
import cn.junhaox.vhrBack.model.Menu;
import cn.junhaox.vhrBack.model.RespBeen;
import cn.junhaox.vhrBack.model.Role;
import cn.junhaox.vhrBack.service.MenuService;
import cn.junhaox.vhrBack.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/6/14 13:20
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {

    @Autowired
    MenuService menuService;

    @Autowired
    RoleService roleService;
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public RespBeen getMidsByRid(@PathVariable Integer rid) {
        List<Integer> mids = menuService.getMidsByRid(rid);
        return RespBeen.ok("success", mids);
    }

    @PostMapping("/")
    public RespBeen addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBeen.ok("添加成功！");
        }
        return RespBeen.error("添加失败！");
    }

    @PutMapping("/")
    public RespBeen updateMenuRole (Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBeen.ok("修改成功！");
        }
        return RespBeen.error("修改失败！");
    }

    @DeleteMapping("/role/{rid}")
    public RespBeen deleteRoleById (@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return RespBeen.ok("删除成功！");
        }
        return RespBeen.error("删除失败！");
    }
}
