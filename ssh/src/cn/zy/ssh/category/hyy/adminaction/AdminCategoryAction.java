package cn.zy.ssh.category.hyy.adminaction;

import java.util.List;


import cn.zy.ssh.category.service.CategoryService;
import cn.zy.ssh.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category> {
	//ģ����������
	private Category category = new Category();
	
	public Category getModel() {
		
		return category;
	}
	
	//ע��CategoryService
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	
	//��ѯ����һ������ķ���

	public String findAll(){
		//��ѯ����һ������
		List<Category> cList = categoryService.findAll();
		
		//����ѯ����������ʾ��ҳ��
		ActionContext.getContext().getValueStack().set("cList", cList);
		
		
		return "findAll";
		
	}
	
//	�������ӵ�һ������ķ���
	public String save(){
		//����Service����
		categoryService.save(category);
		return "saveSuccess";
	}
	 
	//ɾ��һ������ķ���
	public String delete(){
		//����ģ���������cid�����ɾ��һ�������Լ�һ���������µĶ������࣬��Ҫ����Cid��ѯ�������ݽ���ɾ��
		category = categoryService.findByCid(category.getCid());  
		//���ݲ�ѯ����Cid����ɾ��
		categoryService.delete(category);
		return "deleteSuccess";
	}
	
	//��ת���༭ҳ���action
	public String edit(){
		category = categoryService.findByCid(category.getCid());
		
		return "edit";
	}
	
	//�޸�һ������ķ���
	public String update(){
		categoryService.update(category);
		return "updateSuccess";
	}

}
