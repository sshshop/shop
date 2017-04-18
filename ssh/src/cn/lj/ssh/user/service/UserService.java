package cn.lj.ssh.user.service;

import cn.lj.ssh.user.vo.User;
import cn.lj.ssh.utils.SendMailUnitl;
import cn.lj.ssh.utils.UUIDUtils;
import cn.lyj.ssh.user.dao.UserDao;

public class UserService {
	// 注入UserDao
		private UserDao userDao;

		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}
		
		
		// 按用户名查询用户的方法:
		public User findByUsername(String username){
			return userDao.findByUsername(username);
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
	 * @author Scream
	 * @param user
	 */
	public void save(User user) {
		user.setState(0); //0代表未激活，1代表已激活。
		String code = UUIDUtils.getUUID();
		user.setCode(code);
		SendMailUnitl.senMail(user.getEmail(), code);
		userDao.save(user);
	}
	/**
	 * 校验用户激活码
	 * @param code：激活码
	 * @author Scream
	 * @return
	 */
	public User findByCode(String code) {
		return userDao.findByCode(code);
		
	}
	/**
	 * 查询到用户激活码以后修改用户激活状态
	 * @param existUser
	 * @author Scream
	 */
	public void update(User existUser) {
		userDao.update(existUser);
		
	}
	/**
	 * 用户登录的方法
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
