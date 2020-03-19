package io.cm.cm_opencart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("io.cm.cm_opencart.dao")
@EnableAsync
public class CmOpencartApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmOpencartApplication.class, args);
    }

}
