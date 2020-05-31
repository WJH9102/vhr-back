package cn.junhaox.vhrBack;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.junhaox.vhrBack.mapper")
public class VhrBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrBackApplication.class, args);
    }

}
