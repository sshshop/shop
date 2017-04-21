package cn.zy.ssh.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lj.ssh.utils.PageHibernateCallback;
import cn.zy.ssh.categorysecond.vo.CategorySecond;

 
public class CategorySecondDao extends HibernateDaoSupport{
  
	public int findCount() {
  String hql = "select count(*) from CategorySecond";
  List<Long> list = this.getHibernateTemplate().find(hql);
  if(list != null && list.size() > 0){
	  return list .get(0).intValue();
  }
		return 0;
	}
	 
	public List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<CategorySecond>(hql, null, begin,
						limit));
		  if(list != null && list.size() > 0){
			  return list;
		  }
			
		return null;
	}
	
	 
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
		
	}
	
	 
	public CategorySecond findByCsid(Integer csid) {
		 
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}
	
	 
		 public void delete(CategorySecond categorySecond) {
				this.getHibernateTemplate().delete(categorySecond);
			}
		 
		 
		public void update(CategorySecond categorySecond) {
			 this.getHibernateTemplate().update(categorySecond);
			
		}
		//DAO层查询所有的方法
		public List<CategorySecond> findAll() {
			String hql="from CategorySecond";
			return this.getHibernateTemplate().find(hql);
		}

		
	}


