package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class OathDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OathDemoApplication.class, args);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}


	@RequestMapping("/indexB")
	public String indexB() {
		return "indexB";
	}

	@RequestMapping("/indexA")
	public String indexA() {
		return "indexA";
	}

}
