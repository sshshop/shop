<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>传智商城</title>
<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>

</head>
<body>

	<%@ include file="menu.jsp" %>

<div class="container index">
		
		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">
					<div class="title">
						<strong>热门商品</strong>
						<!-- <a  ></a> -->
					</div>
					<ul class="tab">
							<li class="current">
								<a href="./蔬菜分类.htm?tagIds=1" ></a>
							</li>
							<li>
								<a  ></a>
							</li>
							<li>
								<a ></a>
							</li>
					</ul>
<!-- 					<div class="hotProductAd">
			<img src="${pageContext.request.contextPath}/image/a.jpg" width="260" height="343" alt="热门商品" title="热门商品">
</div> -->
						<ul class="tabContent" style="display: block;">
									<s:iterator var="h" value="hList">
									<li>
										<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#h.pid" />" ><img src="${pageContext.request.contextPath}/<s:property value="#h.image" />" style="display: block;" title="<s:property value="#h.pname" /> "/></a>
									</li>
								</s:iterator>	
						</ul>
						
			</div>
		</div>
		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
					<div class="title">
						<strong>最新商品</strong>
						<a  ></a>
					</div>
					<ul class="tab">
							<li class="current">
								<a href="#" ></a>
							</li>
							<li>
								<a  ></a>
							</li>
							<li>
								<a ></a>
							</li>
					</ul>
					
						 <ul class="tabContent" style="display: block;">
									<s:iterator var="n" value="nList">
									<li>
										<a href="${pageContext.request.contextPath}/product_findByPid.action?pid=<s:property value="#h.pid" />" ><img src="${pageContext.request.contextPath}/<s:property value="#n.image" />" style="display: block;" title="<s:property value="#n.pname" /> "/></a>									</li>
									</s:iterator>
						</ul>
			</div>
		</div>
		<div class="span24">
			<div class="friendLink">
				<dl>
					<dd><a  href="${pageContext.request.contextPath}/footer_newguide.action" >新手指南</a></dd>
							<dd>
								<a  href="${pageContext.request.contextPath}/footer_payanddistribution.action" >支付方式</a>
								|
							</dd>
							<dd>
								<a href="${pageContext.request.contextPath}/footer_payanddistribution.action" >配送方式</a>
								|
							</dd>
							<dd>
								<a  >售后服务</a>
								|
							</dd>
							<dd>
								<a href="${pageContext.request.contextPath}/footer_help.action" >购物帮助</a>
								|
							</dd>
			
							
							<dd>
								<a >银联卡</a>
								|
							</dd>
							
							
					
				</dl>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp" %>

</body></html>



