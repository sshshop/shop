package cn.jidy.ssh.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jidy.ssh.order.vo.Order;
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

}
