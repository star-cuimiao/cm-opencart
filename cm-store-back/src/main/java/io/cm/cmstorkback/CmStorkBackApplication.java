package io.cm.cmstorkback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("io.cm.cmstorkback.dao")
@EnableCaching
public class CmStorkBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmStorkBackApplication.class, args);
    }

}
