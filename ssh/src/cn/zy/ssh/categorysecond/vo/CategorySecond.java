package cn.zy.ssh.categorysecond.vo;

import java.util.HashSet;
import java.util.Set;

import cn.lj.ssh.product.vo.Product;
import cn.zy.ssh.category.vo.Category;

public class CategorySecond {
	private Integer csid;
	private String csname;
	private Category category;
	private Set<Product> products = new HashSet<Product>();
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
}
