package cn.lj.ssh.product.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lj.ssh.product.dao.ProducetDao;
import cn.lj.ssh.product.vo.Product;
@Transactional
public class ProductService {
	private ProducetDao producetDao;

	public ProducetDao getProducetDao() {
		return producetDao;
	}

	public void setProducetDao(ProducetDao producetDao) {
		this.producetDao = producetDao;
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
