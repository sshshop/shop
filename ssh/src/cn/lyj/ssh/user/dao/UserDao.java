package cn.lyj.ssh.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lj.ssh.user.vo.User;

/**
 * �û��־ò�ģ��
 * 
 * @author ����̫��
 * 
 */
public class UserDao extends HibernateDaoSupport {
	
	// �����β�ѯ�Ƿ��и��û�:
		public User findByUsername(String username){
			String hql = "from User where username = ?";
			List<User> list = this.getHibernateTemplate().find(hql, username);
			if(list != null && list.size() > 0){
				return list.get(0);
			}
			return null;
		}

	@SuppressWarnings("unchecked")
	public User login(User user) {
		String hqlString = "from User where username = ? and password = ? and state = 1";
		List<User> list = this.getHibernateTemplate().find(hqlString,
				user.getUsername(), user.getPassword());
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	/*
	 * ���ݼ������ѯ�û�
	 * @author Scream
	 */
	
		public User findByCode(String code) {
			// TODO Auto-generated method stub
			String hql = "from  User where code = ?";
			List<User> list = this.getHibernateTemplate().find(hql,code);
			if ( list != null && list.size()>0) {
				 return list.get(0);
			}
			return null;
		}

		/*
		 * �����û�״̬
		 * @author Scream
		 */
		public void update(User existUser) {
			// TODO Auto-generated method stub
			this.getHibernateTemplate().update(existUser);
			
		}
		/*
		 * �����û�״̬
		 * @author Scream
		 */
		public void save(User user) {
			this.getHibernateTemplate().save(user);		
		}
		/**
		 * 
		 * ���������ѯ�û�	
		 * @author Scream
		 * 
		 * */
		public User findByEmail(String email) {
			String hql="from User where email = ?";
			List<User> list = this.getHibernateTemplate().find(hql, email);
			if( list != null && list.size() > 0 ){
				return list.get(0);
			}
			return null;
		}
}
