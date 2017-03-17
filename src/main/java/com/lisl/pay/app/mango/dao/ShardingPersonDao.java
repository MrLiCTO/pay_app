package com.lisl.pay.app.mango.dao;

import com.lisl.pay.app.mango.model.Person;
import com.lisl.pay.app.mango.strategy.PersonShardingStrategy;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.jfaster.mango.annotation.Sharding;
import org.jfaster.mango.annotation.ShardingBy;

/**
 * TableShardingStrategy
 * DatabaseShardingStrategy
 * ShardingStrategy
 */
@DB(table = "person")
@Sharding(shardingStrategy = PersonShardingStrategy.class)
public interface ShardingPersonDao {

    @SQL("insert into #table(id, name, sex, age) values(:id, :name, :sex, :age)")
    public void add(@ShardingBy("id") Person person);

    @SQL("select id, name, sex, age from #table where id = :1")
    public Person getByid(@ShardingBy String id);

    /*@SQL("select id, name, sex, age from #table where name like %:1%")
    public List<Person> findByName(String name);*/

    @SQL("delete from #table where id = :1")
    public void delete(@ShardingBy String id);
}