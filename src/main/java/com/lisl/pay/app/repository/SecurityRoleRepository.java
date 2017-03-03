package com.lisl.pay.app.repository;

import com.lisl.pay.app.model.SecurityAuthority;
import com.lisl.pay.app.model.SecurityRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/3/3.
 */
public interface SecurityRoleRepository extends JpaRepository<SecurityRole, String> {
}
