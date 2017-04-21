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
 * ��̨��Ʒ�����action
 * @author ����̫��
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	//ģ������ʹ�õĶ���
	
	private Product product=new Product();
	
	public Product getModel(){
		return product;
	}
	
	//ע����Ʒ��service
	
	private ProductService productService;
	 
	public void setProductService(ProductService productService){
		this.productService=productService;
	}
	//ע���������Service
	private CategorySecondService categorySecondService;
	
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	//����page����
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}
	
	//�ļ��ϴ���Ҫ�Ĳ���
	private File upload;//�ϴ��ļ�
	private String uploadFileName;//�����ļ��ϴ����ļ���
	private String uploadContextType;//�����ļ��ϴ����ļ���MIME����
	
	
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	//����ҳ��ѯ��Ʒ��ִ�з���
	public String findAll(){ 
		//����service ��ɲ�ѯ����
		 PageBean<Product> pageBean=productService.findByPage(page);
		 //�����ݴ��ݵ�ҳ��
		 ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		 //ҳ����ת
		 return "findAll";
	}
	
	//��ת�����ҳ��ķ��� 
	public String addPage(){
		//��ѯ���ж�������ļ���
		List<CategorySecond> csList=categorySecondService.findAll();
		//ͨ��ֵջ�������ݱ��棻
		ActionContext.getContext().getValueStack().set("csList", csList);
		//ҳ����ת
		return "addPageSuccess";
	}
	
	//������Ʒ�ķ���
	public String save() throws IOException{
		//����Service��ɱ���Ĳ���
		 
		product.setPdate(new Date());
		if(upload!=null){
			
			//����ļ��ϴ��ľ���·��
			String realPath=ServletActionContext.getServletContext()
					.getRealPath("/products");
			//����һ���ļ�
			File diskFile=new File(realPath+"//"+uploadFileName);
			//�ļ��ϴ�
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/"+uploadFileName);
		}
		
		//�����ݱ��浽���ݿ�
		productService.save(product);
		//ҳ����ת
		return "saveSuccess";
	}
	//ɾ����Ʒ�ķ���
	public String delete(){
		//�Ȳ�ѯ��ɾ��
		product=productService.findByPid(product.getPid());
		
		//ɾ���ϴ���ͼƬ
		String path=product.getImage();
		if(path!=null){
			String realPath=ServletActionContext.getServletContext().getRealPath("/"+path);
			File file=new File(realPath);
			file.delete();
		}  
		//ɾ����Ʒ
		productService.delete(product);
		//ҳ����ת
		return "deleteSuccess";
	}
	
}
