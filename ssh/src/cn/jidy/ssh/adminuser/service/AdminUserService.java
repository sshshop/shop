package cn.jidy.ssh.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import cn.jidy.ssh.adminuser.dao.AdminUserDao;
import cn.jidy.ssh.adminuser.vo.AdminUser;

/*
 * 后台登陆业务类
 */

//加事务管理
@Transactional
public class AdminUserService {
	
	//注入dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}



	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}

	
}
