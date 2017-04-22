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
	/**
	 * ���涩����Ϣ���������Ҳ��������
	 * @author Rabit
	 * @param order��������ʵ��ӳ����
	 */
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}
	/**
	 * �����û���ѯ����������
	 * @author Rabit
	 * @param uid���û�id
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
	 * �����û�id,��ʼҳ��ÿҳ��ʾ����������ҳ��ѯ��������
	 * @author Rabit
	 * @param uid:�û�id
	 * @param begin:��ʼҳ
	 * @param limit��ÿҳ��ʾ������
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
	//����oid��ѯ������
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
