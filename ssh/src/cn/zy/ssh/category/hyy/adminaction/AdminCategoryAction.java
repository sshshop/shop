package cn.zy.ssh.category.hyy.adminaction;

import java.util.List;


import cn.zy.ssh.category.service.CategoryService;
import cn.zy.ssh.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
	//模型驱动的类
	private Category category = new Category();
	
	public Category getModel() {
		
		return category;
	}
	
	//注入CategoryService
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	
	//查询所有一级分类的方法

	public String findAll(){
		//查询所有一级分类
		List<Category> cList = categoryService.findAll();
		
		//将查询到的数据显示到页面
		ActionContext.getContext().getValueStack().set("cList", cList);
		
		
		return "findAll";
		
	}
	
//	保存增加的一级分类的方法
	public String save(){
		//调用Service保存
		categoryService.save(category);
		return "saveSuccess";
	}
	 
	//删除一级分类的方法
	public String delete(){
		//根据模型驱动获得cid，如果删除一级分类以及一级分类以下的二级分类，就要根据Cid查询到的数据进行删除
		category = categoryService.findByCid(category.getCid());  
		//根据查询到的Cid进行删除
		categoryService.delete(category);
		return "deleteSuccess";
	}
	
	//跳转到编辑页面的action
	public String edit(){
		category = categoryService.findByCid(category.getCid());
		
		return "edit";
	}
	
	//修改一级分类的方法
	public String update(){
		categoryService.update(category);
		return "updateSuccess";
	}

}
