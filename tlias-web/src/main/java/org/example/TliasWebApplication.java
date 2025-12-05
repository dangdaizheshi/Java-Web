package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan // 开启了 SpringBoot 对 Servlet 组件的支持
@SpringBootApplication
public class TliasWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebApplication.class, args);
    }

}
