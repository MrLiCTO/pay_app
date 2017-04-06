package com.lisl.pay.app;

import com.lisl.pay.app.mango.dao.ShardingPersonDao;
import com.lisl.pay.app.mango.service.PersonService;
import com.lisl.pay.app.model.one.SecurityAuthority;
import com.lisl.pay.app.model.one.SecurityRole;
import com.lisl.pay.app.model.one.SecurityUser;
import com.lisl.pay.app.model.one.SysModule;
import com.lisl.pay.app.repository.one.SecurityAuthorityRepository;
import com.lisl.pay.app.repository.one.SecurityRoleRepository;
import com.lisl.pay.app.repository.one.SecurityUserRepository;
import com.lisl.pay.app.repository.one.SysModuleRepository;
import com.lisl.pay.app.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.transaction.TransactionManager;
import java.util.ArrayList;
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
    @Autowired
    private ShardingPersonDao personDao;
    @Autowired
    private PersonService personService;
	@Autowired
    private UserService userService;

	@Resource(name = "jdbcTemplateOne")
	private JdbcTemplate jdbcTemplateOne;

	@Resource(name = "jdbcTemplateTwo")
	private JdbcTemplate jdbcTemplateTwo;

	@Resource(name = "jdbcTemplateThree")
	private JdbcTemplate jdbcTemplateThree;

	@Autowired
	private TransactionManager transactionManager;//可以直接注入使用

    @Test
    public void contextLoads() {
        SecurityUser securityUser=new SecurityUser();
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
		securityUserRepository.save(securityUser);
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
//            PersonOne person = new PersonOne();
//            person.setAge(i);
//            person.setId(UUID.randomUUID().toString().replace("-", ""));
//            person.setName("linlin" + i);
//            personDao.add(person);
//        }
    }

    @Test//测试JPA分布式事务
    public void testJta() throws Exception {
		userService.addPersons();
    }

    @Test//测试DBC分布式事务
	@Transactional(rollbackFor = Exception.class)//注解可以
    public void testJDBC() throws Exception {
		/*transactionManager.begin();
		jdbcTemplateOne.update("insert into person(id, name, sex, age) values(?,?,?,?)","lll4","ddd","男",19);
		jdbcTemplateTwo.update("insert into person(id, name, sex, age) values(?,?,?,?)","lll5","ddd","男",19);
		jdbcTemplateThree.update("insert into person(id, name, sex, age) values(?,?,?,?)","lll6","ddd","男",19);
		//transactionManager.commit();
		transactionManager.rollback();*/
		jdbcTemplateOne.update("insert into person(id, name, sex, age) values(?,?,?,?)","lll4","ddd","男",19);
		jdbcTemplateTwo.update("insert into person(id, name, sex, age) values(?,?,?,?)","lll5","ddd","男",19);
		jdbcTemplateThree.update("insert into person(id, name, sex, age) values(?,?,?,?)","lll6","ddd","男",19);
		int i=1/0;
    }

}
