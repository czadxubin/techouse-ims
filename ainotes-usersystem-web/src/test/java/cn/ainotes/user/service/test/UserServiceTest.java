package cn.ainotes.user.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ainotes.user.entity.User;
import cn.ainotes.user.service.facade.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-*.xml"})
public class UserServiceTest {
	@Autowired
	private UserService userService;
//	public User findUser(Serializable id);
//	public void deleteUserByPK(Serializable id);
//	public void addUser(User user);
//	public void updateUser(User user);
	@Test
	public void testAddUser(){
		User user = new User();
		user.setNickname("–Ì–°±¶");
		user.setUsername("czadxubin");
		user.setPassword("xubaozhong");
		userService.addUser(user);
	}
	@Test
	public void testFindUser(){
		User user=userService.findUser(1);
		System.out.println(user);
	}
	@Test
	public void testGet(){
		userService.get(1);
	}
}
