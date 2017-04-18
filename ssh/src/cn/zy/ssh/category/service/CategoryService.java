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

}
