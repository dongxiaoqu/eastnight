package cn.eastnight;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages="cn.eastnight.module.*.mapper")
public class EastNightWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EastNightWebApplication.class, args);
    }

}
