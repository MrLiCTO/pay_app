package com.lisl.pay.app.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * Created by Administrator on 2017/1/16.
 */
@Configuration
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class, //if you are using Hibernate
        DataSourceTransactionManagerAutoConfiguration.class})
public class DruidConfigration {
    private Logger logger = LoggerFactory.getLogger(DruidConfigration.class);

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;

    //one数据源(主)
    @Value("${spring.datasource.one.url}")
    private String dbUrl;

    @Value("${spring.datasource.one.username}")
    private String username;

    @Value("${spring.datasource.one.password}")
    private String password;

    @Value("${spring.datasource.one.driver-class-name}")
    private String driverClassName;

    //two数据源
    @Value("${spring.datasource.two.url}")
    private String dbUrl_two;

    @Value("${spring.datasource.two.username}")
    private String username_two;

    @Value("${spring.datasource.two.password}")
    private String password_two;

    @Value("${spring.datasource.two.driver-class-name}")
    private String driverClassName_two;

    //three数据源
    @Value("${spring.datasource.three.url}")
    private String dbUrl_three;

    @Value("${spring.datasource.three.username}")
    private String username_three;

    @Value("${spring.datasource.three.password}")
    private String password_three;

    @Value("${spring.datasource.three.driver-class-name}")
    private String driverClassName_three;

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    @Qualifier("oneDataSource")
    public DataSource oneDataSource() {
        DruidXADataSource datasource = new DruidXADataSource();//mongo不支持该数据源
        //DruidDataSource datasource=new DruidDataSource();//该数据源不支持Atomikos
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (Exception e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);

        AtomikosDataSourceBean atomikosDataSource=new AtomikosDataSourceBean();
        atomikosDataSource.setUniqueResourceName("oneDataSource");
        atomikosDataSource.setXaDataSource(datasource);
        atomikosDataSource.setMinPoolSize(5);
        atomikosDataSource.setMaxPoolSize(20);
        atomikosDataSource.setTestQuery("SELECT 1");

        return atomikosDataSource;
    }

    @Bean     //声明其为Bean实例
    @Qualifier("twoDataSource")
    public DataSource twoDataSource() {
        DruidXADataSource datasource = new DruidXADataSource();
        datasource.setUrl(this.dbUrl_two);
        datasource.setUsername(username_two);
        datasource.setPassword(password_two);
        datasource.setDriverClassName(driverClassName_two);
        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (Exception e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);

        AtomikosDataSourceBean atomikosDataSource=new AtomikosDataSourceBean();
        atomikosDataSource.setUniqueResourceName("twoDataSource");
        atomikosDataSource.setXaDataSource(datasource);
        atomikosDataSource.setMinPoolSize(5);
        atomikosDataSource.setMaxPoolSize(20);
        atomikosDataSource.setTestQuery("SELECT 1");

        return atomikosDataSource;
    }

    @Bean     //声明其为Bean实例
    @Qualifier("threeDataSource")
    public DataSource threeDataSource() {
        DruidXADataSource datasource = new DruidXADataSource();
        datasource.setUrl(this.dbUrl_three);
        datasource.setUsername(username_three);
        datasource.setPassword(password_three);
        datasource.setDriverClassName(driverClassName_three);
        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (Exception e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);

        AtomikosDataSourceBean atomikosDataSource=new AtomikosDataSourceBean();
        atomikosDataSource.setUniqueResourceName("threeDataSource");
        atomikosDataSource.setXaDataSource(datasource);
        atomikosDataSource.setMinPoolSize(5);
        atomikosDataSource.setMaxPoolSize(20);
        atomikosDataSource.setTestQuery("SELECT 1");

        return atomikosDataSource;
    }
}
