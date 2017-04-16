package cn.lyj.ssh.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lj.ssh.user.vo.User;

/**
 * 用户持久层模块
 * 
 * @author 盖世太保
 * 
 */
public class UserDao extends HibernateDaoSupport {
	// 按名字查询是否有该用户；
	public User findByUsername(String username) {
		String hql = "from User where username=?";
		List<User> list = this.getHibernateTemplate().find(hql, username);

		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public User login(User user) {
		String hqlString = "from User where username = ? and password = ? and state = 1";
		List<User> list = this.getHibernateTemplate().find(hqlString,
				user.getUsername(), user.getPassword());
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}
