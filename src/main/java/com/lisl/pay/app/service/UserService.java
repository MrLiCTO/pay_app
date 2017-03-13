package com.lisl.pay.app.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@RolesAllowed({"ROLE_role0"})
@Service
public class UserService {
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
