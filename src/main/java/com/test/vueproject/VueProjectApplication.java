package com.test.vueproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class VueProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueProjectApplication.class, args);
    }

}
