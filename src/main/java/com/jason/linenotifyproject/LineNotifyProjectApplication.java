package com.jason.linenotifyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LineNotifyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(LineNotifyProjectApplication.class, args);
    }

}
