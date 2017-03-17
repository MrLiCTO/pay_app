package com.lisl.pay.app.mango.strategy;

import org.jfaster.mango.sharding.ShardingStrategy;

public class PersonShardingStrategy implements ShardingStrategy<String, String> {
    @Override
    public String getDataSourceFactoryName(String shardingParameter) {
        return shardingParameter.hashCode() % 2 == 0 ? "simpleDataSourceFactory" : "masterSlaveDataSourceFactory";
    }

    @Override
    public String getTargetTable(String table, String shardingParameter) {
        return table;
    }
}