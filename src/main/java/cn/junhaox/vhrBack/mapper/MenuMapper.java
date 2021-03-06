package cn.junhaox.vhrBack.mapper;

import cn.junhaox.vhrBack.model.Menu;
import cn.junhaox.vhrBack.model.Role;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    List<Menu> getMenusByHrId(int hrId);

    List<Menu> getMenuWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByRid(Integer rid);

}