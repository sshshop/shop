package cn.lyj.ssh.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.lj.ssh.user.service.UserService;
import cn.lj.ssh.user.vo.User;
import cn.lj.ssh.utils.SendMailUnitl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �û�ģ��action����
 * 
 * @author ����̫��
 * 
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ModelDriven<User> {
	// ����ҳ���ύ����֤��
	private String checkcode;
	public String getCheckcode() {
		return checkcode;
	}

	private String checkcode1;
	

	public String getCheckcode1() {
		return checkcode1;
	}

	public void setCheckcode1(String checkcode1) {
		this.checkcode1 = checkcode1;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	// ģ������ʹ�õĶ���
	private User user = new User();

	public User getModel() {
		return user;
	}

	// ע��UserService
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
	 * ��ת��ע��ҳ��ķ���
	 */

	public String registPage() {
		return "registPage";

	}

	/**
	 * ��ת����¼ҳ��
	 * 
	 * @author ����̫��
	 * @return
	 */
	public String loginPage() {
		return "loginpage";
	}

	/**
	 * �û���¼����У��
	 * 
	 * @return
	 */
	public String login() {
		/*
		 * �쳣�����ע��userservice���Զ�װ���ģ��������ʵ����һ���Ļ�����userservice������һ��userservice�ˣ�
		 * ���Ի���ֿ�ָ���쳣
		 */
		/* User exitUser=new UserService.login(user); 
		//��֤����֤
		String chcek1 = (String) ServletActionContext.getRequest().getAttribute(
				"checkcode1");
		System.out.println((chcek1)+"11111"+(checkcode));
			if (!chcek1.equalsIgnoreCase(checkcode)) {
				this.addActionError("��֤�������");
				return "checkcodelogin";
			}*/
		User exitUser = userService.login(user);
		// �ж��û�
		if (exitUser == null) {
			// ��¼ʧ��
			this.addActionError("��¼ʧ�ܣ��û������������������û�δ����");
			return LOGIN;
		} else {
			// ��¼�ɹ�
			// ���û���Ϣ����session��
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", exitUser);
			// ҳ����ת
			return "loginSuccess";
		}
	}

	/**
	 * 
	 * �û�ע��
	 * @author Scream
	 * 
	 **/

	public String register() {
		// �ж���֤�����
		// ��session�л�ȡ
		String chcek = (String) ServletActionContext.getRequest().getAttribute(
				"checkcode");
		System.out.println(chcek);
			if (!checkcode.equalsIgnoreCase(chcek)) {
				this.addActionError("��֤�������");
				return "checkcodeFail";
			}
		userService.save(user);
		this.addActionMessage("ע��ɹ����뵽���伤��");
		return "msg";
	}

	/**
	 * ��¼�˳�
	 * 
	 * @author ����̫��
	 * @return
	 */
	public String quit() {
		// ����session�˳���¼
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}

	/**
	 * AjAX�����û����첽У��
	 * 
	 * @author ����̫��
	 * @throws IOException
	 * 
	 */
	public String findByName() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// ����Service���в�ѯ:
		User existUser = userService.findByUsername(user.getUsername());
		// ���response����,��ҳ�����:
		// �ж�
		if ((user.getUsername().indexOf(" ")>0)|user.getUsername().equals("")|existUser != null) {
			// ��ѯ�����û�:�û����Ѿ�����
			response.getWriter().println("<font color='red'>�û������ڿո�����Ѿ�����</font>");
		} else {
			// û��ѯ�����û�:�û�������ʹ��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}
	
	/**
	 * 
	 * AJAX���������첽У��
	 * @author Scream
	 * 
	 * */
	
	public String findByEmail() throws IOException {
		//����Service����в�ѯ
		User existUser = userService.findByEmail(user.getEmail());
		//��ȡresponse������ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		//�����ж�
		if( existUser != null){
			//��������ڿ����Ѿ����ڸ�����
			response.getWriter().println("<font color='red'>�������Ѵ���</font>");
		}else{
			//���򲢲����ڸ�����
			response.getWriter().println("<font color='green'>���������ʹ��</font>");
		}
		return NONE;
	}

	/**
	 * �û�����
	 * 
	 * @author Scream
	 * */

	public String active() {
		User existUser = userService.findByCode(user.getCode());
		// �ж�exitUser
		if (existUser == null) {
			// ����ʧ��
			this.addActionMessage("����ʧ�ܣ����������");
			return NONE;
		} else {

			// ����ɹ�
			// �޸��û���״̬
			existUser.setCode(null);
			existUser.setState(1);
			userService.update(existUser);
			return "active";
		}
	}
}
