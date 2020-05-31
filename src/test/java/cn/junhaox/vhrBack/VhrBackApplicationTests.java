package cn.junhaox.vhrBack;

import cn.junhaox.vhrBack.mapper.HrMapper;
import cn.junhaox.vhrBack.model.Hr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VhrBackApplicationTests {

    @Autowired
    HrMapper hrMapper;
    @Test
    void contextLoads() {
        Hr admin = hrMapper.loadUserByUsername("admin");
        System.out.println(admin);
    }

}
