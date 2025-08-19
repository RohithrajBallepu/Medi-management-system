package com.hospital.medimanage;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.hospital.medimanage.dto")
@EnableJpaRepositories("com.hospital.medimanage.dao")
@ComponentScan(basePackages = { "com.hospital.medimanage.Controller", "com.hospital.medimanage.dto", "com.hospital.medimanage.dao" })
public class medimanageApplication {
    public static void main(String[] args) {
        SpringApplication.run(medimanageApplication.class, args);
    }
}

