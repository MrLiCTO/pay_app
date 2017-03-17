package com.lisl.pay.app.mango.config;

import org.jfaster.mango.datasource.MasterSlaveDataSourceFactory;
import org.jfaster.mango.datasource.SimpleDataSourceFactory;
import org.jfaster.mango.operator.Mango;
import org.jfaster.mango.plugin.spring.MangoDaoScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/16.
 */
@Configuration
public class MangoShardConfig {
    @Autowired
    @Qualifier("oneDataSource")
    private DataSource oneDataSource;
    @Autowired
    @Qualifier("twoDataSource")
    private DataSource twoDataSource;
    @Autowired
    @Qualifier("threeDataSource")
    private DataSource threeDataSource;

    @Bean(name = "masterSlaveDataSourceFactory")
    public MasterSlaveDataSourceFactory masterSlaveDataSourceFactory() {
        MasterSlaveDataSourceFactory masterSlaveDataSourceFactory = new MasterSlaveDataSourceFactory();
        masterSlaveDataSourceFactory.setMaster(twoDataSource);
        ArrayList<DataSource> dataSources = new ArrayList<>();
        dataSources.add(threeDataSource);
        masterSlaveDataSourceFactory.setSlaves(dataSources);
        masterSlaveDataSourceFactory.setName("masterSlaveDataSourceFactory");
        return masterSlaveDataSourceFactory;
    }

    @Bean(name = "simpleDataSourceFactory")
    public SimpleDataSourceFactory simpleDataSourceFactory() {
        SimpleDataSourceFactory simpleDataSourceFactory = new SimpleDataSourceFactory();
        simpleDataSourceFactory.setDataSource(oneDataSource);
        simpleDataSourceFactory.setName("simpleDataSourceFactory");
        return simpleDataSourceFactory;
    }


    @Bean
    public Mango mango() {
        Mango mango = Mango.newInstance();
        mango.addDataSourceFactory(masterSlaveDataSourceFactory());
        mango.addDataSourceFactory(simpleDataSourceFactory());
        return mango;
    }
}
