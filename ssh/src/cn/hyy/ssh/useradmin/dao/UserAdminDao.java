package cn.hyy.ssh.useradmin.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;




import cn.lj.ssh.user.vo.User;

public class UserAdminDao extends HibernateDaoSupport{
	
	
	//Dao��Ĳ�ѯ�����û�
	public List<User> findAll() {
		
		String hql="from User";
		List<User> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	//Dao��ĸ����û�״̬��ѯ
	public List<User> findByState(Integer state) {
		String hql="from User where state = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, state);
		System.out.println(list.size());
		return list;
	}

}
