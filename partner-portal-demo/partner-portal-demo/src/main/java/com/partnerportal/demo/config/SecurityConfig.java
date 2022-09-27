package com.partnerportal.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{

	@Bean
	public InMemoryUserDetailsManager userDetailsManager()
	{

		UserDetails gabry = User.builder()
				.username("gabry")
				.password("{noop}test123")
				.roles("BASIC-USER")
				.build();

		UserDetails matteo = User.builder()
				.username("matteo")
				.password("{noop}test123")
				.roles("PARTNER-USER")
				.build();

		UserDetails ruben = User.builder()
				.username("ruben")
				.password("{noop}test123")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(gabry, matteo, ruben);
	}
}
