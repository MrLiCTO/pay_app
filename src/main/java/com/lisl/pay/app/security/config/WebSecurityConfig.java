package com.lisl.pay.app.security.config;

import com.lisl.pay.app.security.handler.MyAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Administrator on 2017/3/2.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /*@Autowired
    private DataSource dataSource;*/
    @Autowired
    private UserDetailsService securityUserService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/images/**", "/js/**").mvcMatchers("/test_security");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilter(authenticationFilter())
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/")
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
        auth.userDetailsService(securityUserService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(13);
        //StandardPasswordEncoder passwordEncoder = new StandardPasswordEncoder("53cr3t");
        //PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
        return passwordEncoder;
    }

    @Bean
    public UsernamePasswordAuthenticationFilter authenticationFilter() throws Exception {
        UsernamePasswordAuthenticationFilter authenticationFilter = new UsernamePasswordAuthenticationFilter();
        authenticationFilter.setAuthenticationFailureHandler(handler());
        authenticationFilter.setAuthenticationManager(this.authenticationManager());
        return authenticationFilter;
    }

    @Bean
    public MyAuthenticationFailureHandler handler() throws Exception {
        MyAuthenticationFailureHandler handler = new MyAuthenticationFailureHandler("/login?error=true");
        return handler;
    }
}
