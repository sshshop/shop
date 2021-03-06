<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>支付配送</title>
    
<link href="${pageContext.request.contextPath}/css/slider.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/paydist.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  <%@ include file="menu.jsp" %>
   <div class="container center">
		<!-- 中间支付部分 -->
		<div id="center_top" class="pay">
			<h1>支付分类</h1>
			<div class="pay_div">货到付款、信用卡支付、在线支付、PayPal支付、银行电汇及邮政汇款不同支付方式</div>
			<h2>货到付款</h2>
			<div class="pay_div">快递送货上门时使用现金支付，无需收取额外手续费。</div>
			<div class="pay_div">根据收货人地址选择正确的省、市、区/县后，系统会提示您可供选择的送货方式及相关配送信息。</div>
			<h2>信用卡支付</h2>
			<div class="pay_div">信用卡付款是顾客自愿使用其信用卡通过网络即时向对方帐户支付的一种方式，付款成功后，所支付的款项将立刻进入商家提供的账户，信用卡支付方式比较灵活，使用范围比较广，在欧美发达使用的人数尤其多。</div>
			<div class="pay_div">使用信用卡完成支付有几种方式，第一种类似于直接银行转账，将款从信用卡直接汇到对方的提供的银行账户，这种方式在国内来说需要同时拥有信用卡银行的借记卡，转账额度和费率都比较高，且效率和安全性不高，一般使用这种方式的比较少；第二种是可以通过信用卡支付通道完成付款，目前国内拥有多家信用卡通道第三方支付公司，其采取的是将款打到第三方支付公司的账户上，然后由第三方支付公司将款汇至指定的账户中，这种方式是比较成熟的付款方式，由于目前国内使用信用卡支付的基数还比较小，这种方式主要使用在外贸方面；信用卡支付方式还可以跟其他的支付方式结合起来一起使用，比如跟电子账户结合起来，这里就不多说了。</div>
			<h2>在线支付</h2>
			<div class="pay_div">支持支付宝、微信钱包、百度钱包等在线支付工具，</div>
			<div class="pay_div">提交订单以后选择在线支付即可。</div>
			<h2>网银支付</h2>
			<div class="pay_div">网银在线支付：网上商城采用中国银联支付平台，各银行对网上支付的要求进行操作。</div>
		</div>

		<br /> <br /> <br />
		<div>
			<!-- 中间派送部分 -->
			<div class="center_tr">
				<div id="center_transport" class="transport">
					<h1>派送方式</h1>
					<div class="trans_div">
						<h2>圆 通 速 递</h2>
						<strong>详细介绍：</strong>门对门服务，价格实惠，且可以送货上门!选择此运输方式，请先到圆通网站进行网点查询，送货不到，退回邮资自理!
						<div class="trans_div_detiled">查询网址：<a href="http://www.yto.net.cn" target="_blank">http://www.yto.net.cn</a></div>
						<div class="trans_div_detiled">
							首重7.00/3KG 续重1.00元/KG<br /> 送货范围：广东省东莞以内，送达时间：1个工作日<br />
							首重8.00元/3KG 续重1.00元/KG<br /> 送货范围：广东省内 东莞以外
							(汕尾己停，请不要发)，送达时间：1个工作日<br /> 首重10.00元/1KG 续重6.00元/KG<br />
							送货范围：江苏、浙江、上海、福建，送达时间：2-3个工作日<br /> 首重12.00/1KG 续重8.00元/KG<br />
							送货范围：北京、天津、重庆、湖南、湖北、海南、安微、广西、江西、四川、贵州、河南、陕西、云南、山东、山西、河北<br />
							送达时间：3-5个工作日<br /> 首重15.00/1KG 续重10.00元/KG<br />
							送货范围：辽宁、吉林、黑龙江、新疆、甘肃、内蒙、宁夏、青海，<br /> 送达时间：4-6个工作日<br /> 西藏
							首重17.00/1.0KG,续重15.00元/KG<br /> 送达时间：4-6个工作日
						</div>
					</div>
					<div class="trans_div">
						<h2>顺 丰 速 运</h2>
						<strong>详细介绍：</strong>门对门服务，一般在2-3内到达。价格较高，服务好，速度快，适用于收货急的客户!
						<div class="trans_div_detiled">查询网址：<a href="http://www.sf-express.com" target="_blank">http://www.sf-express.com</a></div>
						<div class="trans_div_detiled">客服热线：4008 111 111</div>
						<div class="trans_div_detiled">
							首重12.00元/1KG 续重2.00元/KG<br /> 送货范围：广东省(非即日件)<br /> 首重14.00元/1KG
							续重2.00元/KG<br /> 送货范围：广东省(即日件)<br /> 首重20.00元/1KG 续重13.00元/KG<br />
							送货范围：全国(除广东省)，送达时间：2-3个工作日
						</div>

					</div>
					<div class="trans_div">
						<h2>EMS 国 内 特 快 专 递</h2>
						<strong>详细介绍：</strong>国家邮政特快专递，门对门服务，一般在2-5天内到达。由快递公司中转，所以速度反而会比一般的快递慢。主要用于一般快递无法到达地区。
						<div class="trans_div_detiled">查询网址：<a href="http://www.ems.com.cn" target="_blank">http://www.ems.com.cn</a></div>
						<div class="trans_div_detiled">
							首重20.00元/0.5KG 续重6.00元/0.5KG<br /> 部分地区续重10.00元/0.5KG<br />
							送货范围：全国 辽宁、吉林、黑龙江、新疆、西藏、甘肃、内蒙、宁夏、青海[续重10.00/KG]<br />
							送达时间：2-5工作日
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="footer.jsp" %>
  </body>
</html>
