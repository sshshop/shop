package cn.lyj.ssh.index.action;

import cn.zy.ssh.category.service.CategoryService;

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
		categoryService.findAll();
		return "index";
		
	}
}
