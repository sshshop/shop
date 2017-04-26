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

	public Product findByPid(Integer Pid) {
		return productDao.findByPid(Pid);
	}

	
	/**
	 *  ����һ������������ѯ��Ʒ����Ϣ
	 * @author ����̫��
	 *@param page :��ǰҳ��
	 *@param cid:һ�����������
	 */
	public PageBean<Product> findByPageCid(Integer cid,int page){
		PageBean<Product> pageBean=new PageBean<Product>();	
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ��¼����
		int limit=16;
		pageBean.setLimit(limit);
		//�����ܼ�¼����
		int totalCount=0;
		totalCount=productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage=0;
		/*(int) Math.ceil(totalCount/limit)*/
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
			
		}
		pageBean.setTotalPage(totalPage);
		//ÿҳ��ʾ�����ݼ��ϣ�
		//���Ŀ�ʼ��
		int begin=(page-1)*limit; 
		List<Product> list=productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list); 
		return pageBean;
	}
	
	/**
	 *  ���ݶ�������������ѯ��Ʒ����Ϣ������ҳ
	 * @author Rabit
	 *@param page :��ǰҳ��
	 *@param cid:�������������
	 */
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ��¼����
		int limit=12;
		pageBean.setLimit(limit);
		//�����ܼ�¼����
		int totalCount=0;
		totalCount=productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage=0;
		/*(int) Math.ceil(totalCount/limit)*/
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
	

	/**
	 *  
	 * @author ����̫��
	 *
	 */
	
	//ҵ���ѯ��Ʒ����ҳ�ķ���
		public PageBean<Product> findByPage(Integer page) {
			PageBean<Product> pageBean=new PageBean<Product>();
			//���õ�ǰҳ����
			pageBean.setPage(page);
			//����ÿҳ��ʾ��¼��;
			int limit =15;
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
			pageBean.setList(list);
			return pageBean;
		}

		// ҵ��㱣����Ʒ����:
		public void save(Product product) {
			productDao.save(product); 
		}

		// ҵ���ɾ����Ʒ
		public void delete(Product product) {
			productDao.delete(product);
		}
		//ҵ����޸���Ʒ
		public void update(Product product) {
			productDao.update(product);
					
		}
}
