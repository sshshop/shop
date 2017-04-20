package cn.lyj.ssh.index.action;

import java.util.List;

import cn.lj.ssh.product.service.ProductService;
import cn.lj.ssh.product.vo.Product;
import cn.zy.ssh.category.service.CategoryService;
import cn.zy.ssh.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页访问的action
 * 
 * @author 盖世太保
 *
 */

public class IndexAction extends ActionSupport {
	private ProductService productService;//注入商品的业务层
	private CategoryService categoryService;
	
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public CategoryService getCategoryService() {
		return categoryService;
	}
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	/**
	 * 执行首页的的方法
	 */
	public String  execute() {
		List<Category> cList=categoryService.findAll();
		ActionContext.getContext().getSession().put("cList", cList);
		List<Product> hList=productService.findHot();
		List<Product> nList=productService.findNew();
		ActionContext.getContext().getValueStack().set("hList",hList);
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
}
