package cn.hyy.ssh.useradmin.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.hyy.ssh.useradmin.dao.UserAdminDao;
import cn.lj.ssh.user.vo.User;


@Transactional
public class UserAdminService {
	
	/**
	 * 
	 * 注入Dao
	 * @author Scream
	 * 
	 * */
	private UserAdminDao userAdminDao;

	public void setUserAdminDao(UserAdminDao userAdminDao) {
		this.userAdminDao = userAdminDao;
	}

	//Service层的查询所有用户
	public List<User> findAll() {

		return userAdminDao.findAll();
	}

	//Service层根据用户激活状态查询
	public List<User> findByState(Integer state) {
		// TODO Auto-generated method stub
		return userAdminDao.findByState(state);
	}

}
