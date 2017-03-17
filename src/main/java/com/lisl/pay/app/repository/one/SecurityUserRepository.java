package com.lisl.pay.app.repository.one;

import com.lisl.pay.app.model.one.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/3/3.
 */
public interface SecurityUserRepository extends JpaRepository<SecurityUser, String> {
    public SecurityUser findByUserName(String s);
}
