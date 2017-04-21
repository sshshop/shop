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
	 * **************后台分页查询处理***************************************
	 * @author jidy
	 * 
	 */
	public PageBean<Order> findByPage(Integer page) {
		PageBean<Order> pageBean=new PageBean<Order>();
		//设置当前页数
		pageBean.setPage(page);
		//设置当前页面显示的条数
		int limit = 10;
		pageBean.setLimit(limit);
		//获取总的记录数
		int totalCount =orderDao.findByCount();
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage=0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//设置每页显示的数据结合
		int begin=(page-1)*limit;
		List<Order> list = orderDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	/**
	 * 保存订单信息
	 * @param order：订单的实体映射类
	 */
	public void save(Order order) {
		orderDao.save(order);
	}
	
	/**
	 * 我的订单的业务层代码，
	 * @param uid：用户id
	 * @param page:页面数
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
