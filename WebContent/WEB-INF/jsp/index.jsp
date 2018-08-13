<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
                  <a href=index>杰普电子商务门户</a> →
					<img border="0" src="images/dog.gif" width="19" height="18">
					欢迎<font color="red">${sessionScope.customer.name }</font>光临！
                </td>
                </tr>
		</table>
              <br>
 		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>
		</tr>
		<c:forEach items="${sessionScope.pageInfo.list}" var="book" varStatus="ibook">
			<tr >
			<td class=tablebody2 valign=middle align=center width="">${ibook.index+1 }</td>
			<td class=tablebody1 valign=middle width="">&nbsp;&nbsp;<a href="bookDetail/${book.id }">${book.name}</a></td>
			<td class=tablebody2 valign=middle align=center width="">${book.price }</td>
			<td class=tablebody1 valign=middle align=center width=""><a href="shopcart/addToCart?bookid=${book.id }">
			<img border="0" src="images/car_new.gif" width="97" height="18"></a> </td>
			</tr>
		</c:forEach>
		
			<tr align="center" bgcolor="#FFFFFF">
			<td colspan="5">共${sessionScope.pageInfo.total }条记录 每页 4条 第${sessionScope.pageInfo.pageNum }/${sessionScope.pageInfo.lastPage }页 
			<a	href="index?page=1">首页</a>
					<c:if test="${sessionScope.pageInfo.hasPreviousPage}">
						<a href="index?page=${sessionScope.pageInfo.prePage }">上一页</a>
					</c:if>
					<c:if test="${sessionScope.pageInfo.hasNextPage}">
						<a href="index?page=${sessionScope.pageInfo.nextPage }">下一页</a>
					</c:if>
				<a href="index?page=${sessionScope.pageInfo.lastPage }">尾页</a>
			</td>
		</tr>

        </table>        
<!--文件尾开始-->
<c:import url="footer.jsp"></c:import>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
	    $("#showspan").show().delay(3000).fadeOut();
	</script>


