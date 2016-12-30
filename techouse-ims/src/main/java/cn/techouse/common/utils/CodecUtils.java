package cn.techouse.common.utils;

import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.util.DigestUtils;

import cn.techouse.ims.entity.User;


/**
 * 加密解密工具类
 * @author 许宝众
 *
 */
public class CodecUtils {
	/**
	 * 加密用户密码
	 * @param user
	 * @return
	 * 			返回用户
	 */
	public static void encodePwd(User user) throws Exception{
		String password=user.getPassword();
		if(password==null){
			throw new RuntimeException("密码加密前为空");
		}
		//md5Encoding用户密码
		String md5Pwd=null;
		Integer salt=(int) (Math.random()*101);
		md5Pwd = cryptPwd(password, salt);
		user.setPassword(md5Pwd);
		user.setSalt(salt);
	}
	public static String cryptPwd(String password, Integer salt) {
		String md5Pwd=null;
		try {
			md5Pwd = Md5Crypt.md5Crypt(password.getBytes("UTF-8"),salt.toString(),"\\d+");
			if(md5Pwd==null){
				throw new RuntimeException("明文密码转md5密码失败");
			}else{
				byte[] bytes = md5Pwd.getBytes("UTF-8");
				md5Pwd = DigestUtils.md5DigestAsHex(bytes);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return md5Pwd;
	}
	
}
