package com.lucete.comprehensive.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lucete.comprehensive")
@MapperScan(basePackages = "com.lucete.comprehensive" , annotationClass = Mapper.class)
public class Application {


    public static void main(String[] args) {
        System.out.println("test1");
        SpringApplication.run(Application.class, args);
    }

}
