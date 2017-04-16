package cn.lj.ssh.user.service;

import cn.lj.ssh.user.vo.User;
import cn.lyj.ssh.user.dao.UserDao;

public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * 用户名查询用户是否存在
	 * @param username
	 * @return
	 */
	public User	 findByUserName(String username) {
		return null;
	}
	/**
	 * 保存用户信息，注册时可使用
	 * @param user
	 */
	private void save(User user) {
		
	}
	/**
	 * 校验用户激活码
	 * @param code：激活码
	 * @return
	 */
	public User findByCode(String code) {
		return null;
		
	}
	/**
	 * 查询到用户激活码以后修改用户激活状态
	 * @param existUser
	 */
	public void update(User existUser) {
		
	}
	/**
	 * 用户登录的方法
	 * @param user
	 * @return
	 */
	public User login(User user) {
		return null;
	}
}
