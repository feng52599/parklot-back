package edu.feng.parklotback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"edu.feng.parklotback.mapper"}) //扫描DAO
public class ParklotBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParklotBackApplication.class, args);
    }

}
