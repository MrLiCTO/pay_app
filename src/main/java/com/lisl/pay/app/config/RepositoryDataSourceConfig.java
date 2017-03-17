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
        entityManagerFactoryRef = "entityManagerFactoryOne",
        transactionManagerRef = "transactionManagerOne",
        basePackages = {"com.lisl.pay.app.repository.one"}) //设置Repository所在位置
@Configuration
public class RepositoryDataSourceConfig {

    @Autowired
    @Qualifier("oneDataSource")
    private DataSource oneDataSource;

    @Primary
    @Bean(name = "entityManagerOne")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        EntityManager entityManager = entityManagerFactoryOne(builder).getObject().createEntityManager();
        entityManager.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return entityManager;
    }

    @Primary
    @Bean(name = "entityManagerFactoryOne")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryOne(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(oneDataSource)
                .properties(getVendorProperties(oneDataSource))
                .packages("com.lisl.pay.app.model.one") //设置实体类所在位置
                .persistenceUnit("onePersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "transactionManagerOne")
    public PlatformTransactionManager transactionManagerOne(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryOne(builder).getObject());
    }

}
