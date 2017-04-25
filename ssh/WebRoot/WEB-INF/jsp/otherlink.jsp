<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

    <title>友情链接</title>
    
<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/otherlink.css" rel="stylesheet" type="text/css"/>

  </head>
  
  <body>
  
  <%@ include file="menu.jsp" %>
   <!--------傲娇的分割线------------>
<div class="container main">
 <!-- 左边部分-->
	<div class="left">
		<h2 style="padding-left: 50px;">时事新闻</h2>
		<div class="left_1">
			<ul>
			<li><a href="#1">闯红灯自称色盲</a></li>
			<li><a href="#2">中国游客消费万亿</a></li>
			<li><a href="#3">最贵车牌被疯抢</a></li>
			<li><a href="#4">133万现金变白纸</a></li>
			<li><a href="#5">白百何承认离婚</a></li>
			<li><a href="#6">彭于晏方发声明</a></li>
			<li><a href="#7">中国建超级宽带网</a></li>
			<li><a href="#8">最长寿老人逝世</a></li>
			<li><a href="#10">传销组织色诱洗脑</a></li>
			<li><a href="#20">卓伟曝鹿晗隐婚</a></li>
			<li><a href="#30">男子扔烟头引爆炸</a></li>
			<li><a href="#40">教授制贩丧尸药</a></li>
			<li><a href="#50">郑渊洁买十套房</a></li>
			<li><a href="#60">薛之谦怒怼黄牛党</a></li>
			<li><a href="#70">蝙蝠侠和妻子离婚</a></li>
			<li><a href="#80">黄晓明儿子首出镜</a></li>
		</ul>
		</div>
		<br>
		<br>
		<p>以上信息根据您的兴趣推荐  </p>
 
	</div>
<!--中间部分-->
	<div class="middle">
		<!---搜索框-->
		<div class="middle_1">
			<form action="">
				<input type="text" name="search" value="百度一下"  style="height: 35px;width:200px;font-size: 20px">
				<input type="submit" name="submit" value="search" style="height: 41px;width:70px;margin-left: -5px">
			</form>
		</div>
		<!----导航标-->   
		<div class="middle_2">
			<div class="middle_bottom_a">
				<ul>
					<li><a href="http://www.baidu.com">hao123影视</a></li>
					<li><a href="http://www.baidu.com">京东商城</a></li>
					<li><a href="http://www.baidu.com">今日特价</a></li>
					<li><a href="http://www.baidu.com">五折清仓体育</a></li>
					<li><a href="http://www.baidu.com">NBA汽车之家</a></li>
					<li><a href="http://www.baidu.com">斗鱼TV</a></li>
				</ul>
			</div>
			<div class="middle_bottom_a">
				<ul>
					<li><a href="http://www.baidu.com">苏宁易购</a></li>
					<li><a href="http://www.baidu.com">58 同 城</a></li>
					<li><a href="http://www.baidu.com">东方财富</a></li>
					<li><a href="http://www.baidu.com">37 游 戏</a></li>
					<li><a href="http://www.baidu.com">亚 马 逊</a></li>
					<li><a href="http://www.baidu.com">途牛旅游网</a></li>
				</ul>
			</div>
			<div class="middle_bottom_a">
				<ul>
					<li><a href="http://www.baidu.com">彩票•双色球</a></li>
					<li><a href="http://www.baidu.com">凤 凰 网</a></li>
					<li><a href="http://www.baidu.com">淘 宝 网</a></li>
					<li><a href="http://www.baidu.com">天猫好货</a></li>
					<li><a href="http://www.baidu.com">免费游戏</a></li>
					<li><a href="http://www.baidu.com">4399游戏</a></li>
				</ul>
			</div>
			<div class="middle_bottom_a">
				<ul>
					<li><a href="http://www.baidu.com">百度•贴吧</a></li>
					<li><a href="http://www.baidu.com">新浪•微博</a></li>
					<li><a href="http://www.baidu.com">搜狐•热点</a></li>
					<li><a href="http://www.baidu.com">腾　讯</a></li>
					<li><a href="http://www.baidu.com">网  易</a></li>
					<li><a href="http://www.baidu.com">优酷网</a></li>
				</ul>
			</div>
			<div class="middle_bottom_a">
				<ul>
					<li><a href="http://www.baidu.com">起点中文网</a></li>
					<li><a href="http://www.baidu.com">爱奇艺高清</a></li>
					<li><a href="http://www.baidu.com">中关村在线</a></li>
					<li><a href="http://www.baidu.com">电视剧</a></li>
					<li><a href="http://www.baidu.com">新浪新闻</a></li>
					<li><a href="http://www.baidu.com">少儿动画</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!----右边部分-->
	<div class="right">
		<div class="right_nav">视频<hr/></div>
		<div class="right_nav">游戏<hr/></div>
		<div class="right_nav">贴吧<hr/></div>
		<div class="right_nav">音乐<hr/></div>
		<div class="right_nav">淘宝<hr/></div>
		<div class="right_nav">天涯<hr/></div>
		<div class="right_nav">天猫<hr/></div>
		<div class="right_nav">京东</div>
	</div>
</div>
	
	<%@ include file="footer.jsp" %>
  </body>
</html>
