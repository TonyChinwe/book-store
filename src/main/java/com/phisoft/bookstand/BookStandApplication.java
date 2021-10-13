package com.phisoft.bookstand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class BookStandApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStandApplication.class, args);
    }

}
