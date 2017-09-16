package com.example.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 

@RestController
@SpringBootApplication
class HomeController {

	@RequestMapping("/")
	public String greetings(){
		return "hello SpringBootApplication";
	}

	public static void main(String[] args) {
		SpringApplication.run(HomeController.class,args);
	}	
}