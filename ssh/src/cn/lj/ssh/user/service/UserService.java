package cn.lj.ssh.user.service;

import cn.lj.ssh.user.vo.User;
import cn.lj.ssh.utils.SendMailUnitl;
import cn.lj.ssh.utils.UUIDUtils;
import cn.lyj.ssh.user.dao.UserDao;

public class UserService {
	// ע��UserDao
		private UserDao userDao;

		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}
		
		
		// ���û�����ѯ�û��ķ���:
		public User findByUsername(String username){
			return userDao.findByUsername(username);
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
	 * @author Scream
	 * @param user
	 */
	public void save(User user) {
		user.setState(0); //0����δ���1�����Ѽ��
		String code = UUIDUtils.getUUID();
		user.setCode(code);
		SendMailUnitl.senMail(user.getEmail(), code);
		userDao.save(user);
	}
	/**
	 * У���û�������
	 * @param code��������
	 * @author Scream
	 * @return
	 */
	public User findByCode(String code) {
		return userDao.findByCode(code);
		
	}
	/**
	 * ��ѯ���û��������Ժ��޸��û�����״̬
	 * @param existUser
	 * @author Scream
	 */
	public void update(User existUser) {
		userDao.update(existUser);
		
	}
	/**
	 * �û���¼�ķ���
	 * @param user
	 * @return
	 */
	public User login(User user) {
		return userDao.login(user);
	}
	public UserDao getUserDao() {
		return userDao;
	}
}
