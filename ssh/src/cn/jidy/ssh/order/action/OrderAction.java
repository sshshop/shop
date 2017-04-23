package cn.jidy.ssh.order.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.cd.ssh.cart.vo.Cart;
import cn.cd.ssh.cart.vo.CartItem;
import cn.jidy.ssh.order.service.OrderService;
import cn.jidy.ssh.order.vo.Order;
import cn.jidy.ssh.order.vo.OrderItem;
import cn.lj.ssh.user.vo.User;
import cn.lj.ssh.utils.PageBean;
import cn.lj.ssh.utils.PaymentUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ������action��ʵ��ģ������
 * 
 * @author Rabit
 * 
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	private Order order = new Order();// ģ������
	private OrderService orderService;
	private Integer page;
	// ֧�����б��
	private String pd_FrpId;
	// ����֧��ͨ������:
	// ���ո���ɹ���Ĳ���:
	private String r3_Amt;
	private String r6_Order;

	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}


	public void setPage(Integer page) {
		this.page = page;
	}

	public Order getModel() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * ���ɶ����ķ���,��������Ϣ��������ݿ�
	 * 
	 * @author Rabit
	 * @throws ParseException 
	 * 
	 */
	public String save() throws ParseException {
		Date date=new Date();                             
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        String date2=temp.format(date);  
        Date date3=temp.parse(date2);  
		order.setOrdertime(date3);
		order.setState(1);// 1��δ���� 2���Ѿ��������û�з��� 3���Ѿ�����������û��ȷ���ջ� 4���������
		// �������ﳵ���ܼ�
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			this.addActionError("����û�й��������ȥ���");
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
			this.addActionError("����δ��½�����ȵ�½����");
			return "login";
		}
		order.setUser(existUser);
		orderService.save(order);
		cart.clearCart();
		return "saveSuccess";
	}

	/**
	 * �ҵĶ����Ĳ�ѯ
	 * 
	 * @author Rabit
	 * @return
	 */
	public String findByUid() {
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		Integer uid = existUser.getUid();
		PageBean<Order> pageBean = orderService.findByUid(uid, page);
		System.out.println("pageBean.getList().size()"+"=================================="+(pageBean.getList().size()));
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUidsuccess";
	}

	/*
	 * @author jidy��̨�޸�
	 */

	// ȷ���ջ����޸Ķ�����״̬
	public String updateState() {
		// ���ݶ���id��ֵ��ȡ����
		Order currOrder = orderService.findByOid(order.getOid());
		// �޸�״̬
		currOrder.setState(4);
		orderService.update(currOrder);
		// ҳ����ת
		return "updateStateSuccess";
	}

	/**
	 * ͨ��������Ų�ѯ����
	 * 
	 * @author Rabit
	 * @return
	 */
	public String findByOid() {
		order = orderService.findByOid(order.getOid());
		return "findByOidsuccess";
	}

	/**
	 * Ϊ��������
	 * 
	 * @author Rabit
	 * @return
	 * @throws IOException
	 */
	public String payOrder() throws IOException {
		Order ocurrOrder = orderService.findByOid(order.getOid());
		ocurrOrder.setAddr(order.getAddr());
		ocurrOrder.setName(order.getName());
		ocurrOrder.setPhone(order.getPhone());
		orderService.update(ocurrOrder);
		// Ϊ��������
		String p0_Cmd = "Buy"; // ҵ������:
		String p1_MerId = "10001126856";// �̻����:
		String p2_Order = order.getOid().toString();// �������:
		String p3_Amt = "0.01"; // ������:
		String p4_Cur = "CNY"; // ���ױ���:
		String p5_Pid = ""; // ��Ʒ����:
		String p6_Pcat = ""; // ��Ʒ����:
		String p7_Pdesc = ""; // ��Ʒ����:
		String p8_Url = "http://loaclhost:8080/ssh/order_callBack.action"; // �̻�����֧���ɹ����ݵĵ�ַ:
		String p9_SAF = ""; // �ͻ���ַ:
		String pa_MP = ""; // �̻���չ��Ϣ:
		String pd_FrpId = this.pd_FrpId;// ֧��ͨ������:
		String pr_NeedResponse = "1"; // Ӧ�����:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // ��Կ
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// ���ױ�������Ϣ
		StringBuffer sb = new StringBuffer(
				"https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		// �ض���:���ױ�����:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}

	/**
	 * ����ɹ��Ժ���ת��֧���ɹ�ҳ��
	 * 
	 * @author Rabit
	 * @return
	 */
	public String callBack() {
		// �޸Ķ�����״̬:
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		// �޸Ķ���״̬Ϊ2:�Ѿ�����:
		currOrder.setState(2);
		orderService.update(currOrder);
		this.addActionMessage("֧���ɹ�!�������Ϊ: " + r6_Order + " ������Ϊ: " + r3_Amt);
		return "msg";
	}

}
