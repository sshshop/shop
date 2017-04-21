package cn.zhj.ssh.categorysecond.adminaction;

import cn.lj.ssh.utils.PageBean;
import cn.zy.ssh.category.service.CategoryService;
import cn.zy.ssh.category.vo.Category;
import cn.zy.ssh.categorysecond.service.CategorySecondService;
import cn.zy.ssh.categorysecond.vo.CategorySecond;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.List;

/*
 * 后台二级分类管理的action
 */
public class AdminCategroySecondAction extends ActionSupport implements ModelDriven<CategorySecond> {
 //模型驱动使用的对象
	private CategorySecond categorySecond = new CategorySecond();
	public CategorySecond getModel() {
		return categorySecond;
	}
 
	//注入二级分类的Service
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
  
	//接收page 
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}
	
	//注入一级分类的service(目的查询一级分类的全部)
	private CategoryService  categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	
	
	// 带有分页的查询所有二级分类的操作:
	public String findAll() {
			// 调用Service进行查询.
	PageBean<CategorySecond> pageBean = categorySecondService.findByPage(page);
	//将pageBean的数据保存到值栈中
	ActionContext.getContext().getValueStack().set("pageBean", pageBean);
	return "findAll"; 
	}

	//跳转到添加页面
	public String addPage(){
		//查询所有的一级分类
		List<Category> cList = categoryService.findAll();
		//把数据显示到下拉列表中
		ActionContext.getContext().getValueStack().set("cList", cList);
		//页面跳转
		return "addPageSuccess";
	}
   //保存二级分类的方法
	public String save(){
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}
	 

}
