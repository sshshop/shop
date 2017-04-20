package cn.lj.ssh.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;





import cn.lj.ssh.product.dao.ProductDao;
import cn.lj.ssh.product.vo.Product;
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
	
	
	
}
