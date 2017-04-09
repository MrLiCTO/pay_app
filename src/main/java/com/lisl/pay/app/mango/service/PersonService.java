package com.lisl.pay.app.mango.service;

import com.lisl.pay.app.mango.dao.ShardingPersonDao;
import com.lisl.pay.app.mango.model.Person;
import com.lisl.pay.app.mango.trasaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Administrator on 2017/3/17.
 */
@Service
public class PersonService {
    @Autowired
    private ShardingPersonDao personDao;

    @Transaction
    //@Transactional(rollbackFor = Exception.class)
    public void addPerson() throws Exception {
        /*Transaction transaction = TransactionFactory.newTransaction();
        try {*/
            for (int i = 0; i < 100; i++) {
                Person person = new Person();
                person.setAge(i);
                person.setId(UUID.randomUUID().toString().replace("-", ""));
                person.setName("linlin" + i);
                personDao.add(person);
                System.out.println(person);
//                if (i == 99) {
//                    throw new Exception();
//                }
            }
        /*} catch (Exception e) {
            transaction.rollback();
        }
        transaction.commit();*/
       /* TransactionTemplate.execute(new TransactionAction() {
            @Override
            public void doInTransaction(TransactionStatus status){
                for (int i = 0; i < 100; i++) {
                    PersonOne person = new PersonOne();
                    person.setAge(i);
                    person.setId(UUID.randomUUID().toString().replace("-", ""));
                    person.setName("linlin" + i);
                    personDao.add(person);
                    System.out.println(person);
                    if (i == 99) {
                        int a=1/0;
                    }
                }
            }
        });*/
    }
}
