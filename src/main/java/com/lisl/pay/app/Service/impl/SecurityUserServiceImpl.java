package com.lisl.pay.app.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2.
 */
@Service
public class SecurityUserServiceImpl implements UserDetailsService{
    /*@Autowired
    private UserRepository userRepository;*/
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String userName="";
        String password="";
        List authorities=null;
        return new User(userName,password,authorities);
    }
}
