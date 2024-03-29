package com.example.springbootcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.example.springbootcache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringbootcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootcacheApplication.class, args);
    }

}
