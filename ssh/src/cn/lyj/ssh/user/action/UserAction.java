package cn.lyj.ssh.user.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �û�ģ��action����
 * @author ����̫��
 *
 */
public class UserAction extends ActionSupport {

	
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
	 * ��¼�˳�
	 * @author ����̫��
	 * @return
	 */
	public String quit() {
		return "quit";
	}
}
