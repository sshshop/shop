package cn.hyy.ssh.useradmin.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;





import cn.lj.ssh.user.vo.User;

public class UserAdminDao extends HibernateDaoSupport{
	
	
	//Dao层的查询所有用户
	public List<User> findAll() {
		
		String hql="from User";
		List<User> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	//Dao层的根据用户状态查询
	public List<User> findByState(Integer state) {
		String hql="from User where state = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, state);
		System.out.println(list.size());
		return list;
	}
	
	//Dao层根据UID查询用户并返回User
	public User findByUid(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}

	//Dao层修改用户信息
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}
	
	//Dao层删除用户信息
	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
	}

}
