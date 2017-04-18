package cn.zy.ssh.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.zy.ssh.category.dao.CategoryDao;
import cn.zy.ssh.category.vo.Category;

/**
 * ҵ������
 * 
 * @author Rabit
 * 
 */
@Transactional
public class CategoryService {
	private CategoryDao categoryDao;

	// ע��categoryDao
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/**
	 * ����category�б�
	 * 
	 * @author Rabit
	 * @return:categoryһ�������б�
	 */
	public List<Category> findAll() {
		//��Ҫʵ��
		return categoryDao.findAll();

	}

}
