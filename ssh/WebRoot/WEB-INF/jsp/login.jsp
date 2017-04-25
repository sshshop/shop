<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath() %>/js/register.js"  type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
function findPassword(){
			alert("找回密码或者修改密码请联系商城管理员。<br />管理员邮箱：XXXXXXXXXXX@XXX.com");
		}
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container login">
		<div class="span12">
			<div class="ad">
				<img src="${pageContext.request.contextPath}/image/login.jpg"
					width="500" height="330" alt="会员登录" title="会员登录">
			</div>
		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员登录</strong>
					</div>
					<div class="title" style="margin-left:20px;">
						<span style="color:red;font-size:15px;"><s:actionerror/></span> 
					</div>
					<form id="loginForm" method="post" novalidate="novalidate"
						action="${pageContext.request.contextPath}/user_login.action">
						<table>
							<tbody>
								<tr>
									<th>用户名:</th>
									<td><input type="text" id="username" name="username"
										class="text" maxlength="20"></td>
								</tr>
								<tr>
									<th>密&nbsp;&nbsp;码:</th>
									<td><input type="password" id="password" name="password"
										class="text" maxlength="20" autocomplete="off"></td>
								</tr>
								
								<tr>
									<th>&nbsp;</th>
									<td><label> <input type="checkbox"
											id="isRememberUsername" name="isRememberUsername"
											value="true">记住用户名
									</label> </td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td>
										<input type="submit" class="submit" value="登 录">
									</td>
									<td>
									</td>
								</tr>
								<tr class="register">
									<th>&nbsp;</th>
									<td>
										<dl>
											<dt>还没有注册账号？</dt>
											<dd>
												立即注册即可体验在线购物！ <a href="${pageContext.request.contextPath}/user_registPage.action">立即注册</a>
												
											</dd>
										</dl>
										<a style="float: right; height: 40px" href="${pageContext.request.contextPath}/adminUser_quit.action" ><dt>管理员入口&nbsp;</dt></a>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp" %>

</body>
</html>