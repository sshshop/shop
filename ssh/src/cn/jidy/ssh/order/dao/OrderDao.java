package cn.jidy.ssh.order.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jidy.ssh.order.vo.Order;
import cn.lj.ssh.utils.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport{

	
	
	
	
	
	/*
	 * @author jidy
	 * **********************��̨�����õķ���***********************
	 */
	//��ѯ�ܵļ�¼��
	public int findByCount() {
		String hql="select count(*) from Order";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
	        return list.get(0).intValue();		
		}
		return 0;
	}

	//��ѯ��ǰ��ʾҳ�����Ϣ(��ҳ��ѯ)
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
