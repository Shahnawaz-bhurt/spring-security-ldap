//package com.sl.spring.security.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import com.sl.spring.security.service.CustomUserDetailsService;
// 
//@SuppressWarnings("deprecation")
//@Configuration
//public class SecurityConfiguration2 {
// 
//	@Autowired
//	CustomUserDetailsService customUserDetailsService;
//	
//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//	    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//	    provider.setUserDetailsService(customUserDetailsService);
//	    provider.setPasswordEncoder(getPasswordEncoder());
//	    return provider;
//	}
//      
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    	http
//        .authorizeRequests()
//		.antMatchers("/admin").hasRole("ADMIN")	
//		.antMatchers("/user").hasAnyRole("USER","ADMIN")
//		.antMatchers("/", "/h2-console/**").permitAll()
//		.and().formLogin();
//        return http.build();
//    }
//    
//    @Bean
//	public PasswordEncoder getPasswordEncoder() {
//    	return NoOpPasswordEncoder.getInstance();
//	}
// 
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//    }
//}
