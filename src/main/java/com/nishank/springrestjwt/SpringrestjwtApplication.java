package com.nishank.springrestjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SpringrestjwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringrestjwtApplication.class, args);
    }
}
