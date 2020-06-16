package cn.junhaox.vhrBack.service;

import cn.junhaox.vhrBack.mapper.MenuMapper;
import cn.junhaox.vhrBack.mapper.MenuRoleMapper;
import cn.junhaox.vhrBack.model.Menu;
import cn.junhaox.vhrBack.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/6/2 21:39
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenusByHrId(int hrId) {
        return menuMapper.getMenusByHrId(hrId);
    }

    public List<Menu> getMenuWithRole() {
        return menuMapper.getMenuWithRole();
    }


    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        if (mids == null || mids.length == 0) {
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        return result==mids.length;
    }
}
