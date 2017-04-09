package com.lisl.pay.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/4/6.
 */
@Configuration
public class JdbcConfig {
    @Autowired
    @Qualifier("oneDataSource")
    private DataSource oneDataSource;
    @Autowired
    @Qualifier("twoDataSource")
    private DataSource twoDataSource;
    @Autowired
    @Qualifier("threeDataSource")
    private DataSource threeDataSource;

    @Bean(name = "jdbcTemplateOne")
    public JdbcTemplate jdbcTemplateOne(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(oneDataSource);
        return jdbcTemplate;
    }

    @Bean(name = "jdbcTemplateTwo")
    public JdbcTemplate jdbcTemplateTwo(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(twoDataSource);
        return jdbcTemplate;
    }

    @Bean(name = "jdbcTemplateThree")
    public JdbcTemplate jdbcTemplateThree(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(threeDataSource);
        return jdbcTemplate;
    }
}
