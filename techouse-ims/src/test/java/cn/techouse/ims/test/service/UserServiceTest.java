package cn.techouse.ims.test.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import cn.techouse.ims.TechuseIMSApplicationBoot;
import cn.techouse.ims.entity.User;
import cn.techouse.ims.entity.UserGroup;
import cn.techouse.ims.user.service.interf.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes={TechuseIMSApplicationBoot.class})
public class UserServiceTest {
	@Autowired
	private UserService userService;
	@Test
	public void testIsExisted(){
		User user=new User();
		user.setUsername("czadxubin");
		user.setValidFlag("1");
		System.out.println(userService.isExisted(user));
	}
	@Test
	public void testDeleteUsersByPks(){
		List<Serializable> pks=new ArrayList<Serializable>();
		pks.add(1);
		pks.add(2);
		userService.deleteUsersByPKs(pks);
	}
	@Test
	public void testFindUserByUsername(){
	}
	
	@Test
	public void testSaveUser(){
		User user=new User();
		user.setUsername("xubin_null");
		HashSet<UserGroup> groups=new HashSet<UserGroup>();
		UserGroup group1 = new UserGroup();
		group1.setGroupCode("IMS_USER");
		group1.setGroupName("用户系统普通用户");
		group1.setSystemCode("IMS");
		
		UserGroup group2 = new UserGroup();
		group2.setGroupCode("SSO_USER");
		group2.setGroupName("单点系统普通用户");
		group2.setSystemCode("SSO");
		
		groups.add(group1);
		groups.add(group2);
		user.setGroups(null);
		userService.saveUser(user);
/*		User user=new User();
		user.setUsername("xubin");
		user=userService.findUserByUsername(user);
		user.setGroups(null);
		userService.saveUser(user);
*/	}
}
