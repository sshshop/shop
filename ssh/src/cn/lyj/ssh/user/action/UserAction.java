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
	/**
	 * 跳转到登录页面
	 * @author 盖世太保
	 * @return
	 */
	public String loginPage() {
		return "loginpage";
	}
	
	/**
	 * 登录退出
	 * @author 盖世太保
	 * @return
	 */
	public String quit() {
		return "quit";
	}
}
