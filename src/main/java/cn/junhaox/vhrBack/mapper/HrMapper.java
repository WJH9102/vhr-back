package cn.junhaox.vhrBack.mapper;

import cn.junhaox.vhrBack.model.Hr;
import cn.junhaox.vhrBack.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRolesById(int id);

    List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keyword") String keyword);
}