package cn.lj.ssh.product.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lj.ssh.product.vo.Product;
import cn.lj.ssh.utils.PageHibernateCallback;

/**
 * ��Ʒ����dao
 * 
 * @author Rabit
 * 
 */
public class ProductDao extends HibernateDaoSupport {
	/**
	 * ��ѯ������Ʒ������ʱ����������µ�����ǰ��
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
	 * ��ѯ������Ʒ������ʱ�����������ϴ�������ǰ��
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
	 * ������Ʒid��ѯ��Ʒ
	 * @author Rabit
	 * @param integer:��Ʒid
	 * @return:��Ʒʵ��ӳ��
	 */
	public Product findByPid(Integer integer) {
		return this.getHibernateTemplate().get(Product.class, integer);
	}

	/**
	 * 
	 * 
	 * @author ����̫��
	 */
	//DAO��ͳ�����ݿ���Ʒ�����ķ���
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
	 * @author ����̫��
	 */
	//����ҳ��ѯ��Ʒ�ķ���
	public List<Product> findByPage(int begin, int limit) {
		String hql = "from Product order by pdate desc";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, begin,limit));
		
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * ͨ��һ����Ʒ���෵����Ʒ������
	 * @param cid��һ�����������
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
	 * ������Ʒ��������������ѯ��Ʒ����
	 * 
	 * @param cid
	 *            :��Ʒ��������
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
	 * ������Ʒ��һ�����࣬��ѯ��Ʒ�ļ��ϣ�����ҳ��
	 * @author Rabit
	 * @param csid
	 *            ����Ʒ��һ����������
	 * @param begin
	 *            ����Ʒ��ʼ��ҳ��
	 * @param limit
	 *            ����Ʒÿҳ��ʾ������
	 * @return����Ʒ�ļ���
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
	 * ������Ʒ�Ķ������࣬��ѯ��Ʒ�ļ��ϣ�����ҳ��
	 * @author Rabit
	 * @param csid
	 *            ����Ʒ�Ķ�����������
	 * @param begin
	 *            ����Ʒ��ʼ��ҳ��
	 * @param limit
	 *            ����Ʒÿҳ��ʾ������
	 * @return����Ʒ�ļ���
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
