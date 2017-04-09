package cn.lyj.ssh.index.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页访问的action
 * 
 * @author 盖世太保
 *
 */

public class IndexAction extends ActionSupport {
		
	/**
	 * 执行首页的的方法
	 */
	public String  execute() {
		return "index";
		
	}
}
