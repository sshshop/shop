package cn.lj.ssh.utils;

import java.util.UUID;

/**
 * �����ṩUUID��֤��
 * 
 * @author Rabit
 * 
 */
public class UUIDUtils {
	/**
	 * ��ȡһ��64λ����֤��
	 * @return
	 */
	public static String getUUID() {	
		return UUID.randomUUID().toString().replace("-", "")+UUID.randomUUID().toString().replace("-", "");
	}
}
