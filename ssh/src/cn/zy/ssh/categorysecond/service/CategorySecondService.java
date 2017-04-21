package cn.zy.ssh.categorysecond.service;

import java.util.List;

import cn.lj.ssh.utils.PageBean;
import cn.zy.ssh.categorysecond.dao.CategorySecondDao;
import cn.zy.ssh.categorysecond.vo.CategorySecond;

 
public class CategorySecondService {
 
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
 
	public PageBean<CategorySecond> findByPage(Integer page) {
	PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>() ;
 
	pageBean.setPage(page);
	 
	int limit = 5;
	pageBean.setLimit(limit);
	 
	int totalCount = categorySecondDao.findCount();
	pageBean.setTotalCount(totalCount);
	 
	int totalPage = 0;
	if(totalCount % limit == 0){
		totalPage = totalCount / limit;
	}else{
		totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);
	 
	int begin = (page - 1)*limit;
	  List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
	  pageBean.setList(list);
		return pageBean;
	}
	
 
	public void save(CategorySecond categorySecond) {
		 categorySecondDao.save(categorySecond);
		
	}
	
	 
		public CategorySecond findByCsid(Integer csid) {
			return categorySecondDao.findByCsid(csid);
		}


	
	 
	public void delete(CategorySecond categorySecond) {
			categorySecondDao.delete(categorySecond);
	}
	
	 
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}
	
	//业务层查询所有二级分类的方法
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
		
	}
	
}
