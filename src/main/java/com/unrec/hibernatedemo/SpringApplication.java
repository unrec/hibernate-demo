package com.unrec.hibernatedemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
public class SpringApplication {
    public static void main(String[] args) {
        log.info("Version: {}", SpringApplication.class.getPackage().getImplementationVersion());
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }
}