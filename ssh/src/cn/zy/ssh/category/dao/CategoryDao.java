package cn.zy.ssh.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zy.ssh.category.vo.Category;

public class CategoryDao extends HibernateDaoSupport{
	
	/**
	 * 查询数据库一级分类列表
	 * @author Rabit
	 * 增加注释
	 * @return
	 */
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	/**
	 * Dao层后台一级分类管理添加功能的保存数据方法
	 * @author Scream
	 * 
	 * */
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
		
	}
	
	/**
	 * Dao层后台一级分类管理根据Cid进行查询的方法
	 * @author Scream
	 * 
	 * */
	
	public Category finByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}
	
	/**
	 * 
	 * Dao层后台一级分类管理删除方法
	 * @author Scream
	 * 
	 * */
	
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);	
	}
	
	/**
	 * 
	 * Dao层后台一级分类管理的修改方法
	 * @author Scream
	 * 
	 * */
	
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}
	
}
