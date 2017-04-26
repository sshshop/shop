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
	 * 查询热门商品
	 * @author Rabit
	 * @return：返回list集合
	 */
	public List<Product> findHot() {
		
		return productDao.findHot();
	}
	/**
	 * 查询最新商品
	 * @author Rabit
	 * @return：返回list集合
	 */
	public List<Product> findNew() {
		return productDao.findNew();
	}

	public Product findByPid(Integer Pid) {
		return productDao.findByPid(Pid);
	}

	
	/**
	 *  根据一级分类主键查询商品的信息
	 * @author 盖世太保
	 *@param page :当前页数
	 *@param cid:一级分类的主键
	 */
	public PageBean<Product> findByPageCid(Integer cid,int page){
		PageBean<Product> pageBean=new PageBean<Product>();	
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示记录数；
		int limit=16;
		pageBean.setLimit(limit);
		//设置总记录数；
		int totalCount=0;
		totalCount=productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
		/*(int) Math.ceil(totalCount/limit)*/
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
			
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合；
		//从哪开始；
		int begin=(page-1)*limit; 
		List<Product> list=productDao.findByPageCid(cid,begin,limit);
		pageBean.setList(list); 
		return pageBean;
	}
	
	/**
	 *  根据二级分类主键查询商品的信息、带分页
	 * @author Rabit
	 *@param page :当前页数
	 *@param cid:二级分类的主键
	 */
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		PageBean<Product> pageBean=new PageBean<Product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示记录数；
		int limit=12;
		pageBean.setLimit(limit);
		//设置总记录数；
		int totalCount=0;
		totalCount=productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
		/*(int) Math.ceil(totalCount/limit)*/
		if(totalCount%limit==0){
			totalPage=totalCount/limit;
		}else{
			totalPage=totalCount/limit+1;
			
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合；
		//从哪开始；
		int begin=(page-1)*limit; 
		List<Product> list=productDao.findByPageCsid(csid,begin,limit);
		pageBean.setList(list); 
		return pageBean;
	}
	

	/**
	 *  
	 * @author 盖世太保
	 *
	 */
	
	//业务查询商品带分页的方法
		public PageBean<Product> findByPage(Integer page) {
			PageBean<Product> pageBean=new PageBean<Product>();
			//设置当前页数；
			pageBean.setPage(page);
			//设置每页显示记录数;
			int limit =15;
			pageBean.setLimit(limit);
			//设置总记录数；
			int totalCount=productDao.findCount();
			pageBean.setTotalCount(totalCount);
			//设置总页数
			int totalPage=0;
			if(totalCount%limit==0){
				totalPage=totalCount/limit;
				
			}else{
				totalPage=totalCount/limit+1;
			}
			pageBean.setTotalPage(totalPage);
			//设置显示到页面的数据集合；
			int begin=(page-1)*limit;
			List<Product> list=productDao.findByPage(begin,limit);
			pageBean.setList(list);
			return pageBean;
		}

		// 业务层保存商品方法:
		public void save(Product product) {
			productDao.save(product); 
		}

		// 业务层删除商品
		public void delete(Product product) {
			productDao.delete(product);
		}
		//业务层修改商品
		public void update(Product product) {
			productDao.update(product);
					
		}
}
