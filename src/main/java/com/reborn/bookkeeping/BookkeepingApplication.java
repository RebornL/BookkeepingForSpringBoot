package com.reborn.bookkeeping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.reborn.bookkeeping.mapper")
public class BookkeepingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookkeepingApplication.class, args);
    }
}
