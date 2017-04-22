package cn.hyy.ssh.useradmin.action;

import java.util.List;

import cn.hyy.ssh.useradmin.service.UserAdminService;
import cn.lj.ssh.user.vo.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAdminAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 
	 * ģ����������
	 * @author Scream
	 * 
	 * */
	private User user = new User();

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	/**
	 * 
	 * ע��Service
	 * @author Scream
	 * 
	 * */
	private UserAdminService userAdminService;

	public void setUserAdminService(UserAdminService userAdminService) {
		this.userAdminService = userAdminService;
	}
	
	/**
	 * 
	 * ��ѯ���е��û�
	 * @author Scream
	 * 
	 * */
	
	public String findAll(){
		//��ѯ�����û��б�
		List<User> ulist = userAdminService.findAll();
		//�����е����ݷ��ص�ҳ����ʾ
		ActionContext.getContext().getValueStack().set("uList", ulist);
		
		return "findAll";
	}
	
	/**
	 * 
	 * �����û�����״̬��ѯ
	 * @author Scream
	 * 
	 * */

	public String findByState(){
		//�����û�����״̬��ѯ�û��б�
		System.out.println(user.getState());
		List<User> uList = userAdminService.findByState(user.getState());
		//���������ݷ��ص�ҳ����ʾ
		ActionContext.getContext().getValueStack().set("uList", uList);
		return "findByState";
	}
	
	
}
