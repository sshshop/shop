package cn.lj.ssh.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lj.ssh.product.vo.Product;
import cn.lj.ssh.utils.PageHibernateCallback;

/**
 * 商品详情dao
 * 
 * @author Rabit
 * 
 */
public class ProductDao extends HibernateDaoSupport {
	/**
	 * 查询热门商品，根据时间的排序，最新的排在前面
	 * 
	 * @author Rabit
	 * @return
	 */
	public List<Product> findHot() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("is_hot", 1));
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		return list;
	}

	/**
	 * 查询最新商品，根据时间排序，最新上传的排在前面
	 * 
	 * @author Rabit
	 * @return
	 */
	public List<Product> findNew() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.addOrder(Order.desc("pdate"));
		List<Product> list = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		return list;
	}
	/**
	 * 根据商品id查询商品
	 * @author Rabit
	 * @param integer:商品id
	 * @return:商品实体映射
	 */
	public Product findByPid(Integer integer) {
		return this.getHibernateTemplate().get(Product.class, integer);
	}

	/**
	 * 
	 * 
	 * @author 盖世太保
	 */
	//DAO层统计数据库商品个数的方法
	public int findCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	/**
	 * 
	 * @author 盖世太保
	 */
	//带分页查询商品的方法
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, begin,limit));
		
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * 通过一级商品分类返回商品的总数
	 * @param cid：一级分类的主键
	 * @return
	 */
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql,cid);
		if(list != null && list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;	
	}
	
	/**
	 * 根据商品二级分类主键查询商品总数
	 * 
	 * @param cid
	 *            :商品二级分类
	 * @return
	 */
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		System.out.println("22222222222222222222222222222222222222222222222222222222222222222222222222");
		if (list != null && list.size() > 0) {
			System.out.println("-------------------"+list.get(0).intValue()+"------------------------");
			return list.get(0).intValue();
		}
		System.out.println("000000000000000000000000000000000000000000000000000000000000000");
		return 0;
	}

	/**
	 * 根据商品的一级分类，查询商品的集合（带分页）
	 * @author Rabit
	 * @param csid
	 *            ：商品的一级分类主键
	 * @param begin
	 *            ：商品开始的页面
	 * @param limit
	 *            ：商品每页显示的数量
	 * @return：商品的集合
	 */
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, new Object[] { cid },
						begin, limit));
		if (list!=null&& list.size()>0) {
			return list;			
		}
		return null;
	}
	/**
	 * 根据商品的二级分类，查询商品的集合（带分页）
	 * @author Rabit
	 * @param csid
	 *            ：商品的二级分类主键
	 * @param begin
	 *            ：商品开始的页面
	 * @param limit
	 *            ：商品每页显示的数量
	 * @return：商品的集合
	 */
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, new Object[] { csid },
						begin, limit));
		if (list!=null&& list.size()>0) {
			return list;			
		}
		return null;
	}
	
	
}
