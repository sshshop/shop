package cn.jidy.ssh.order.action;

import cn.jidy.ssh.order.vo.Order;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 订单的action，实现模型驱动
 * @author Rabit
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	private Order order = new Order();//模型驱动
	public Order getModel() {
		return order;
	}
	/**
	 * 生成订单的方法
	 * @author Rabit
	 * 
	 */
	public String save() {
		return "saveSuccess";
	}
}
