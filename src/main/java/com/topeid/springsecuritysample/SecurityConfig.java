package com.topeid.springsecuritysample;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login.html")
        .loginProcessingUrl("/doLogin")
        .defaultSuccessUrl("/")
        .failureUrl("/login.html")
        .usernameParameter("username")
        .passwordParameter("password")
        .permitAll()
        .and()
        .csrf()
        .disable();
  }
}
