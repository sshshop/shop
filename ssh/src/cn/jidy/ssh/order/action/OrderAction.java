package cn.jidy.ssh.order.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.cd.ssh.cart.vo.Cart;
import cn.cd.ssh.cart.vo.CartItem;
import cn.jidy.ssh.order.service.OrderService;
import cn.jidy.ssh.order.vo.Order;
import cn.jidy.ssh.order.vo.OrderItem;
import cn.lj.ssh.user.vo.User;
import cn.lj.ssh.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 订单的action，实现模型驱动
 * 
 * @author Rabit
 * 
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	private Order order = new Order();// 模型驱动
	private OrderService orderService;
	private Integer page;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Order getModel() {
		return order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * 生成订单的方法,将订单信息保存的数据库
	 * 
	 * @author Rabit
	 * 
	 */
	public String save() {
		order.setOrdertime(new Date());
		order.setState(1);// 1：未付款 2：已经付款，但是没有发货 3：已经发货，但是没有确认收货 4：交易完成
		// 来至购物车的总价
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			this.addActionError("您还没有购物！！请先去购物！");
			return "msg";
		}
		order.setTotal(cart.getTotal());
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (existUser == null) {
			this.addActionError("您还未登陆，请先登陆！！");
			return "login";
		}
		order.setUser(existUser);
		orderService.save(order);
		return "saveSuccess";
	}

	/**
	 * 我的订单的查询
	 * 
	 * @author Rabit
	 * @return
	 */
	public String findByUid() {
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		Integer uid = existUser.getUid();
		PageBean<Order> pageBean = orderService.findByUid(uid, page);
		System.out.println((pageBean == null)+"----------------------");
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUidsuccess";
	}
}
