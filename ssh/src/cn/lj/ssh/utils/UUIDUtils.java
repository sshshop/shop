package cn.lj.ssh.utils;

import java.util.UUID;

/**
 * 负责提供UUID验证码
 * 
 * @author Rabit
 * 
 */
public class UUIDUtils {
	/**
	 * 获取一个64位的验证码
	 * @return
	 */
	public static String getUUID() {	
		return UUID.randomUUID().toString().replace("-", "")+UUID.randomUUID().toString().replace("-", "");
	}
}
