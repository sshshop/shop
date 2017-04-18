package cn.lyj.ssh.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.lj.ssh.user.service.UserService;
import cn.lj.ssh.user.vo.User;
import cn.lj.ssh.utils.SendMailUnitl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户模块action的类
 * @author 盖世太保
 *
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	//模型驱动使用的对象
	private User user=new User();
	
	public User getModel() {
		return user;
	}
	//注入UserService
	private UserService userService;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
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
	/*异常解决：注意userservice是自动装包的，如果在新实例化一个的话，那userservice就是另一个userservice了，所以会出现空指针异常*/
		/*User exitUser=new UserService.login(user);*/
		
		User exitUser=userService.login(user);
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
	 *用户注册 
	 *@author Scream
	 *
	 **/
	
	public String register(){
		userService.save(user);
		this.addActionMessage("注册成功！请到邮箱激活");
		return "msg";
	}
	
	/**
	 * 登录退出
	 * @author 盖世太保
	 * @return
	 */
	public String quit() {
		//销毁session退出登录
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	
	/**  AjAX进行异步校验
	 * @author 盖世太保
	 * @throws IOException 
	 * 
	 */
	public String findByName() throws IOException {
		// 调用Service进行查询:
		User existUser = userService.findByUsername(user.getUsername());
		// 获得response对象,项页面输出:
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if (existUser != null) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	/**
	 *用户激活
	 *@author Scream
	 * */
	
	public String active(){
		User existUser = userService.findByCode(user.getCode());
		//判断exitUser
		if (existUser == null){
			//激活失败
			this.addActionMessage("激活失败：激活码错误！");
			return NONE;
		}else{
			
			//激活成功
			//修改用户的状态
			existUser.setCode(null);
			existUser.setState(1);
			userService.update(existUser);
			
			return "active";
		}
	}
}
