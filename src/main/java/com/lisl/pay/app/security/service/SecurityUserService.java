package com.lisl.pay.app.security.service;


import com.lisl.pay.app.model.one.SecurityRole;
import com.lisl.pay.app.model.one.SecurityUser;
import com.lisl.pay.app.repository.one.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
public class SecurityUserService implements UserDetailsService {
    @Autowired
    private SecurityUserRepository securityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SecurityUser user = securityUserRepository.findByUserName(s);
        if (user == null) {
            throw new UsernameNotFoundException("用户" + s + "不存在");
        }
        List<SecurityRole> roles = user.getRoles();
        HashSet<GrantedAuthority> set = new HashSet<>();
        for (SecurityRole role : roles) {
            set.addAll(role.getAuthorities());//加入用户权限
            set.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));//加入用户角色
        }
        user.setAuthorities(set);
        return user;
    }
}
