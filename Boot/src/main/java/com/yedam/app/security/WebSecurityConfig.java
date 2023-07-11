package com.yedam.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	
	}
	
	@Bean
	CustomSuccessHandler authenticationSuccessHandler() {
		return new CustomSuccessHandler();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests()
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/emp/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.successHandler(authenticationSuccessHandler())
				.loginPage("/login")
				.permitAll()
				.and()
				.logout((logout) -> logout.permitAll());
				
		return http.build();
	}

//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.authorizeHttpRequests((requests) -> requests
//				.antMatchers("/", "/home").permitAll()
//				.antMatchers("/emp/**").hasRole("ADMIN")
//				.anyRequest().authenticated()
//			)
//			.formLogin((form) -> form
//				.loginPage("/login")
//				.permitAll()
//			)
//			.logout((logout) -> logout.permitAll());
//
//		return http.build();
//	}	
	
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.builder()//withDefaultPasswordEncoder()
//					.username("user")
//					.password("{noop}password")
//					.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
}