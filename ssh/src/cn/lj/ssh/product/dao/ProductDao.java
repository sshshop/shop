package cn.lj.ssh.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lj.ssh.product.vo.Product;

public class ProductDao extends HibernateDaoSupport {

	public List<Product> findHot() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("is_hot", 1));
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		return list;
	}

	public List<Product> findNew() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		return list;
	}	

	public Product findByPid(Integer integer) {
		return this.getHibernateTemplate().get(Product.class, integer);
	}


	/**
	 * 
	 * @author 盖世太保
	 */
	//DAO层统计商品个数的方法
	public int findCount() {
		String hql="select count(*) from Product";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//带分页查询商品的方法
	public List<Product> findByPage(int begin, int limit) {
		String hql="from Product order by pdate desc";
		List<Product> list=this.getHibernateTemplate().execute(null);
		if(list!=null&&list.size()>0){
			return null;
		}
		return null;
	}

	public int findCountCsid(Integer csid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
