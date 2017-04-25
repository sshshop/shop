package cn.jidy.ssh.adminuser.action;

import org.apache.struts2.ServletActionContext;

import cn.jidy.ssh.adminuser.service.AdminUserService;
import cn.jidy.ssh.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * ��̨��½��action
 */

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser> {
	
	
	private AdminUser adminUser = new AdminUser();
	//ģ������ʹ�õĶ���
	public AdminUser getModel() {
		// TODO Auto-generated method stub
		return adminUser;
	}

	
	//ע��service
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	
	//��½��ʵ�ַ���
	
	public String login() {
		AdminUser existAdminUser=adminUserService.login(adminUser);
		if(existAdminUser==null){
			//��½ʧ��
			this.addActionError("�û������������");
			return "loginFail";
		}else {
			ServletActionContext.getRequest().getSession().setAttribute("existAdminUser", existAdminUser);
			return "loginSuccess";
		}
		
		
	}
	/**
	 * ����Ա�˳�
	 * @author ����̫��
	 */
	
	public String quit(){
		
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
}
