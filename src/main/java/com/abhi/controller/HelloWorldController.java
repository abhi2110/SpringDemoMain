package com.abhi.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	//GET
	// URI - /helloWorld
	//method - "helloWorld"
	@GetMapping(path="/helloWorld")
	public String helloWorld() {
		return "hello World";
		
	}
	
	@GetMapping(path="/helloWorldbean/path/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("hello World, %s", name));
		
	}
	
	

	
}
