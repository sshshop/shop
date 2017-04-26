<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>帮助中心</title>
<link href="./css/slider.css" rel="stylesheet" type="text/css" />
<link href="./css/common.css" rel="stylesheet" type="text/css" />
<link href="./css/index.css" rel="stylesheet" type="text/css" />
<link href="./css/paydist.css" rel="stylesheet" type="text/css" />
<link href="./css/help.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body style="text-decoration:none;">
	<!-- 头部 -->
	<%@ include file="menu.jsp" %>
	<!-- 中间部分 -->
<br />
	<div class="container center">
		
		<div class="list">
			
			<div class="nav_item panel-group" id="accordion">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a class="nav_item_a" data-toggle="collapse" data-parent="#accordion" 
							   href="#collapseOne">
							购物指南
						</a>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in">
						<div class="panel-body">
							<ul id="myTab" class="nav nav-tabs">
								<li class="active">
									<a class=" list_item" href="#home" data-toggle="tab">
										礼品卡使用流程
									</a>
								</li>
								<li>
									<a class="list_item" href="#ios" data-toggle="tab">
										蔬菜卡使用流程
									</a>
								</li>
								<li>
									<a class="list_item" href="#ejb" data-toggle="tab">
									   test
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<a data-toggle="collapse" data-parent="#accordion" 
							   href="#collapseTwo">
							test
						</a>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse">
						<div class="panel-body">
							test
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">						
						<a data-toggle="collapse" data-parent="#accordion" 
							   href="#collapseThree">
								test
						</a>						
					</div>
					<div id="collapseThree" class="panel-collapse collapse">
						<div class="panel-body">
							test
						</div>
					</div>
				</div>
			</div>
			
		</div>
		<!--文字部分显示-->
		<div class="tab">
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="home">
					<p>
						<span class="text_item">1.服务说明 </span>
						<br />1)礼品卡简介
						<br />
						<br />一张送礼更有面子的『卡』，一种闪电般快速的支付方式，一个既有个性又能省钱的网购主张！
						<br />
						<br />
						<br /><span class="text_item">2)礼品卡支付的优势：时尚、便捷、有折扣：</span>
						<br />
						<br /> a.时尚：送东西怕人家不满意、送钱又显得太俗气，不如来张当当礼品卡！
						<br /> b.便捷：省去了准备零钱的麻烦，免去了登录网银的繁琐，节约了跑银行办理转账的时间！
						<br />c.有折扣：可以拉着亲朋好友一起“拼单”买，人数越多、优惠越多！
						<br />
						<br />2.如何使用礼品卡支付
						<br />
						<br />提交订单时，在页面最下方，点击“礼品卡”，填写“支付金额”、“支付密码”即可。
					</p>
				</div>
				<div class="tab-pane fade" id="ios">
					<p>
						<span class="text_item">1.服务说明 </span>
						<br />1)礼品卡简介
						<br />
						<br />一张送礼更有面子的『卡』，一种闪电般快速的支付方式，一个既有个性又能省钱的网购主张！
						<br />
						<br />
						<br /><span class="text_item">2)礼品卡支付的优势：时尚、便捷、有折扣：</span>
						<br />
						<br /> a.时尚：送东西怕人家不满意、送钱又显得太俗气，不如来张当当礼品卡！
						<br /> b.便捷：省去了准备零钱的麻烦，免去了登录网银的繁琐，节约了跑银行办理转账的时间！
						<br />c.有折扣：可以拉着亲朋好友一起“拼单”买，人数越多、优惠越多！
						<br />
						<br />2.如何使用礼品卡支付
						<br />
						<br />提交订单时，在页面最下方，点击“礼品卡”，填写“支付金额”、“支付密码”即可。
					</p>
				</div>
				<div class="tab-pane fade" id="jmeter">
		
				</div>
				<div class="tab-pane fade" id="ejb">
					
				</div>
			</div>
		</div>
		
	</div>
<br />
<br />
	<!-- 底部 -->
	<%@ include file="footer.jsp" %>
</body>
</html>
