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
                  <a href=index.jsp>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					购物清单
                </td>
                </tr>
		</table>
              <br>

		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>数量</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>合计</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>

        <c:forEach items="${sessionScope.shoppingcar.lines }" var="map" varStatus="line">
        <tr>
			<form action="shopcart/saveUpdate/${map.value.book.id }" name="f1">
			<input type="hidden" name="bookid" value="${map.value.book.id }">
			<input type="hidden" name="number" value="1">
			<td class=tablebody2 valign=middle align=center width=""> ${line.index } </td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="bookDetail/${map.value.book.id}"> ${map.value.book.name }</a></td>
			<td class=tablebody2 valign=middle align=center width=""> ${map.value.book.price}</td>
			<td class=tablebody1 valign=middle align=center width=""><input type="text" name="num" value="${map.value.num }" size="4" onblur="javascript:if(this.value<1){alert('对不起，产品数量不能小于 1 ');this.value=1;this.focus();}else{number.value=this.value;document.f1.submit();}"/></td>
			<td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp; ${map.value.getSum() }</td>
			<td class=tablebody1 valign=middle align=center width="">
			<input type="button" value="取消" onclick="javascript:window.location='shopcart/delLine/${map.value.book.id }';"> <input type="submit" value="保存修改" ></td>
			</form>
		</tr>  
        </c:forEach>        
                
		<tr>
			<td class=tablebody1 valign=middle align=center colspan="4">　</td>
			<td class=tablebody1 valign=middle align=left width="">&nbsp;&nbsp;<font color="#ff0000"><b>￥ ${sessionScope.shoppingcar.getCost() }</b></font></td>
			<td class=tablebody1 valign=middle align=center width="">　</td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle align=center colspan="6"><input type="button" value="提交订单" onclick="javascript:window.location='confirmOrder';"> 
			<input type="button" value="继续购物" onclick="javascript:window.location='index';"> 
			<input type="button" value="清空购物车" onclick="javascript:window.location='shopcart/clear';"></td>
		</tr>
                </table><br>
<!--文件尾开始-->
	<c:import url="footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
	    $("#showspan").show().delay(3000).fadeOut();
	</script>

