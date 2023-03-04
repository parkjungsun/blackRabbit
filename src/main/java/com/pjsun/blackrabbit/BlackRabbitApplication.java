package com.pjsun.blackrabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlackRabbitApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlackRabbitApplication.class, args);
    }

}
