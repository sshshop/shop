package cn.zy.ssh.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zy.ssh.category.vo.Category;

public class CategoryDao extends HibernateDaoSupport{
	
	/**
	 * ��ѯ���ݿ�һ�������б�
	 * @author Rabit
	 * ����ע��
	 * @return
	 */
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	/**
	 * Dao���̨һ�����������ӹ��ܵı������ݷ���
	 * @author Scream
	 * 
	 * */
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
		
	}
	
	/**
	 * Dao���̨һ������������Cid���в�ѯ�ķ���
	 * @author Scream
	 * 
	 * */
	
	public Category finByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}
	
	/**
	 * 
	 * Dao���̨һ���������ɾ������
	 * @author Scream
	 * 
	 * */
	
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);	
	}
	
	/**
	 * 
	 * Dao���̨һ�����������޸ķ���
	 * @author Scream
	 * 
	 * */
	
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}
	
}
