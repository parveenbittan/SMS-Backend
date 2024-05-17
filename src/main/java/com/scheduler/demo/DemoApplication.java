package com.scheduler.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
	   String[] allowDomains = new String[2];
	   allowDomains[0] = "http://localhost:4200";
	   allowDomains[1] = "http://localhost:9000";

	   System.out.println("CORS configuration....");
	   return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	         registry.addMapping("/**").allowedOrigins(allowDomains);
	      }
	   };
	}
}
