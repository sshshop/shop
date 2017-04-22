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
  * ��̨��������
  */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
	private Order order = new Order();
	//ʵ��ģ������
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	
	//ע��service�����
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//����page����
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	
	//����ҳ��ѯ��ִ�з���
	public String findAll(){
		//��ҳ�Ĳ�ѯ
		PageBean<Order> pageBean= orderService.findByPage(page);
		//��ֵ��ҳ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//��ת
		return "findAll";
	}
	
	public String findOrderItem(){
		List<OrderItem> list = orderService.findOderItem(order.getOid());
		//ͨ��ֵջ��ֵ���浽ҳ����ȥ��
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOderItem";
	}
}
