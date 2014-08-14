<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>ADP反馈中心-首页</title>
		<link type="text/css" rel="stylesheet" href="common/css/main.css" />
	</head>
	<body>
		<script src="common/js/jquery.js" type="text/javascript"></script>
		<script src="common/js/main.js"></script>
		<div id="topbar">
			<div id="topbar_nav" class="nav">
				<a href="http://115.com/">桌面版</a><a href="http://u.115.com/">极速版</a><a
					href="http://g.115.com/">圈子</a><a href="http://fav.115.com/">收藏夹</a><a
					href="http://wo.115.com/">我的小窝</a><a href="http://ie.115.com/">浏览器</a>
			</div>
			<div id="topbar_login">
				<!--http://my.115.com/?action=register&amp;goto=http%3A%2F%2Ftool.115.com%2F-->
				<b id="topbar_acc">wangfei0715@vip.sina.com</b> |
				<a href="http://my.115.com/?ctl=user_manage">我的帐户</a>
				<a href="http://passport.115.com/?action=logout">退出</a>
			</div>
		</div>
		<div id="header">
			<a id="logo" href="/">115反馈中心</a>
			<div id="nav">
				<b class="b b-l"></b>
				<b class="b b-r"></b>
				<ul>
					<li>
						<a href="/" class="active"><span>反馈中心</span>
						</a>
					</li>
					<li>
						<a href="?ct=feedback&type=1&ac=flist&app_id=0"><span>常见问题</span>
						</a>
					</li>
					<li>
						<a href="?ct=feedback&type=2&ac=flist&app_id=0"><span>精彩建议</span>
						</a>
					</li>
					<!--<li><a href="#"><span>帮助</span></a></li>-->
				</ul>
			</div>
		</div>
		<div id="page">
			<div id="content">
				<div class="layout lay-ms">
					<div class="lay-main">
						<div class="main-wrap">
							<div class="mod-box-a">
								<b class="r-t"><b></b>
								</b>
								<div class="bc-a">

									<ul class="con-sys-list" id="con_syt_list">


										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=3'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-u"></i>
												<b>网络U盘</b>
												<a href="?ct=feedback&ac=flist&type=1&app=3">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=3">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>

										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=108'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-115brown"></i>
												<b>115浏览器</b>
												<a href="?ct=feedback&ac=flist&type=1&app=108">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=108">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>
										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=105'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-os"></i>
												<b>YLMF OS</b>
												<a href="?ct=feedback&ac=flist&type=1&app=105">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=105">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>

										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=102'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-xz"></i>
												<b>下载吧</b>
												<a href="?ct=feedback&ac=flist&type=1&app=102">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=102">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>


										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=200'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-udown"></i>
												<b>优蛋</b>
												<a href="?ct=feedback&ac=flist&type=1&app=200">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=200">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>


										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=4'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-tool"></i>
												<b>工具箱</b>
												<a href="?ct=feedback&ac=flist&type=1&app=4">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=4">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>

										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=101'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-114la"></i>
												<b>114啦</b>
												<a href="?ct=feedback&ac=flist&type=1&app=101">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=101">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>

										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=103'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-ylmf"></i>
												<b>YLMF官网</b>
												<a href="?ct=feedback&ac=flist&type=1&app=103">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=103">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>
										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=104'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-bbs"></i>
												<b>YLMF论坛</b>
												<a href="?ct=feedback&ac=flist&type=1&app=104">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=104">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>
										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=5'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-fav"></i>
												<b>收藏夹</b>
												<a href="?ct=feedback&ac=flist&type=1&app=5">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=5">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>
										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=111'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-wo"></i>
												<b>115充值</b>
												<a href="?ct=feedback&ac=flist&type=1&app=111">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=111">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>

										<li
											onclick="window.location.href='?ct=feedback&ac=flist&type=1&app=109'">
											<b class="r-t"><b></b>
											</b>
											<p class="sys-con">
												<i class="icon icon-915"></i>
												<b>769东莞地方门户</b>
												<a href="?ct=feedback&ac=flist&type=1&app=109">常见问题</a> |
												<a href="?ct=feedback&ac=flist&type=2&app=109">精彩建议</a>
											</p>
											<b class="r-b"><b></b>
											</b>
										</li>

									</ul>
								</div>
								<b class="r-b"><b></b>
								</b>
							</div>
						</div>
					</div>
					<!--/.lay-main-->
					<div class="lay-side">

						<div class="btn-area">

							<p class="link-big">
								<a title="我要提问" href="?ct=feedback&ac=ask&type=1&app=0"
									class="link1"></a>
								<a title="我要提建议" href="?ct=feedback&ac=ask&type=2&app=0"
									class="link2"></a>
							</p>
							<p class="link-other">
								<a href="?ct--feedback--ac--my">结果查询</a>
							</p>
						</div>
						<div class="btn-suggest">
							<a title="精彩建议" href="?ct=feedback&ac=flist&type=2&app=0"
								class="link1"></a>
						</div>

					</div>
					<!--/.lay-side-->
				</div>
				<!--/.lay-ms-->

				<div class="layout lay-mes mt10">
					<div class="lay-main">
						<div class="main-wrap">
							<div class="mod-box-b">
								<b class="r-t"><b></b>
								</b>
								<div class="bh-b">
									<h3>
										常见问题
										<span class="more"><a
											href="?ct=feedback&type=1&ac=flist&app=0">更多>></a>
										</span>
									</h3>

								</div>
								<div class="bc-b">

									<ul class="con-txt">
										<li>
											<a href="?ct=feedback&ac=flist&type=1&app=107" class="black"><b>[一键还原]</b>
											</a>
											<a href="?ct=feedback&ac=detail&type=1&fid=92139"
												class="grey">无法下载</a>
										</li>
										<li>
											<a href="?ct=feedback&ac=flist&type=1&app=107" class="black"><b>[一键还原]</b>
											</a>
											<a href="?ct=feedback&ac=detail&type=1&fid=91771"
												class="grey">lenovo(YANGTIANM4000)YAOQIUZHUJI...</a>
										</li>
										<li>
											<a href="?ct=feedback&ac=flist&type=1&app=107" class="black"><b>[一键还原]</b>
											</a>
											<a href="?ct=feedback&ac=detail&type=1&fid=90679"
												class="grey">一键还原：备份时提示找不到root/w...</a>
										</li>
										<li>
											<a href="?ct=feedback&ac=flist&type=1&app=107" class="black"><b>[一键还原]</b>
											</a>
											<a href="?ct=feedback&ac=detail&type=1&fid=90558"
												class="grey">功能不够好</a>
										</li>
										<li>
											<a href="?ct=feedback&ac=flist&type=1&app=107" class="black"><b>[一键还原]</b>
											</a>
											<a href="?ct=feedback&ac=detail&type=1&fid=90506"
												class="grey">关于menu.lst文件</a>
										</li>
										<li>
											<a href="?ct=feedback&ac=flist&type=1&app=107" class="black"><b>[一键还原]</b>
											</a>
											<a href="?ct=feedback&ac=detail&type=1&fid=90256"
												class="grey">一键还原的热键无效</a>
										</li>
									</ul>

								</div>
								<b class="r-b"><b></b>
								</b>
							</div>
						</div>
					</div>
					<!--/.lay-main-->
					<div class="lay-extra">
						<div class="mod-box-b">
							<b class="r-t"><b></b>
							</b>
							<div class="bh-b">
								<h3>
									精彩建议
									<span class="more"><a
										href="?ct=feedback&type=2&ac=flist&app=0">更多>></a>
									</span>
								</h3>

							</div>
							<div class="bc-b">

								<ul class="con-txt">
									<li>
										<a href="?ct=feedback&ac=flist&type=2&app=107" class="black"><b>[一键还原]</b>
										</a>
										<a href="?ct=feedback&ac=detail&type=2&fid=91308" class="grey">一键还原功能</a>
									</li>
									<li>
										<a href="?ct=feedback&ac=flist&type=2&app=107" class="black"><b>[一键还原]</b>
										</a>
										<a href="?ct=feedback&ac=detail&type=2&fid=88066" class="grey">卡巴斯基报毒</a>
									</li>
									<li>
										<a href="?ct=feedback&ac=flist&type=2&app=107" class="black"><b>[一键还原]</b>
										</a>
										<a href="?ct=feedback&ac=detail&type=2&fid=88063" class="grey">支持win7</a>
									</li>
									<li>
										<a href="?ct=feedback&ac=flist&type=2&app=3" class="black"><b>[网络U盘]</b>
										</a>
										<a href="?ct=feedback&ac=detail&type=2&fid=71714" class="grey">感谢115对知识产权的尊重</a>
									</li>
									<li>
										<a href="?ct=feedback&ac=flist&type=2&app=3" class="black"><b>[网络U盘]</b>
										</a>
										<a href="?ct=feedback&ac=detail&type=2&fid=71651" class="grey">感谢115网盘，网络有你更精彩</a>
									</li>
									<li>
										<a href="?ct=feedback&ac=flist&type=2&app=4" class="black"><b>[114啦工具箱]</b>
										</a>
										<a href="?ct=feedback&ac=detail&type=2&fid=65780" class="grey">建议-希望工具箱可以打包下载</a>
									</li>
								</ul>

							</div>
							<b class="r-b"><b></b>
							</b>
						</div>
					</div>
					<!--/.lay-extra-->
					<div class="lay-side">
						<div class="mod-box-b">
							<b class="r-t"><b></b>
							</b>
							<div class="bh-b">
								<h3>
									帮助中心
									<span class="more"><a href="http://115.com/help"
										target="_blank">更多>></a>
									</span>
								</h3>

							</div>
							<div class="bc-b">

								<ul class="con-txt">
									<li>
										<a href="http://115.com/" class="black"><b>[聚合搜索]</b>
										</a>
										<a href="http://115.com/help/tq.html" target="_blank"
											class="grey">115.com:天气预报查询</a>
									</li>
									<li>
										<a href="http://115.com/" class="black"><b>[聚合搜索]</b>
										</a>
										<a href="http://115.com/help/kd.html" target="_blank"
											class="grey">115.com:快递查询</a>
									</li>
									<li>
										<a href="http://115.com/" class="black"><b>[聚合搜索]</b>
										</a>
										<a href="http://115.com/help/bjx.html" target="_blank"
											class="grey">115.com:百家姓功能</a>
									</li>
									<li>
										<a href="http://115.com/" class="black"><b>[聚合搜索]</b>
										</a>
										<a href="http://115.com/help/pr.html" target="_blank"
											class="grey">网站PR值、ALexa排名速查</a>
									</li>
									<li>
										<a href="http://115.com/" class="black"><b>[聚合搜索]</b>
										</a>
										<a href="http://115.com/help/sc.html" target="_blank"
											class="grey">诗词解释</a>
									</li>
									<li>
										<a href="http://115.com/" class="black"><b>[聚合搜索]</b>
										</a>
										<a href="http://115.com/help/nba.html" target="_blank"
											class="grey">NBA当日比分查询</a>
									</li>
								</ul>

							</div>
							<b class="r-b"><b></b>
							</b>
						</div>
					</div>
					<!--/.lay-side-->
				</div>
				<!--/.lay-mes-->
			</div>
			<!--/#content-->
			<div id="footer">

				<a href="http://u.115.com/static/html/about.html">关于115网盘</a> -

				<a href="http://hr.ylmf.com/">加入我们</a> -

				<a href="http://u.115.com/static/html/tos.html">服务条款</a> -

				<a href="http://u.115.com/static/html/help.html">使用帮助</a> -

				<a href="http://feedback.115.com/?action=ask&amp;app=3">意见反馈</a>

				<br>
				Copyright &copy;2009-
				<script type="text/javascript">document.write(new Date().getFullYear());</script>
				115.com All Rights Reserved.
			</div>


		</div>


		<script>tagHover('con_syt_list','li');</script>
	</body>
</html>