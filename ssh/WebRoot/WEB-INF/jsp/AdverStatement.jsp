<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>广告声明</title>
<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/LegalNotices.css" rel="stylesheet" type="text/css"/>
</head>
  
  <body>
  <%@ include file="menu.jsp" %>
    <div class="main">
	<div id="sub_sidebar">
		<div class="cover_layer"></div>
		<div class="sub_sidebar_list">
			<ul  class="sidebar_list_1">
				<li>
					<a href="#Advertising_description">广告说明</a>
				</li>
				<li>
					<a href="#Disclaimer">免责声明</a>
				</li>
				<li>
					<a href="#Genuine_License">正版授权</a>
				</li>
				<li>
					<a href="#Copyright_maintenance">版权维护</a>
				</li>
				<li>
					<a href="#Message_notification">消息通知</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="article_content">
		<div class="statement_list" id="Reminders" data-article="1">
			<div class="statement_item">
				<div class="statement_title">
					<h4 class="title">广告说明</h4>
				</div>
				<div class="statement_datails">
					<ul>
						<li>
							请客户充分理解，客户在本网站所看到的商品价格、折扣信息、优惠活动及其相关资料图表等。
						</li>
						<li>
							皆由相关第三发提供，由于消费市场价格波动的客观性，上述信息仅供您参考。
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="statement_list" id="Ownership_of_Rights" data-article="2">
			<div class="statement_item">
				<div class="statement_title">
					<h4 class="title">免责声明</h4>
				</div>
				<div class="statement_datails">
					<ul>
						<li>
							请客户充分理解并同意，本网站仅为信息发布品台。
						</li>
						<li>
							如果客户因为任何法定不可抗力或第三方原因导致财产损失的，本团队对此不承担任何责任。
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="statement_list" id="Protection_of_Rights" data-article="3">
			<div class="statement_item">
				<div class="statement_title">
					<h4 class="title">正版授权</h4>
				</div>
				<div class="statement_datails">
					<ul>
						<li>
							本网站承诺，凡本站出售商品均为正版。
						</li>
						<li>
							如有出现质量问题，本站承诺，可原额退货。
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="statement_list" id="Protection_of_Personal" data-article="4">
			<div class="statement_item">
				<div class="statement_title">
					<h4 class="title">版权维护</h4>
				</div>
				<div class="statement_datails">
					<ul>
						<li>
							本站承诺，本站不会以其它形式传播或兜售本网站所有商品。
						</li>
						<li>
							本站为唯一注册商标，如有相同网站或者个人，必为盗版，本公司有权利向人民法院提交诉讼。
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="statement_list" id="Juvenile_Protection" data-article="5">
			<div class="statement_item">
				<div class="statement_title">
					<h4 class="title">消息通知</h4>
				</div>
				<div class="statement_datails">
					<ul>
						<li>
							请消费者充分理解并同意，如消费者在购买商品时提交了消费者的个人信息。
						</li>
						<li>
							则被视为同意接受来着本网站以多种形式（仅包括短信、邮件和电话）所发布的可能与本站所出售商品相关的信息。
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>
  </body>
</html>
