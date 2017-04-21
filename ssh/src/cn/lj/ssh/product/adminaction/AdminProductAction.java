package cn.lj.ssh.product.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.lj.ssh.product.service.ProductService;
import cn.lj.ssh.product.vo.Product;
import cn.lj.ssh.utils.PageBean;
import cn.zy.ssh.categorysecond.service.CategorySecondService;
import cn.zy.ssh.categorysecond.vo.CategorySecond;

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
	//注入二级分类Service
	private CategorySecondService categorySecondService;
	
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	//接收page参数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}
	
	//文件上传需要的参数
	private File upload;//上传文件
	private String uploadFileName;//接收文件上传的文件名
	private String uploadContextType;//接收文件上传的文件的MIME类型
	
	
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
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
	
	//跳转到添加页面的方法 
	public String addPage(){
		//查询所有二级分类的集合
		List<CategorySecond> csList=categorySecondService.findAll();
		//通过值栈进行数据保存；
		ActionContext.getContext().getValueStack().set("csList", csList);
		//页面跳转
		return "addPageSuccess";
	}
	
	//保存商品的方法
	public String save() throws IOException{
		//调用Service完成保存的操作
		 
		product.setPdate(new Date());
		if(upload!=null){
			
			//获得文件上传的绝对路径
			String realPath=ServletActionContext.getServletContext()
					.getRealPath("/products");
			//创建一个文件
			File diskFile=new File(realPath+"//"+uploadFileName);
			//文件上传
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
		}
		
		//将数据保存到数据库
		productService.save(product);
		//页面跳转
		return "saveSuccess";
	}
	//删除商品的方法
	public String delete(){
		//先查询再删除
		product=productService.findByPid(product.getPid());
		
		//删除上传的图片
		String path=product.getImage();
		if(path!=null){
			String realPath=ServletActionContext.getServletContext().getRealPath("/"+path);
			File file=new File(realPath);
			file.delete();
		}  
		//删除商品
		productService.delete(product);
		//页面跳转
		return "deleteSuccess";
	}
	
}
