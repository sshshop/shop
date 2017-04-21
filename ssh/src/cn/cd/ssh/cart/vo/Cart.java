package cn.cd.ssh.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * ���ﳵ����
 * @author CD
 *
 */
public class Cart implements Serializable{
	//���ﳵ����
	//���Ｏ��:������ϣ�Map��key������Ʒpid��value:������
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
    
	//Cart��������һ����cartItems����
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	//�����ܼ�:
	private double total;
	
	
	public double getTotal() {
		return total;
	}
	//���ﳵ���ܣ�
	//1.����������ӵ����ﳵ
	public void addCart(CartItem cartItem){
		//�жϹ��ﳵ���Ƿ��Ѿ����ڸù����
		/**
		 *  * ������ڣ�
		 *       * ��������
		 *       * �ܼ� = �ܼ� + ������С��
		 *  * ��������ڣ�
		 *       * ��map����ӹ�����
		 *       * �ܼ� = �ܼ� + ������С��   
		 */
		//�����Ʒid.
		Integer pid = cartItem.getProduct().getPid();
		//�жϹ��ﳵ���Ƿ��Ѿ����ڸù����
		if(map.containsKey(pid)){
			//����
			CartItem _cartItem = map.get(pid);//��ù��ﳵ��ԭ���Ĺ�����
			_cartItem.setCount(cartItem.getCount()+cartItem.getCount());
			
		}else{
			//������
			map.put(pid, cartItem);
		}
		//�����ܼƵ�ֵ
		total +=cartItem.getSubtotal();
		
	}
	//2.�ӹ��ﳵ�Ƴ�������
	public void removeCart(Integer pid){
		//���������Ƴ����ﹺ�ﳵ��
		CartItem cartItem = map.remove(pid);
		//�ܼ� = �ܼ�-�Ƴ��Ĺ�����С�ƣ�
		total-= cartItem.getSubtotal();
	}
	//3.��չ��ﳵ
	public void clearCart(){
		//�����й��������
		map.clear();
		//���ܼ�����Ϊ0
		total=0;
		
	}
	
}
