package cn.junhaox.vhrBack.service;

import cn.junhaox.vhrBack.mapper.HrMapper;
import cn.junhaox.vhrBack.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ibytecode2020@gmail.com
 * create by Wang Junhao
 * @date 2020/5/30 21:51
 */
@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if (null == hr) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return hr;
    }
}
