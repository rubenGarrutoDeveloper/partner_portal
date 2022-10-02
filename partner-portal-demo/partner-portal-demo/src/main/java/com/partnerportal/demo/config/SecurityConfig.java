package com.partnerportal.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{

	@Bean
	public InMemoryUserDetailsManager userDetailsManager()
	{

		UserDetails gabry = User.builder()
				.username("gabry")
				.password("{noop}password")
				.roles("BASIC-USER")
				.build();

		UserDetails matteo = User.builder()
				.username("matteo")
				.password("{noop}password")
				.roles("PARTNER-USER", "BASIC-USER")
				.build();

		UserDetails ruben = User.builder()
				.username("ruben")
				.password("{noop}password")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(gabry, matteo, ruben);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{

		return http.authorizeRequests(configurer -> configurer.antMatchers("/css/**").permitAll().anyRequest().authenticated())
				.formLogin(configurer -> configurer.loginPage("/loginPage").loginProcessingUrl("/authenticateTheUser").permitAll())
				.logout(logout -> logout.permitAll())
				.build();
	}

}
