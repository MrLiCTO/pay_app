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
        entityManagerFactoryRef = "entityManagerFactoryThree",
        transactionManagerRef = "transactionManagerThree",
        basePackages = {"com.lisl.pay.app.repository.three"}) //设置Repository所在位置
@Configuration
public class ThreeRepositoryDataSourceConfig {

    @Autowired
    @Qualifier("threeDataSource")
    private DataSource threeDataSource;

    @Bean(name = "entityManagerThree")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        EntityManager entityManager = entityManagerFactoryThree(builder).getObject().createEntityManager();
        entityManager.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return entityManager;
    }

    @Bean(name = "entityManagerFactoryThree")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryThree(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(threeDataSource)
                .properties(getVendorProperties(threeDataSource))
                .packages("com.lisl.pay.app.model.three") //设置实体类所在位置
                .persistenceUnit("threePersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "transactionManagerThree")
    public PlatformTransactionManager transactionManagerThree(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryThree(builder).getObject());
    }

}
