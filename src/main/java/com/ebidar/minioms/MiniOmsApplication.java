package com.ebidar.minioms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ebidar.minioms.repository")
public class MiniOmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniOmsApplication.class, args);
    }

}
