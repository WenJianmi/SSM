<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp"></c:import>
<!--文件体开始-->
<center>
	<span>
		<font color="#E3001B" size="5px">${sessionScope.msg }</font>
	</span>
</center>
<c:remove var="msg" scope="session"/>

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="middle">
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					订单列表
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单编号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单金额</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>订单状态</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>付款方式</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
        <c:forEach items="${sessionScope.orders }" var="order" varStatus="index">
        	<tr>
			<td class=tablebody2 valign=middle align=center width="">${index.index+1 }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="orderlist/orderInfo/${order.id }">${order.id }</a></td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;${order.cost }</td>
			<td class=tablebody1 valign=middle align=center width="">${order.status }</td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;${order.payway } </td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="删除" onclick="javascript:window.location='orderlist/deleteOrder/${order.id }';">&nbsp;
			<input type="button" value="明细" onclick="javascript:window.location='orderlist/orderInfo/${order.id }';"> </td>
		</tr>
        </c:forEach>        
<c:import url="footer.jsp"></c:import>
<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
	    $("#showspan").show().delay(3000).fadeOut();
	</script>
