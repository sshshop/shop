package cn.zy.ssh.category.service;

import org.springframework.transaction.annotation.Transactional;

import cn.zy.ssh.category.dao.CategoryDao;
/**
 * 业务层对象
 * @author Rabit
 *
 */
@Transactional
public class CategoryService {
	private CategoryDao categoryDao;
//注入categoryDao
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

}
