package com.ensa.tp1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationSuccessHandler successHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("ensa2020"))
                .roles("USER")

                .and()

                .withUser("admin")
                .password(passwordEncoder().encode("ensa2020"))
                .roles("ADMIN");
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //httpSecurity.csrf().disable();
        httpSecurity
                .authorizeRequests()
//                .antMatchers("/home").hasAnyRole("ADMIN","USER")
//                .and()
//                .authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .and()
//                .authorizeRequests().antMatchers("/user/**").hasAnyRole("USER")
              .and()
                .formLogin().loginPage("/login")//.defaultSuccessUrl("/home");//.permitAll();
                    .successHandler(successHandler).permitAll()
                .and().exceptionHandling().accessDeniedPage("/accessdenied");


    }

}
