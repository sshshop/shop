package cn.lyj.ssh.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.lj.ssh.user.service.UserService;
import cn.lj.ssh.user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �û�ģ��action����
 * @author ����̫��
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	//ģ������ʹ�õĶ���
	private User user=new User();
	public User getModel() {
		return user;
	}
	//ע��UserService
	private UserService userService;
	/**
	 * ��ת��ע��ҳ��ķ���
	 */
	
	public String registPage() {
		return "registPage";
		
	}
	/**
	 * ��ת����¼ҳ��
	 * @author ����̫��
	 * @return
	 */
	public String loginPage() {
		return "loginpage";
	}
	/**
	 * �û���¼����У��
	 * @return
	 */
	public String login(){
		User exitUser=new UserService().login(user);
		//�ж��û�
		if (exitUser==null) {
			//��¼ʧ��
			this.addActionError("��¼ʧ�ܣ��û������������������û�δ����");
			return LOGIN;
		}else {
			//��¼�ɹ�
			//���û���Ϣ����session��
			ServletActionContext.getRequest().getSession().setAttribute("existUser", exitUser);
			//ҳ����ת
			return "loginSuccess";
		}
	}
	
	/**
	 * ��¼�˳�
	 * @author ����̫��
	 * @return
	 */
	public String quit() {
		return "quit";
	}
	/**  AjAX�����첽У��
	 * @author ����̫��
	 * @throws IOException 
	 * 
	 */
	public String findByName() throws IOException{
		
	//����service���в�ѯ
		User  existUser=userService.findByUserName(user.getUsername());
		//���response������ҳ�����
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
	//�ж�
		
		if (existUser!=null) {
			//��ѯ�����û����û����Ѿ�����
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font> ");
		}
		else{
			//û�в�ѯ�����û����û�����ʹ��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font> ");
		}
		return NONE;
	}
}
