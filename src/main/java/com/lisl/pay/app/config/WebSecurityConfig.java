package com.lisl.pay.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/3/2.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService securityUserServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //.antMatchers("/", "/ali/pay").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successForwardUrl("/ali/index")
                //.loginPage("/ali/index")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
        /*auth
                .jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password,true from user where username= ?")
                .authoritiesByUsernameQuery("select username,role_user,true from role where username= ?")
                //.passwordEncoder();
                .passwordEncoder(passwordEncoder());*/
        auth.userDetailsService(securityUserServiceImpl);//.passwordEncoder(passwordEncoder());
    }

    /*@Bean
    public BCryptPasswordEncoder passwordEncoder() throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(13);
        //StandardPasswordEncoder passwordEncoder = new StandardPasswordEncoder("53cr3t");
        //PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
        return passwordEncoder;
    }*/



}
