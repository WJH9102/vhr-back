package cn.junhaox.vhrBack.service;

import cn.junhaox.vhrBack.mapper.MenuMapper;
import cn.junhaox.vhrBack.model.Menu;
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
    public List<Menu> getMenusByHrId(int hrId) {
        return menuMapper.getMenusByHrId(hrId);
    }

    public List<Menu> getMenuWithRole() {
        return menuMapper.getMenuWithRole();
    }


}
