package cn.zy.ssh.categorysecond.service;

import java.util.List;

import cn.lj.ssh.utils.PageBean;
import cn.zy.ssh.categorysecond.dao.CategorySecondDao;
import cn.zy.ssh.categorysecond.vo.CategorySecond;

/*
 * 二级分类管理的业务层
 */
public class CategorySecondService {
//注入Dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
 //业务层查询二级分类的方法
	public PageBean<CategorySecond> findByPage(Integer page) {
	PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>() ;
	//设置当前页数
	pageBean.setPage(page);
	//设置每页显示的记录数
	int limit = 5;
	pageBean.setLimit(limit);
	//设置总的记录数
	int totalCount = categorySecondDao.findCount();
	pageBean.setTotalCount(totalCount);
	//设置总页数
	int totalPage = 0;
	if(totalCount % limit == 0){
		totalPage = totalCount / limit;
	}else{
		totalPage = totalCount / limit + 1;
	}
	pageBean.setTotalPage(totalPage);
	//设置每页显示数据的集合
	int begin = (page - 1)*limit;
	  List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
	  pageBean.setList(list);
		return pageBean;
	}
	
	//业务层保存二级分类的方法
	public void save(CategorySecond categorySecond) {
		 categorySecondDao.save(categorySecond);
		
	}
	
}
