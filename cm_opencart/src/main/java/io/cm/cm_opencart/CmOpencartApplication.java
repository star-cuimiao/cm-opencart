package io.cm.cm_opencart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.cm.cm_opencart.dao")
public class CmOpencartApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmOpencartApplication.class, args);
    }

}
