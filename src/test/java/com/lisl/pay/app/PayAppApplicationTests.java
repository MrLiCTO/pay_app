package com.lisl.pay.app;

import com.lisl.pay.app.model.SecurityAuthority;
import com.lisl.pay.app.model.SecurityRole;
import com.lisl.pay.app.model.SecurityUser;
import com.lisl.pay.app.model.SysModule;
import com.lisl.pay.app.repository.SecurityAuthorityRepository;
import com.lisl.pay.app.repository.SecurityRoleRepository;
import com.lisl.pay.app.repository.SecurityUserRepository;
import com.lisl.pay.app.repository.SysModuleRepository;
import com.sun.jmx.snmp.internal.SnmpSecurityModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PayAppApplicationTests {
	@Autowired
	private SecurityUserRepository securityUserRepository;
	@Autowired
	private SecurityRoleRepository securityRoleRepository;
	@Autowired
	private SecurityAuthorityRepository securityAuthorityRepository;
	@Autowired
	private SysModuleRepository sysModuleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Test
	public void contextLoads() {
		/*SecurityUser securityUser=new SecurityUser();
		securityUser.setId(UUID.randomUUID().toString().replace("-",""));
		securityUser.setAccountNonExpired(true);
		securityUser.setAccountNonLocked(true);
		securityUser.setCredentialsNonExpired(true);
		securityUser.setEnabled(true);
		securityUser.setUserName("testHello");
		securityUser.setPassWord("testWorld");
		List<SecurityRole> roles=new ArrayList<>();
		List<SecurityAuthority> authorities=new ArrayList<>();
		SysModule module = new SysModule();
		module.setId(UUID.randomUUID().toString().replace("-",""));
		module.setEnabled(true);
		module.setName("model");
		sysModuleRepository.save(module);
		for (int i = 0; i <20 ; i++) {
			SecurityAuthority sa=new SecurityAuthority();
			sa.setEnabled(true);
			sa.setId(UUID.randomUUID().toString().replace("-",""));
			sa.setName("authority"+i);
			sa.setOperation("world"+i);
			sa.setModule(module);
			authorities.add(sa);
		}
		securityAuthorityRepository.save(authorities);
		for (int i = 0; i < 10; i++) {
			SecurityRole role = new SecurityRole();
			role.setId(UUID.randomUUID().toString().replace("-",""));
			role.setEnabled(true);
			role.setCode("000"+i);
			role.setName("role"+i);
			role.setAuthorities(authorities);
			roles.add(role);
		}
		securityRoleRepository.save(roles);
		securityUser.setRoles(roles);
		securityUserRepository.save(securityUser);*/
	}
	@Test
	public void testFind() {
		/*SecurityUser hello = securityUserRepository.findByUserName("testHello");
		String encode = passwordEncoder.encode(hello.getPassWord());
		hello.setPassWord(encode);
		securityUserRepository.save(hello);*/
		//for (int i=0;i<10;i++){
			String encode = passwordEncoder.encode("test_pwd");
			System.out.println(passwordEncoder.matches("test_pwd",encode));
		//}
	}

}
