package cn.jidy.ssh.interceptor;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionEvent;

public class OnlineUserListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();

        // 取得登录的用户名
        String username = (String) session.getAttribute("username");
        // 从在线列表中删除用户名
        List onlineUserList = (List) application.getAttribute("onlineUserList");
        onlineUserList.remove(username);

        System.out.println(username + "超时退出。");
    }

}