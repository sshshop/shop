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
	
}
