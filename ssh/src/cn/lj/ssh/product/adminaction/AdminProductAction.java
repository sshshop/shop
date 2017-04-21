package cn.lj.ssh.product.adminaction;

import cn.lj.ssh.product.service.ProductService;
import cn.lj.ssh.product.vo.Product;
import cn.lj.ssh.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台商品管理的action
 * @author 盖世太保
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	//模型驱动使用的对象
	
	private Product product=new Product();
	
	public Product getModel(){
		return product;
	}
	
	//注入商品的service
	
	private ProductService productService;
	 
	public void setProductService(ProductService productService){
		this.productService=productService;
	}
	
	//接收page参数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}
	
	//带分页查询商品的执行方法
	public String findAll(){ 
		//调用service 完成查询操作
		 PageBean<Product> pageBean=productService.findByPage(page);
		 //将数据传递到页面
		 ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		 //页面跳转
		 return "findAll";
	}
	
}
