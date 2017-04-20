package cn.lj.ssh.utils;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
/**
 * 执行hql语句
 * @author Rabit
 *
 * @param <T>
 */
public class PageHibernateCallback <T> implements HibernateCallback<List<T>>{
	private String hql;
	private Object[] params;
	private int startIndex;
	private int pageSize;

	/**
	 * 构造函数
	 * 
	 * @param hql
	 *           传入的hql语句
	 * @param params
	 *            hql语句的参数
	 * @param startIndex
	 *           开始的页书
	 * @param pageSize
	 *           每页显示的数量
	 */
	public PageHibernateCallback(String hql, Object[] params, int startIndex,
			int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	/**
	 *执行
	 * @author Rabit
	 * 
	 */
	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {
		//1.ִ设置hql语句
		Query query = session.createQuery(hql);
		//2.hql设置参数
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		//3.分页
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}
}
