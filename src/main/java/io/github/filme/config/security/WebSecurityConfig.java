package io.github.filme.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {

	@Autowired
	SecurityFilter securityFilter;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http
					.csrf(csrf -> csrf.disable())
					.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.authorizeHttpRequests(authorize -> authorize
							.requestMatchers(HttpMethod.POST, "/api/usuario").permitAll()
							.requestMatchers(HttpMethod.POST, "/api/usuario/**").permitAll()
							.requestMatchers(HttpMethod.GET, "/api/usuario/**").permitAll()
							.requestMatchers(HttpMethod.GET, "/api/filme/**").hasAnyAuthority("ADMIN")
							.requestMatchers(HttpMethod.POST, "/api/role").permitAll()
							.anyRequest().authenticated()
					)
					.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
					.build();
	}
	
	@Bean
	 AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		 return authenticationConfiguration.getAuthenticationManager();
	 }
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}