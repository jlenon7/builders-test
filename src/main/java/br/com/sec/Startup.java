package br.com.sec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Startup {
    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/api");

        SpringApplication.run(Startup.class, args);
    }
}
