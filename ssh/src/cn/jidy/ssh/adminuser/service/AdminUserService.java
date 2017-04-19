package cn.jidy.ssh.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import cn.jidy.ssh.adminuser.dao.AdminUserDao;
import cn.jidy.ssh.adminuser.vo.AdminUser;

/*
 * ��̨��½ҵ����
 */

//���������
@Transactional
public class AdminUserService {
	
	//ע��dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}



	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}

	
}
