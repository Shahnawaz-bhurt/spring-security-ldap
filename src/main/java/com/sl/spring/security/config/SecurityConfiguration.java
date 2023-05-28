package com.sl.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication()
		.userDnPatterns("uid={0},ou=people")
		.groupSearchBase("ou=groups")
		.contextSource()
		.url("ldap://localhost:3083/dc=springframework,dc=org")
		.and()
		.passwordCompare()
		.passwordEncoder(getPasswordEncoder())
		.passwordAttribute("userPassword");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")	
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/", "/h2-console/**").permitAll()
		.anyRequest().authenticated();
		http.headers().frameOptions().disable();
		http.authorizeRequests()
		.and().formLogin();
	}
	
	@Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
