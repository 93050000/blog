package com.zhao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
            .loginPage("/login.html").loginProcessingUrl("/admin/Login");

        http.csrf().disable();//去除csrf防护

        http.logout().logoutSuccessUrl("/logout").logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"));
//.httpBasic()
//                .and()
//                .authorizeRequests() //请求授权
//                .antMatchers("/index.html").permitAll() //这个URL不需要验证
//                .anyRequest() //任何请求
//                .authenticated() //都需要验证
//                .and()
//
    }
}
