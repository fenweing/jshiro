package com.tuanbaol.jshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tuanbaol.jshiro.dao")
public class JshiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(JshiroApplication.class, args);
	}

}
