package com.hualuo.springboot;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StarterApplication {

    @Value("${book.name}")
    private String bookName;

    @Value("${book.author}")
    private String bookAuthor;

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot! " + bookName + " by " + bookAuthor;
    }

	public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(StarterApplication.class);
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
        new SpringApplicationBuilder(StarterApplication.class)
//                .bannerMode(Banner.Mode.OFF)
                .run(args);
	}
}
