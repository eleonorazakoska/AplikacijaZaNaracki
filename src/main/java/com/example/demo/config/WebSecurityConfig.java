package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {




        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().hasAnyRole("USER","ADMIN")
                .and()
                .formLogin()
                .failureUrl("/login?error=BadCredentials")
                .defaultSuccessUrl("/home", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
           auth.inMemoryAuthentication()
                .withUser("zoran")
                .password(passwordEncoder.encode("zz"))
                .authorities("ROLE_USER")
                .and()
                .withUser("elena")
                .password(passwordEncoder.encode("ee"))
                .authorities("ROLE_ADMIN");

    }

}
