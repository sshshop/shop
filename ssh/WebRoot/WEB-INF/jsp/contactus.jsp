<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
   
    <title>联系我们</title>
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
					<li>关于我们</li>
					<li style="color:#F60">联系我们</li>
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
		<div class="avout_us_right" >
			<h3 style="color:#0062E7">Contact Us</h3>
            <br>
		<div style=" margin:0 auto;width:auto;height:100%;margin-bottom: 80px;">
            <div style="float:left; width:50%; height:100%" >
				<div >
					<img src="images/icon_top.png" />行业分类&简介
				</div>
                <br>
                <p><h4>&nbsp &nbsp 淘宝消费者</h4></p>
                <br>
                <p>&nbsp &nbsp为淘宝买家提供各类业务咨询</p>
                <br>
                <p><h4>&nbsp &nbsp 天猫消费者</h4></p>
                <br>
                <p>&nbsp &nbsp为天猫卖家提供各类业务咨询</p>
                <br>
                <p><h4>&nbsp &nbsp 阿里旅行</h4></p>
                <br>
                <p>&nbsp &nbsp阿里旅行服务热线提供机票、旅游度假、景点门票、酒店客栈、航空意外险的业务咨询</p>
                
               
             </div>
             
              <div float:left; width:50%;height:100%;>
                    <div >
                        <img src="images/icon_top.png" />热线电话 
                    </div>
                    
                    
                    <br>
                    <p><h4>&nbsp &nbsp 0571-88158198 </h4></p>
                    <br>
                    <p>&nbsp &nbsp（7*24小时）</p>
                    <br>
                    <p><h4>&nbsp &nbsp 0571-88157858 </h4></p>
                    <br>
                    <p>&nbsp &nbsp（周一～周日 9:00-21:00）</p>
                    <br>
                    <p><h4>&nbsp &nbsp 400-860-8608 </h4></p>
                    <br>
                    <p>&nbsp &nbsp（周一～周日 9:00-24:00）</p>
             </div>
			
         </div>
       </div> 

</div>

<%@ include file="footer.jsp" %>
  </body>
</html>
