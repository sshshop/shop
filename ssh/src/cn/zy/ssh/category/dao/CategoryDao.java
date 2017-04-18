package cn.zy.ssh.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zy.ssh.category.vo.Category;

public class CategoryDao extends HibernateDaoSupport{
	
	
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		return list;
	}
	
}
