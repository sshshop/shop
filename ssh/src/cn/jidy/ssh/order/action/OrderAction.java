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
 * 订单的action，实现模型驱动
 * 
 * @author Rabit
 * 
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	private Order order = new Order();// 模型驱动
	private OrderService orderService;
	private Integer page;
	// 支付银行编号
	private String pd_FrpId;
	// 接收支付通道编码:
	// 接收付款成功后的参数:
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
	 * 生成订单的方法,将订单信息保存的数据库
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
		cart.clearCart();
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
		System.out.println("pageBean.getList().size()"+"=================================="+(pageBean.getList().size()));
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByUidsuccess";
	}

	/*
	 * @author jidy后台修改
	 */

	// 确认收货，修改订单的状态
	public String updateState() {
		// 根据订单id的值获取订单
		Order currOrder = orderService.findByOid(order.getOid());
		// 修改状态
		currOrder.setState(4);
		orderService.update(currOrder);
		// 页面跳转
		return "updateStateSuccess";
	}

	/**
	 * 通过订单查号查询订单
	 * 
	 * @author Rabit
	 * @return
	 */
	public String findByOid() {
		order = orderService.findByOid(order.getOid());
		return "findByOidsuccess";
	}

	/**
	 * 为订单付款
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
		// 为订单付款
		String p0_Cmd = "Buy"; // 业务类型:
		String p1_MerId = "10001126856";// 商户编号:
		String p2_Order = order.getOid().toString();// 订单编号:
		String p3_Amt = "0.01"; // 付款金额:
		String p4_Cur = "CNY"; // 交易币种:
		String p5_Pid = ""; // 商品名称:
		String p6_Pcat = ""; // 商品种类:
		String p7_Pdesc = ""; // 商品描述:
		String p8_Url = "http://loaclhost:8080/ssh/order_callBack.action"; // 商户接收支付成功数据的地址:
		String p9_SAF = ""; // 送货地址:
		String pa_MP = ""; // 商户扩展信息:
		String pd_FrpId = this.pd_FrpId;// 支付通道编码:
		String pr_NeedResponse = "1"; // 应答机制:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); // hmac
		// 向易宝发送信息
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
		// 重定向:向易宝出发:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}

	/**
	 * 付款成功以后跳转到支付成功页面
	 * 
	 * @author Rabit
	 * @return
	 */
	public String callBack() {
		// 修改订单的状态:
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		// 修改订单状态为2:已经付款:
		currOrder.setState(2);
		orderService.update(currOrder);
		this.addActionMessage("支付成功!订单编号为: " + r6_Order + " 付款金额为: " + r3_Amt);
		return "msg";
	}

}
