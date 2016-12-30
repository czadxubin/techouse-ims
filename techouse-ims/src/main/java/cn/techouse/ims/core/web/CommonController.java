package cn.techouse.ims.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
	/**
	 * 展示实体的列表页<br>
	 * 路径必须满足规则：<br>
	 *	/user/list-->User
	 *	/userGroup/list-->UserGroup
	 * @param entity
	 * @return
	 */
	@RequestMapping(path="{entity}/list")
	public String list(@PathVariable("entity") String entity){
		String list=entity.substring(0,1).toUpperCase()+entity.substring(1)+"List";
		list=entity+"/list";
		return list;
	}
	@RequestMapping(path="index")
	public String index(){
		return "index";
	}
}
