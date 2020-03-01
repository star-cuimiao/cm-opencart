package io.cm.cmstorkback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.cm.cmstorkback.dao")
public class CmStorkBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmStorkBackApplication.class, args);
    }

}
