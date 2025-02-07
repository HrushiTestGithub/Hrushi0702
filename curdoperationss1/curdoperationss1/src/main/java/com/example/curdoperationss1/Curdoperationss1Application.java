package com.example.curdoperationss1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info; 
// url/swagger-ui.html

@SpringBootApplication
@OpenAPIDefinition(info = @Info (description="Swagger UI"))
public class Curdoperationss1Application {

	public static void main(String[] args) {
		SpringApplication.run(Curdoperationss1Application.class, args);
		
	}

}
