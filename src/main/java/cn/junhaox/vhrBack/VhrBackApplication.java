package cn.junhaox.vhrBack;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "cn.junhaox.vhrBack.mapper")
@EnableCaching
public class VhrBackApplication {

    public static void main(String[] args) {
        System.out.println("hello world");
        SpringApplication.run(VhrBackApplication.class, args);
    }

}
