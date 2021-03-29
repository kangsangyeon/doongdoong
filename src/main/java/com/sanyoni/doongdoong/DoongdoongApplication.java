package com.sanyoni.doongdoong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.util.TimeZone;

@EnableJpaAuditing
@SpringBootApplication
public class DoongdoongApplication {

    @PostConstruct
    void PostConstructor() {
        // https://docs.oracle.com/javase/tutorial/datetime/iso/timezones.html
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    public static void main(String[] args) {
        SpringApplication.run(DoongdoongApplication.class, args);
    }

}