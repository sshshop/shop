package cn.lyj.ssh.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.lj.ssh.user.service.UserService;
import cn.lj.ssh.user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户模块action的类
 * @author 盖世太保
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	//模型驱动使用的对象
	private User user=new User();
	public User getModel() {
		return user;
	}
	//注入UserService
	private UserService userService;
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
	 * 用户登录功能校验
	 * @return
	 */
	public String login(){
		User exitUser=new UserService().login(user);
		//判断用户
		if (exitUser==null) {
			//登录失败
			this.addActionError("登录失败，用户名或者密码错误或者用户未激活");
			return LOGIN;
		}else {
			//登录成功
			//将用户信息存在session中
			ServletActionContext.getRequest().getSession().setAttribute("existUser", exitUser);
			//页面跳转
			return "loginSuccess";
		}
	}
	
	/**
	 * 登录退出
	 * @author 盖世太保
	 * @return
	 */
	public String quit() {
		return "quit";
	}
	/**  AjAX进行异步校验
	 * @author 盖世太保
	 * @throws IOException 
	 * 
	 */
	public String findByName() throws IOException{
		
	//调用service进行查询
		User  existUser=userService.findByUserName(user.getUsername());
		//获得response对象，向页面输出
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
	//判断
		
		if (existUser!=null) {
			//查询到该用户：用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font> ");
		}
		else{
			//没有查询到该用户：用户可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font> ");
		}
		return NONE;
	}
}
