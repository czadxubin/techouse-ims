package cn.techouse.ims.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.techouse.ims.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Modifying(clearAutomatically=true)
	@Query("update User set validFlag = '0' where id in (:ids)")
	void deleteUsersByPks(@Param("ids") List<Serializable> pks);
	/**
	 * 通过用户名和有效标识查询用户
	 * @param username
	 * 			用户名
	 * @param validFlag
	 * 			有效标识
	 */
	public User findUserByUsernameAndValidFlag(String username,String validFlag);
}
