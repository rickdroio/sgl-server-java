package com.rdr.sglserverjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class SglServerJavaApplication {

	@Bean
	public static CommonsRequestLoggingFilter logger() {
		var filter = new CommonsRequestLoggingFilter();
		filter.setIncludeHeaders(true);
		filter.setIncludeClientInfo(true);
		filter.setIncludePayload(true);
		filter.setIncludeQueryString(true);
		return filter;
	}



	public static void main(String[] args) {
		SpringApplication.run(SglServerJavaApplication.class, args);
	}

}
