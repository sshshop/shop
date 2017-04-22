package cn.jidy.ssh.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jidy.ssh.order.vo.Order;
import cn.jidy.ssh.order.vo.OrderItem;
import cn.lj.ssh.utils.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport{
	
	/*
	 * @author jidy
	 * **********************后台计算用的方法***********************
	 */
	//查询总的记录数
	public int findByCount() {
		String hql="select count(*) from Order";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
	        return list.get(0).intValue();		
		}
		return 0;
	}

	//查询当前显示页面的信息(分页查询)
	public List<Order> findByPage(int begin, int limit) {
		String hql="from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, null, begin, limit)); 
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
		
	}
	/**
	 * 保存订单信息，订单项表也级联保存
	 * @author Rabit
	 * @param order：订单的实体映射类
	 */
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}
	/**
	 * 根据用户查询订单的总数
	 * @author Rabit
	 * @param uid：用户id
	 * @return
	 */
	public Integer findbByCountUid(Integer uid) {
		String hql="select count(*) from Order o where o.user.uid=?";
		List<Long> list=this.getHibernateTemplate().find(hql,uid);
		if (list!=null&&list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * 根据用户id,起始页，每页显示的数量，分页查询订单详情
	 * @author Rabit
	 * @param uid:用户id
	 * @param begin:起始页
	 * @param limit：每页显示的数量
	 * @return
	 */
	public List<Order> findByPageUid(Integer uid, Integer begin, Integer limit) {
		String hql = "from Order o where o.user.uid = ? order by o.ordertime desc";
		List<Order> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, limit));
		System.out.println(list.size()+"-----------------------------------------------");
		if (list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}
	//根据oid查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql="from OrderItem oi where oi.order.oid=?";
		List<OrderItem> list=this.getHibernateTemplate().find(hql,oid);
		if (list!=null&&list.size()>0) {
			return list;
		}
		return null;
	}

	
	public void update(Order currOrder) {
		// TODO Auto-generated method stub
		
	}

	public Order findByOid(Integer oid) {
		// TODO Auto-generated method stub
		return null;
	}

}
