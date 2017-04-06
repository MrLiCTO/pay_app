package com.lisl.pay.app.service;

import com.lisl.pay.app.model.one.PersonOne;
import com.lisl.pay.app.model.three.PersonThree;
import com.lisl.pay.app.model.two.PersonTwo;
import com.lisl.pay.app.repository.one.PersonOneRepository;
import com.lisl.pay.app.repository.three.PersonThreeRepository;
import com.lisl.pay.app.repository.two.PersonTwoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/13.
 */
//@RolesAllowed({"ROLE_role0"})
@Service
public class UserService {
    @Autowired
    private PersonOneRepository personOneRepository;
    @Autowired
    private PersonTwoRepository personTwoRepository;
    @Autowired
    private PersonThreeRepository personThreeRepository;

    @Transactional(rollbackFor=Exception.class)
    public void addPersons() {
        PersonOne person1 = new PersonOne();
        person1.setAge(1);
        person1.setId(UUID.randomUUID().toString().replace("-", ""));
        person1.setName("linlin" + 1);
        personOneRepository.save(person1);

        PersonTwo person2 = new PersonTwo();
        person2.setAge(2);
        person2.setId(UUID.randomUUID().toString().replace("-", ""));
        person2.setName("linlin" + 2);
        personTwoRepository.save(person2);

        PersonThree person3 = new PersonThree();
        person3.setAge(3);
        person3.setId(UUID.randomUUID().toString().replace("-", ""));
        person3.setName("linlin" + 3);
        personThreeRepository.save(person3);

        int i=1/0;
    }


    public void addUser() {

        System.out.println("addUser................");

    }



    public void updateUser() {
        System.out.println("updateUser..............");

    }


    /**
     * @PostAuthorize("returnObject.id%2==0")
     * @return
     */
    @RolesAllowed({"ROLE_role1", "ROLE_role0"})
    public int find() {

        System.out.println("find user by id.............");

        return 2;

    }
    /**
     * @PreAuthorize("principal.username.equals(#username)")
     * @PreAuthorize("#user.name.equals('abc')")
     * @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
     * @PreAuthorize("hasRole('ROLE_ADMIN')")
     */
    @PreAuthorize("#id<10")
    public void delete(int id) {

        System.out.println("delete user by id................");

    }


    /**
     * @PermitAll
     * @DenyAll
     */
    @RolesAllowed("ROLE_role1")
    public List<String> findAll() {

        System.out.println("find all user...............");

        return null;

    }
}
