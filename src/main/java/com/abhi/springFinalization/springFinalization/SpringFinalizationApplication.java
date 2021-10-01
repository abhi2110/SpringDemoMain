package com.abhi.springFinalization.springFinalization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.abhi.*"})
public class SpringFinalizationApplication {

	public static void main(String[] args) {
		System.out.println("testing release automation pipeline");
		SpringApplication.run(SpringFinalizationApplication.class, args);
	}

}
