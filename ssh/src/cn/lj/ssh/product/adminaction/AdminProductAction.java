package cn.lj.ssh.product.adminaction;

import cn.lj.ssh.product.service.ProductService;
import cn.lj.ssh.product.vo.Product;
import cn.lj.ssh.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨��Ʒ�����action
 * @author ����̫��
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	//ģ������ʹ�õĶ���
	
	private Product product=new Product();
	
	public Product getModel(){
		return product;
	}
	
	//ע����Ʒ��service
	
	private ProductService productService;
	 
	public void setProductService(ProductService productService){
		this.productService=productService;
	}
	
	//����page����
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}
	
	//����ҳ��ѯ��Ʒ��ִ�з���
	public String findAll(){ 
		//����service ��ɲ�ѯ����
		 PageBean<Product> pageBean=productService.findByPage(page);
		 //�����ݴ��ݵ�ҳ��
		 ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		 //ҳ����ת
		 return "findAll";
	}
	
}
