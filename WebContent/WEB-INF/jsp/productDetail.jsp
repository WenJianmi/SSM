<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="header.jsp"></c:import>
<!--文件体开始-->
<center>
	<span id="showspan">
		<font color="#E3001B" size="5px">${sessionScope.msg }</font>
	</span>
</center>
<c:remove var="msg" scope="session"/> 
		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> → 产品明细
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" colspan="2"><p><font color="#ffffff"><b></b></font></td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="20%">【
			类&nbsp; 型 】</td>
			<td class=tablebody1 valign=middle width="80%">&nbsp;&nbsp; 类型  </td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="20%">【
			价&nbsp; 格 】</td>
			<td class=tablebody1 valign=middle width="80%">&nbsp;&nbsp;${book.price }</td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="">【出 版 社】</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;电子工业出版社</td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="">【 状&nbsp; 态
			】</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;${book.status }</td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="">【 库&nbsp; 存
			】</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;${book.num }</td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="">【小说类型】</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;小说类型</td>
		</tr>
		<tr>
			<td class=tablebody1 align=center width="" valign="top">【 简&nbsp; 介
			】</td>
			<td class=tablebody1 valign=middle width="">${desc }　　 </td>
		</tr>
		<tr>
			<td class=tablebody1 valign=middle align=center width="">　</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<img border="0" src="images/product/zcover2.gif" width="127" height="180"></td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle align=center colspan="2"><a href="shopcart/addToCart?bookid=${book.id }">
			<img border="0" src="images/buycar.gif" width="92" height="21"></a> </td>
		</tr>
		</table>

<c:import url="footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
	    $("#showspan").show().delay(3000).fadeOut();
	</script>

