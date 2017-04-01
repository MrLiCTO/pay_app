package com.lisl.pay.app;

import com.lisl.pay.app.mango.dao.ShardingPersonDao;
import com.lisl.pay.app.mango.service.PersonService;
import com.lisl.pay.app.model.one.SecurityUser;
import com.lisl.pay.app.repository.one.SecurityAuthorityRepository;
import com.lisl.pay.app.repository.one.SecurityRoleRepository;
import com.lisl.pay.app.repository.one.SecurityUserRepository;
import com.lisl.pay.app.repository.one.SysModuleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private ShardingPersonDao personDao;
    @Autowired
    private PersonService personService;

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
        List<SecurityUser> list = new ArrayList();
        String encode = passwordEncoder.encode("test_pwd");
        System.out.println(passwordEncoder.matches("test_pwd", encode));
        //}
    }

    @Test
    public void testMongo() throws Exception {
        personService.addPerson();
//        for (int i = 0; i < 100; i++) {
//            Person person = new Person();
//            person.setAge(i);
//            person.setId(UUID.randomUUID().toString().replace("-", ""));
//            person.setName("linlin" + i);
//            personDao.add(person);
//        }
    }

}
