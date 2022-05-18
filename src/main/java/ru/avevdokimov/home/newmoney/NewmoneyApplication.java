package ru.avevdokimov.home.newmoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NewmoneyApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewmoneyApplication.class, args);
    }

}
