package cn.zy.ssh.category.service;

import org.springframework.transaction.annotation.Transactional;

import cn.zy.ssh.category.dao.CategoryDao;
/**
 * ҵ������
 * @author Rabit
 *
 */
@Transactional
public class CategoryService {
	private CategoryDao categoryDao;
//ע��categoryDao
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

}
