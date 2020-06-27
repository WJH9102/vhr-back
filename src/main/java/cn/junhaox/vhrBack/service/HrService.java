package cn.junhaox.vhrBack.service;

import cn.junhaox.vhrBack.mapper.HrMapper;
import cn.junhaox.vhrBack.mapper.HrRoleMapper;
import cn.junhaox.vhrBack.model.Hr;
import cn.junhaox.vhrBack.model.Role;
import cn.junhaox.vhrBack.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/5/30 21:51
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

    @Autowired
    HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (null == hr) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHrs(String keyword) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(), keyword);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrid(hrid);
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }

    public int updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }
}
