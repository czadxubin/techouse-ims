package cn.techouse.ims.user.service.interf;

import java.io.Serializable;
import java.util.List;

import cn.techouse.ims.entity.User;

/**
 * User相关操作
 * @author 许宝众
 *
 */
public interface UserService {
	/**
	 * 注册用户
	 * @param user
	 */
	public void registerUser(User user);
	
	/**
	 * 判断用户是否已存在
	 * @param user
	 * @return
	 */
	public boolean isExisted(User user);
	
	/**
	 * 通过主键删除用户
	 * @param pks
	 *			主键 		
	 */
	public void deleteUsersByPKs(List<Serializable> pks);
	
	/**
	 * 更新用户信息
	 * @param user
	 * 			必须包含主键
	 */
	public void updateUser(User user);
	/**
	 * 通过用户名查询有效的用户
	 * @param user
	 * 			包含{username}、{validFlag}
	 */
	public User findUserByUsername(User user);

	/**
	 * 保存或者更新用户信息
	 * @param user
	 */
	public void saveUser(User user);
}
