package cn.jidy.ssh.order.service;


import java.util.List;

import cn.jidy.ssh.order.dao.OrderDao;
import cn.jidy.ssh.order.vo.Order;
import cn.lj.ssh.utils.PageBean;

public class OrderService {

	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
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

}
