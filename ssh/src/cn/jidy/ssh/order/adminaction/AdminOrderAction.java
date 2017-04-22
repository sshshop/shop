package cn.jidy.ssh.order.adminaction;

import java.util.List;

import cn.jidy.ssh.order.service.OrderService;
import cn.jidy.ssh.order.vo.Order;
import cn.jidy.ssh.order.vo.OrderItem;
import cn.lj.ssh.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
 /*
  * 后台订单管理
  */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
	private Order order = new Order();
	//实现模型驱动
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	
	//注入service服务层
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//接收page参数
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	
	//带分页查询的执行方法
	public String findAll(){
		//分页的查询
		PageBean<Order> pageBean= orderService.findByPage(page);
		//传值到页面
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//跳转
		return "findAll";
	}
	
	public String findOrderItem(){
		List<OrderItem> list = orderService.findOderItem(order.getOid());
		//通过值栈把值保存到页面上去。
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOderItem";
	}
}
