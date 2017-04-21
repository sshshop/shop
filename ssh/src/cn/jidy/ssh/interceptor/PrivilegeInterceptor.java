package cn.jidy.ssh.interceptor;

import org.apache.struts2.ServletActionContext;

import cn.jidy.ssh.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//后台操作拦截器

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	//执行拦截的方法
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		AdminUser existAdminUser= (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("existAdminUser");
		if(existAdminUser==null){
			ActionSupport actionSupport=(ActionSupport) actionInvocation.getAction();
			actionSupport.addActionError("亲，您还没有登录，没有访问权限");
			return "loginFail";
		}else{
			//用户登录
			return actionInvocation.invoke();
		}
		
	}

}