package com.spring.security.example.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.spring.security.example.common.security.CustomAccessDeniedHandler;
import com.spring.security.example.user.service.UserService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private AuthenticationProvider authenticationProvider;
    
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    
    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;
    
    @Autowired
    private UserService userService;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	
	http
	.formLogin()
	.loginPage("/login")
	.loginProcessingUrl("/loginProcess")
	.usernameParameter("username")
	.passwordParameter("password")
	.successHandler(authenticationSuccessHandler)
	.failureHandler(authenticationFailureHandler);
	
	http
	.logout()
	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	.logoutSuccessUrl("/")
	.invalidateHttpSession(true);
	
	http
	.authorizeRequests()
	.antMatchers("/", "/login").permitAll()
	.antMatchers("/main").hasRole("USER")
	.antMatchers("/admin").hasRole("ADMIN")
	.anyRequest().authenticated();
	
	http
	 .exceptionHandling()
         .accessDeniedHandler(customAccessDeniedHandler);
	
	
	http
	.authenticationProvider(authenticationProvider);
	
    }
    
    

}
