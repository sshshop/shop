package cn.lj.ssh.user.service;

import cn.lj.ssh.user.vo.User;
import cn.lyj.ssh.user.dao.UserDao;

public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * �û�����ѯ�û��Ƿ����
	 * @param username
	 * @return
	 */
	public User	 findByUserName(String username) {
		return null;
	}
	/**
	 * �����û���Ϣ��ע��ʱ��ʹ��
	 * @param user
	 */
	private void save(User user) {
		
	}
	/**
	 * У���û�������
	 * @param code��������
	 * @return
	 */
	public User findByCode(String code) {
		return null;
		
	}
	/**
	 * ��ѯ���û��������Ժ��޸��û�����״̬
	 * @param existUser
	 */
	public void update(User existUser) {
		
	}
	/**
	 * �û���¼�ķ���
	 * @param user
	 * @return
	 */
	public User login(User user) {
		return null;
	}
}
