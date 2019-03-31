package br.ufc.alu.cardatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Security configuration of Spring Security
 * 
 * @author Marcos Davy Guedes Dias
 * 
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
        User
            .withDefaultPasswordEncoder() // for testing only
            .username("user")
            .password("password")
            .roles("USER")
            .build();
    
        return new InMemoryUserDetailsManager(user);
    }
    
}