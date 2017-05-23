package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import controller.TokenFilter;

@SpringBootApplication
public class ApiWebApplication {
	
	@Bean
	public FilterRegistrationBean getFilro(){
		FilterRegistrationBean frb = new FilterRegistrationBean();
		
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/authenticad/*");
		
		return frb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiWebApplication.class, args);
	}
}
