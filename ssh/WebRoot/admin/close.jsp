<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'close.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@page contentType="text/html;charset=gb2312" import="cn.jidy.ssh.adminuser.vo.AdminUser"%>
	<%@page contentType="text/html;charset=gb2312" import="cn.jidy.ssh.adminuser.vo.AdminUser"%>
	<script type="text/javascript">
	function closeWindow()   
	{    
	    window.opener = null;    
	    window.open('', '_top', '');    
	    window.parent.close();    
	} 
	</script>
  </head>
  <body unload="closeWindow()">
  <% AdminUser  adminUser = (AdminUser) session.getAttribute("username");  
        if (adminUser != null) {  
            String username = adminUser.getUsername();  
            session.removeAttribute("username");  
            application = session.getServletContext();  
            ((HashMap) application.getAttribute("username")).remove(username);  
            System.out.println("login.jsp destory user: "+ adminUser.getUid());  
        }  %>
  </body>  
</html>
