package cn.jidy.ssh.adminuser.action;

import org.apache.struts2.ServletActionContext;

import cn.jidy.ssh.adminuser.service.AdminUserService;
import cn.jidy.ssh.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 后台登陆的action
 */

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
	
	
	private AdminUser adminUser = new AdminUser();
	//模型驱动使用的对象
	public AdminUser getModel() {
		// TODO Auto-generated method stub
		return adminUser;
	}

	
	//注入service
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	
	//登陆的实现方法
	
	public String login() {
		AdminUser existAdminUser=adminUserService.login(adminUser);
		if(existAdminUser==null){
			//登陆失败
			this.addActionError("用户名或密码错误！");
			return "loginFail";
		}else {
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
		
		
	}
	/**
	 * 管理员退出
	 * @author 盖世太保
	 */
	
	public String quit(){
		
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
}
