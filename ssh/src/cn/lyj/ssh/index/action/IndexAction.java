package cn.lyj.ssh.index.action;

import cn.zy.ssh.category.service.CategoryService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页访问的action
 * 
 * @author 盖世太保
 *
 */

public class IndexAction extends ActionSupport {
	private CategoryService categoryService;
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
		categoryService.findAll();
		return "index";
		
	}
}
