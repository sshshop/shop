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
	 * ��ѯ������Ʒ
	 * @author Rabit
	 * @return������list����
	 */
	public List<Product> findHot() {
	
		return null;
	}
	/**
	 * ��ѯ������Ʒ
	 * @author Rabit
	 * @return������list����
	 */
	public List<Product> findNew() {
		return null;
	}
	
}
