package cn.zy.ssh.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.zy.ssh.category.dao.CategoryDao;
import cn.zy.ssh.category.vo.Category;

/**
 * 业务层对象
 * 
 * @author Rabit
 * 
 */
@Transactional
public class CategoryService {
	private CategoryDao categoryDao;

	// 注入categoryDao
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * 返回category列表
	 * 
	 * @author Rabit
	 * @return:category一级分类列表
	 */
	public List<Category> findAll() {
		//需要实现
		return categoryDao.findAll();

	}
	
	/**
	 * Service层后台一级分类管理添加功能的保存数据方法
	 * @author Scream
	 * 
	 * */

	public void save(Category category) {
		categoryDao.save(category);
		
	}
	
	/**
	 * Service层后台一级分类管理根据Cid进行查询的方法
	 * @author Scream
	 * 
	 * */

	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.finByCid(cid);
	}
	
	/**
	 * 
	 * Service层后台一级分类管理删除方法
	 * @author Scream
	 * 
	 * */

	public void delete(Category category) {
		categoryDao.delete(category);
	}

	/**
	 * 
	 * Service层后台一级分类管理的修改方法
	 * @author Scream
	 * 
	 * */
	
	public void update(Category category) {
		categoryDao.update(category);
	}

}
