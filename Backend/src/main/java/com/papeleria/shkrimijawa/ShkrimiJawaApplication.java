package com.papeleria.shkrimijawa;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

@SuppressWarnings("deprecation")
@SpringBootApplication
public class ShkrimiJawaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShkrimiJawaApplication.class, args);
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
			configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "PUT", "DELETE", "HEAD"));
			configuration.setExposedHeaders(Arrays.asList("Authorization"));
			configuration.setAllowedOrigins(Arrays.asList("*"));

			http.csrf().disable().cors().configurationSource(request -> configuration);
		}
	}
}