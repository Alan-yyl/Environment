package org.sspu.environment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.sspu.environment.mapper")
public class EnvironmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnvironmentApplication.class, args);
    }

}
