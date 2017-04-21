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
	
	/**
	 * Service���̨һ�����������ӹ��ܵı������ݷ���
	 * @author Scream
	 * 
	 * */

	public void save(Category category) {
		categoryDao.save(category);
		
	}
	
	/**
	 * Service���̨һ������������Cid���в�ѯ�ķ���
	 * @author Scream
	 * 
	 * */

	public Category findByCid(Integer cid) {
		// TODO Auto-generated method stub
		return categoryDao.finByCid(cid);
	}
	
	/**
	 * 
	 * Service���̨һ���������ɾ������
	 * @author Scream
	 * 
	 * */

	public void delete(Category category) {
		categoryDao.delete(category);
	}

	/**
	 * 
	 * Service���̨һ�����������޸ķ���
	 * @author Scream
	 * 
	 * */
	
	public void update(Category category) {
		categoryDao.update(category);
	}

}
