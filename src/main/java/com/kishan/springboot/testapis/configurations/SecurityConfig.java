package com.kishan.springboot.testapis.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable();	//temp changes to access H2 db 
	    http.headers().frameOptions().disable();	//temp changes to access H2 db 
		http.authorizeRequests()
			.antMatchers("/", "/greet").permitAll()
			.antMatchers("/h2/**").permitAll()
			.antMatchers("/test/**").permitAll()
			.antMatchers("/getRandomQuote").permitAll()
			.antMatchers("/admin/**").hasRole("AdminRole")
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/pages/login.html").permitAll()
			      .loginPage("/pages/login.html")
			      .usernameParameter("username")
			      .passwordParameter("password")
			      .loginProcessingUrl("/process_login")
			      .defaultSuccessUrl("/", true)
			      .failureUrl("/pages/login.html?error=true")
//			      .successForwardUrl("/login_success_handler") //to do some extra computation...e.g. logging
//			      .failureForwardUrl("/login_failure_handler") //to do some extra computation...e.g. logging
				.and()
				.logout().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().passwordEncoder(getPasswordEncoder()) // for in memory
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(getPasswordEncoder()) //for jdbc
		.withUser(User.builder().username("admin")
								.password(getPasswordEncoder().encode("admin"))
								.roles("AdminRole", "UserRole"))
		.withUser(User.builder().username("user")
								.password(getPasswordEncoder().encode("user"))
								.roles("UserRole"))
		.withUser(User.builder().username("user1")
								.password(getPasswordEncoder().encode("user1"))
								.roles("UserRole"))
		.withUser(User.builder().username("user2")
								.password(getPasswordEncoder().encode("user2"))
								.roles("UserRole"));
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
