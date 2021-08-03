package br.com.sec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Startup {
    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/api");

        SpringApplication.run(Startup.class, args);
    }
}
