package cn.lj.ssh.product.action;

import cn.lj.ssh.product.service.ProductService;
import cn.lj.ssh.product.vo.Product;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	private ProductService productService;
	private Product product = new Product();// 模型驱动用于接收页面上传的数据

	public Product getModel() {
		return product;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String findByPid() {
		product=productService.findByPid(product.getPid());
		return "findByPid";
	}
}
