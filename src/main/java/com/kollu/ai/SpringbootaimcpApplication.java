package com.kollu.ai;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kollu.ai.service.ProductService;

@SpringBootApplication
public class SpringbootaimcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootaimcpApplication.class, args);
	}
	
	@Bean
	public List<ToolCallback> productServiceToolCallback(ProductService productService){
		return List.of(ToolCallbacks.from(productService));
	}

}
