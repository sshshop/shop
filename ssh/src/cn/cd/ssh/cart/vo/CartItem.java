package cn.cd.ssh.cart.vo;

import cn.lj.ssh.product.vo.Product;

/**
 * 购物项对象
 * @author CD
 *
 */
public class CartItem {
	private Product product;  //购物项中商品信息
	private int count;        //购买某种商品数量
	private double subtotal;  //购买某种商品小计
	public Product getProduct(){
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//小计自动计算
	public double getSubtotal() {
		return count * product.getShop_price();
	}
	
}
