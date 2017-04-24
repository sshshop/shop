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

        // ȡ�õ�¼���û���
        String username = (String) session.getAttribute("username");
        // �������б���ɾ���û���
        List onlineUserList = (List) application.getAttribute("onlineUserList");
        onlineUserList.remove(username);

        System.out.println(username + "��ʱ�˳���");
    }

}