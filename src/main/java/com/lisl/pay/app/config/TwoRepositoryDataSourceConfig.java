package com.lisl.pay.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryTwo",
        //transactionManagerRef = "transactionManagerTwo",
        basePackages = {"com.lisl.pay.app.repository.two"}) //设置Repository所在位置
@Configuration
public class TwoRepositoryDataSourceConfig {

    @Autowired
    @Qualifier("twoDataSource")
    private DataSource twoDataSource;

    @Bean(name = "entityManagerTwo")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        EntityManager entityManager = entityManagerFactoryTwo(builder).getObject().createEntityManager();
        entityManager.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return entityManager;
    }

    @Bean(name = "entityManagerFactoryTwo")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTwo(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(twoDataSource)
                .properties(getVendorProperties(twoDataSource))
                .packages("com.lisl.pay.app.model.two") //设置实体类所在位置
                .persistenceUnit("twoPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    /*@Bean(name = "transactionManagerTwo")
    public PlatformTransactionManager transactionManagerTwo(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryTwo(builder).getObject());
    }*/

}
