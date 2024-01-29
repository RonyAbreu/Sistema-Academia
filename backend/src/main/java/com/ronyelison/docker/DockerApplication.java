package com.ronyelison.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@Controller
public class DockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerApplication.class);
	}

	@GetMapping("/")
	@ResponseBody
	public String hello(){
		return "Hello Docker v2";
	}
}
