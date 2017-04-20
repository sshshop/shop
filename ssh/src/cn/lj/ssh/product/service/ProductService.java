package cn.lj.ssh.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;







import cn.lj.ssh.product.dao.ProductDao;
import cn.lj.ssh.product.vo.Product;
import cn.lj.ssh.utils.PageBean;
@Transactional
public class ProductService {
	private ProductDao productDao;

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	/**
	 * ��ѯ������Ʒ
	 * @author Rabit
	 * @return������list����
	 */
	public List<Product> findHot() {
		
		return productDao.findHot();
	}
	/**
	 * ��ѯ������Ʒ
	 * @author Rabit
	 * @return������list����
	 */
	public List<Product> findNew() {
		return productDao.findNew();
	}

	public Product findByPid(Integer integer) {
		return productDao.findByPid(integer);
	}

	
	/**
	 *  
	 * @author ����̫��
	 *
	 */
	//���ݶ��������ѯ��Ʒ����Ϣ
	public PageBean<Product> findByPageCsid(Integer csid,int page){
		PageBean<Product> pageBean=new PageBean<Product>();
		
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ��¼����
		int limit=8;
		pageBean.setLimit(limit);
		//�����ܼ�¼����
		int totalCount=0;
		totalCount=productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage=0;
		//Math.ceil(totalCount/limit);
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
			
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ��ϣ�
		//���Ŀ�ʼ��
		int begin=(page-1)*limit; 
		List<Product> list=productDao.findByPageCsid(csid,begin,limit);
		pageBean.setList(list); 
		return pageBean;
	}
	
	
	//ҵ���ѯ��Ʒ����ҳ�ķ���
	public PageBean<Product> findByPage(Integer page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//���õ�ǰҳ����
		pageBean.setPage(page);
		//����ÿҳ��ʾ��¼��;
		int limit =10;
		pageBean.setLimit(limit);
		//�����ܼ�¼����
		int totalCount=productDao.findCount();
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage=0;
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
			
		}else{
			totalPage=totalCount/limit+1;
		}
		pageBean.setTotalPage(totalPage);
		//������ʾ��ҳ������ݼ��ϣ�
		int begin=(page-1)*limit;
		List<Product> list=productDao.findByPage(begin,limit);
		return pageBean;
	}
	
	
}
