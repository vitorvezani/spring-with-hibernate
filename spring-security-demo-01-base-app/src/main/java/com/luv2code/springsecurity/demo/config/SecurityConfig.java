package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		@SuppressWarnings("deprecation")
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(
				userBuilder.username("admin").password("admin").roles("EMPLOYEE", "ADMIN"))
				.withUser(userBuilder.username("manager").password("manager").roles("EMPLOYEE", "MANAGER"))
				.withUser(userBuilder.username("employee").password("employee").roles("EMPLOYEE"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.and()
				.formLogin()
					.loginPage("/show-my-login-page")
					.loginProcessingUrl("/authenticate-the-user")
					.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout")
				.permitAll();

	}
}
