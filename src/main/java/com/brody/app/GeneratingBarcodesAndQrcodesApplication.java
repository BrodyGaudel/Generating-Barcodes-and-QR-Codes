package com.brody.app;

import java.awt.image.BufferedImage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
public class GeneratingBarcodesAndQrcodesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneratingBarcodesAndQrcodesApplication.class, args);
	}
	
	//register manually a message converter for BufferedImage HTTP Responses because there is no default
	@Bean
	public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
	    return new BufferedImageHttpMessageConverter();
	}

}
