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
	 * 模型驱动的类
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
	 * 注入Service
	 * @author Scream
	 * 
	 * */
	private UserAdminService userAdminService;

	public void setUserAdminService(UserAdminService userAdminService) {
		this.userAdminService = userAdminService;
	}
	
	/**
	 * 
	 * 查询所有的用户
	 * @author Scream
	 * 
	 * */
	
	public String findAll(){
		//查询所有用户列表
		List<User> ulist = userAdminService.findAll();
		//将所有的数据返回到页面显示
		ActionContext.getContext().getValueStack().set("uList", ulist);
		
		return "findAll";
	}
	
	/**
	 * 
	 * 根据用户激活状态查询
	 * @author Scream
	 * 
	 * */

	public String findByState(){
		//根据用户激活状态查询用户列表
		System.out.println(user.getState());
		List<User> uList = userAdminService.findByState(user.getState());
		//将所有数据返回到页面显示
		ActionContext.getContext().getValueStack().set("uList", uList);
		return "findByState";
	}
	
	
}
