package com.lisl.pay.app.Service.impl;


import com.lisl.pay.app.Service.SecurityUserService;
import com.lisl.pay.app.model.SecurityAuthority;
import com.lisl.pay.app.model.SecurityRole;
import com.lisl.pay.app.model.SecurityUser;
import com.lisl.pay.app.repository.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
@Service
public class SecurityUserServiceImpl implements SecurityUserService{
    @Autowired
    private SecurityUserRepository securityUserRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SecurityUser user = securityUserRepository.findByUserName(s);
        List<SecurityRole> roles = user.getRoles();
        HashSet<SecurityAuthority> set = new HashSet<>();
        for (SecurityRole role:roles){
            set.addAll(role.getAuthorities());
        }
        user.setAuthorities(set);
        return user;
    }
}
