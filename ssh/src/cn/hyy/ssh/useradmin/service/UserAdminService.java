package cn.hyy.ssh.useradmin.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hyy.ssh.useradmin.dao.UserAdminDao;
import cn.lj.ssh.user.vo.User;


@Transactional
public class UserAdminService {
	
	/**
	 * 
	 * ע��Dao
	 * @author Scream
	 * 
	 * */
	private UserAdminDao userAdminDao;

	public void setUserAdminDao(UserAdminDao userAdminDao) {
		this.userAdminDao = userAdminDao;
	}

	//Service��Ĳ�ѯ�����û�
	public List<User> findAll() {

		return userAdminDao.findAll();
	}

	//Service������û�����״̬��ѯ
	public List<User> findByState(Integer state) {
		// TODO Auto-generated method stub
		return userAdminDao.findByState(state);
	}
	
	//Service�����UID��ѯ�û�
	public User findByUid(Integer uid) {
		return userAdminDao.findByUid(uid);
	}
	
	//Service���޸��û���Ϣ����
	public void update(User user) {
		userAdminDao.update(user);
	}
	
	//Service��ɾ���û���Ϣ����
	public void delete(User user) {
		userAdminDao.delete(user);
	}

}
