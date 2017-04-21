package cn.jidy.ssh.interceptor;

import org.apache.struts2.ServletActionContext;

import cn.jidy.ssh.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//��̨����������

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	//ִ�����صķ���
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		AdminUser existAdminUser= (AdminUser) ServletActionContext.getRequest().getSession().getAttribute("existAdminUser");
		if(existAdminUser==null){
			ActionSupport actionSupport=(ActionSupport) actionInvocation.getAction();
			actionSupport.addActionError("�ף�����û�е�¼��û�з���Ȩ��");
			return "loginFail";
		}else{
			//�û���¼
			return actionInvocation.invoke();
		}
		
	}

}