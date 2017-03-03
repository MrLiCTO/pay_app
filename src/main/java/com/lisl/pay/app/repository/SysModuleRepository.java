package com.lisl.pay.app.repository;

import com.lisl.pay.app.model.SecurityUser;
import com.lisl.pay.app.model.SysModule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/3/3.
 */
public interface SysModuleRepository extends JpaRepository<SysModule, String> {
}
