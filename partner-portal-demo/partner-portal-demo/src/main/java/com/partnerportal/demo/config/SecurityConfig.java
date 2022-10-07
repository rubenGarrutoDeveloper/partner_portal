package com.partnerportal.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	// add a reference to our security data source

	private DataSource securityDataSource;

	@Autowired
	public SecurityConfig(DataSource theSecurityDataSource)
	{
		securityDataSource = theSecurityDataSource;
	}

	@Bean
	public UserDetailsManager userDetailsManager()
	{
		return new JdbcUserDetailsManager(securityDataSource);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{

		return http
				.authorizeRequests(auth -> auth
						.antMatchers("/").hasRole("USER")
						.antMatchers("/projects-section/**").hasRole("PARTNER")
						.antMatchers("/admin/**").hasRole("ADMIN"))

				.formLogin(formLogin -> formLogin
						.loginPage("/login")
						.loginProcessingUrl("/authenticateTheUser")
						.permitAll())

				.logout(logout -> logout.permitAll())

				.exceptionHandling(exceptionHandling -> exceptionHandling.accessDeniedPage("/access-denied"))
				.build();
	}

}
