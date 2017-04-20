package cn.lj.ssh.product.action;

import cn.lj.ssh.product.service.ProductService;
import cn.lj.ssh.product.vo.Product;
import cn.zy.ssh.category.service.CategoryService;
import cn.zy.ssh.category.vo.Category;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	private ProductService productService;
	private Integer cid;
	//一级分类的servlet
	private CategoryService categoryService;
	
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

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
	
	public String findByCid() {		
		return "findbycid";
	}
}
