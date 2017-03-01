package cn.ainotes.user.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ainotes.user.entity.User;

@Controller
@RequestMapping("user")
public class UserController {
	
//	@PathVariable
	@RequestMapping(method=RequestMethod.GET,value="/{userId}")
	public @ResponseBody User getUser(@PathVariable("userId")String userId,@RequestParam String passwd){
		User user = new User();
		user.setUsername("xbz");
		user.setPassword("1215xubin");
		return user;
	}
}
