package cn.zy.ssh.category.vo;
/**
 * 一级分类vo实体类
 * @author Rabit
 *
 */
public class Category {
	private Integer cid;
	private String cname;
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
