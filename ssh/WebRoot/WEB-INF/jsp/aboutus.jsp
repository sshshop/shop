<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>关于我们</title>
    
<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>

  </head>
  
  <body>
  
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/index.action"> <img
				src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif"
				alt="传智播客" />
			</a>
		</div>
	</div>
	<div class="span9">
		<div class="headerAd">
			<img src="${pageContext.request.contextPath}/image/header.jpg"
				width="320" height="50" alt="正品保障" title="正品保障" />
		</div>
	</div>

	<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<s:if test="#session.existUser == null">
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a
						href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>|</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;"><a
						href="${pageContext.request.contextPath}/user_registPage.action">注册</a>
					</li>
				</s:if>
				<s:else>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><s:property
							value="#session.existUser.name" /> |</li>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">我的订单</a> |</li>
					<li id="headerLogin" class="headerLogin"
						style="display: list-item;"><a
						href="${pageContext.request.contextPath}/user_quit.action">退出</a>
						|</li>
				</s:else>

				<li><a>会员中心</a> |</li>
				<li><a>购物指南</a> |</li>
				<li id="headerAboutUs" class="headerAboutUs"
					style="display: list-item;"><a href="about_us.html">关于我们</a>|
				</li>
			</ul>
		</div>
		<div class="cart">
			<a href="${ pageContext.request.contextPath }/cart_myCart.action">购物车</a>
		</div>
		<div class="phone">
			客服热线: <strong>96008/53277764</strong>
		</div>
	</div>

	<div class="span24">
		<ul class="mainNav">
			<li><a href="${pageContext.request.contextPath}/index.action">首页</a>
				|</li>
			<s:iterator var="c" value="#session.cList">
				<li><a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a> |</li>
			</s:iterator>
		</ul>
	</div>
  
   <div class="avout">
	<div>
		<div class="avout_us_left">
			<div class="avout_us_left_01">
				<div>
					<img src="images/icon_top.png" />公司概况
				</div>
				<div class="avout_us_left_top">
					<li style="color:#F60">关于我们</li>
					<li>联系我们</li>
					<li>退款说明</li>
					<li>经营模式</li>
				</div>
				<div>
					<img src="images/icon_top.png" />企业文化
				</div>
				<div class="avout_us_left_top">
					<li>服务承诺</li>
					<li>发展历程</li>
					<li>企业使命</li>
				</div>
			</div>
		</div>
		<div class="avout_us_right">
			<h3 style="color:#0062E7">About Tht Shop</h3>
			<p>本店是新一代B2C网上购物平台，现已覆盖传统家电，3C电器，日用百货等商品。本店铺将强化虚拟网络与实体店面的同步发展，不断提升网络市场份额，成为中国领先的B2C平台之一。</p>
			<p>本店承诺全部商品均为正品，全国超过800个城市可实现“货到付款”，保证所售商品价格物超所值。</p>
		</div>
	</div>
	</div>
</div>

</div>

<%@ include file="footer.jsp" %>

  </body>
</html>
