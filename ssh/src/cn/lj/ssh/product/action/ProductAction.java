package cn.lj.ssh.product.action;

import cn.lj.ssh.product.service.ProductService;
import cn.lj.ssh.product.vo.Product;
import cn.lj.ssh.utils.PageBean;
import cn.zy.ssh.category.service.CategoryService;
import cn.zy.ssh.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 商品action
 * @author Rabit
 *
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	private Product product = new Product();// 模型驱动用于接收页面上传的数据
	private ProductService productService;
	private Integer cid;
	private Integer csid;
	private int page; //当前页数
	
	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	//一级分类的service
	private CategoryService categoryService;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Integer getCid() {
		return cid;
	}

	public Product getModel() {
		return product;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	/**
	 * 根据商品的id查询单个商品，用于详情页
	 * @author Rabit
	 * @return
	 */
	public String findByPid() {
		product=productService.findByPid(product.getPid());
		return "findByPid";
	}
	/**
	 * 根据分类一级id查询商品,带分页查询
	 * @author Rabit
	 * @return
	 */
	public String findByCid() {	
	    PageBean<Product> pageBean= productService.findByPageCid(cid, page);
		//pagebean存入值栈
	    ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	    return "findbycid";
	}
	
	/**
	 * 根据分类二级id查询商品,带分页查询
	 * @author Rabit
	 * @return
	 */
	public String findByCsid() {
		System.out.println("csid="+csid+"+++++++++++++++++++++++page="+page);
	    PageBean<Product> pageBean= productService.findByPageCsid(csid, page);
		//pagebean存入值栈
	    ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	    return "findbycsid";
	}


}
