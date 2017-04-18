package cn.lyj.ssh.index.action;

import java.util.List;

import cn.zy.ssh.category.service.CategoryService;
import cn.zy.ssh.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ҳ���ʵ�action
 * 
 * @author ����̫��
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
	 * ִ����ҳ�ĵķ���
	 */
	public String  execute() {
		List<Category> cList=categoryService.findAll();
		ActionContext.getContext().getSession().put("cList", cList);
		return "index";
		
	}
}
