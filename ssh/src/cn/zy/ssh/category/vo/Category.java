package cn.zy.ssh.category.vo;

import java.util.HashSet;
import java.util.Set;

import cn.zy.ssh.categorysecond.vo.CategorySecond;

/**
 * 一级分类vo实体类
 * 
 * @author Rabit
 * 
 */
public class Category {
	private Integer cid;
	private String cname;
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();

	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}

	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
}
