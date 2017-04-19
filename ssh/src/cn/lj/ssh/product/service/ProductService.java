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

	public void setProductDao(ProductDao producetDao) {
		this.productDao = producetDao;
	}
	/**
	 * 查询热门商品
	 * @author Rabit
	 * @return：返回list集合
	 */
	public List<Product> findHot() {
	
		return null;
	}
	/**
	 * 查询最新商品
	 * @author Rabit
	 * @return：返回list集合
	 */
	public List<Product> findNew() {
		return null;
	}
	
}
