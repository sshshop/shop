package cn.jidy.ssh.order.action;

import cn.jidy.ssh.order.vo.Order;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * ������action��ʵ��ģ������
 * @author Rabit
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	private Order order = new Order();//ģ������
	public Order getModel() {
		return order;
	}
	/**
	 * ���ɶ����ķ���
	 * @author Rabit
	 * 
	 */
	public String save() {
		return "saveSuccess";
	}
}
