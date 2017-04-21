package cn.jidy.ssh.order.service;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.jidy.ssh.order.dao.OrderDao;
import cn.jidy.ssh.order.vo.Order;
import cn.lj.ssh.utils.PageBean;
@Transactional
public class OrderService {

	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public OrderDao getOrderDao() {
		return orderDao;
	}
	/*
	 * **************��̨��ҳ��ѯ����***************************************
	 * @author jidy
	 * 
	 */
	public PageBean<Order> findByPage(Integer page) {
		PageBean<Order> pageBean=new PageBean<Order>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//���õ�ǰҳ����ʾ������
		int limit = 10;
		pageBean.setLimit(limit);
		//��ȡ�ܵļ�¼��
		int totalCount =orderDao.findByCount();
		pageBean.setTotalCount(totalCount);
		//�����ܵ�ҳ��
		int totalPage=0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//����ÿҳ��ʾ�����ݽ��
		int begin=(page-1)*limit;
		List<Order> list = orderDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * ���涩����Ϣ
	 * @param order��������ʵ��ӳ����
	 */
	public void save(Order order) {
		orderDao.save(order);
	}
	
	/**
	 * �ҵĶ�����ҵ�����룬
	 * @param uid���û�id
	 * @param page:ҳ����
	 * @return
	 */
	public PageBean<Order> findByUid(Integer uid, Integer page) {
		PageBean<Order> pageBean=new PageBean<Order>();
		pageBean.setPage(page);
		Integer limit=5;
		pageBean.setLimit(limit);
		Integer totalCount=orderDao.findbByCountUid(uid);
		pageBean.setTotalCount(totalCount);
		Integer totalPage=null;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		Integer begin=(page-1)*limit;
		List<Order> list = orderDao.findByPageUid(uid,begin, limit);
		pageBean.setList(list);
		return pageBean;
		
	}
	

}
