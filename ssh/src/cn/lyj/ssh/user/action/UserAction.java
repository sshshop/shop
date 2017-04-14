package cn.lyj.ssh.user.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户模块action的类
 * @author 盖世太保
 *
 */
public class UserAction extends ActionSupport {

	
	/**
	 * 跳转到注册页面的方法
	 */
	
	public String registPage() {
		return "registPage";
		
	}
}
