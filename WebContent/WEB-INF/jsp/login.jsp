<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--文件头开始-->
<c:import url="header.jsp"></c:import>
		<center id="loginlog"></center>
		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="absmiddle">
                  <a href=index.html>杰普电子商务门户</a> → 用户登录
                </td>
                </tr>
		</table>
              <br>

	<form  >
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
		<tr>
			<td valign=middle colspan=2 align=center height=25 background="images/bg2.gif" ><font color="#ffffff"><b>输入您的用户名、密码登录</b></font></td>
		</tr>
		<tr>
		<td valign=middle class=tablebody1>请输入您的用户名</td>
			<td valign=middle class=tablebody1><INPUT id=username name=name type=text> &nbsp;
				<a href="register">没有注册？</a>
			</td>
		</tr>
		<tr>
			<td valign=middle class=tablebody1>请输入您的密码</td>
			<td valign=middle class=tablebody1><INPUT id=password name=password type=password> &nbsp; </td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center><input id=login type=button value="登 录" ></td>
		</tr>
		</table>
	</form>
<!--文件尾开始-->
<c:import url="footer.jsp"></c:import>

	<script src="js/jquery.min.js"></script>
	<script type="text/javascript">
	$("#login").click(function(){
		var url = "<%= basePath%>login/login"
		var obj = new Object();
		obj.name = $("#username").val();
		obj.password = $("#password").val();
		var objstr = JSON.stringify(obj)
		$.ajax({
			type:"post",
			url:url,
			data:objstr,
			contentType:"application/json;charset=UTF-8",
			success:function(data){
				if(data.status==200){
				$("#loginlog").html("<span><font color=\"#E3001B\" size=\"5px\">"+data.data+"</font></span>").show ().delay (3000).fadeOut ();
				window.location.href="<%= basePath%>index"
				}else{
					$("#loginlog").html("<span><font color=\"#E3001B\" size=\"5px\">"+data.data+"</font></span>").show ().delay (3000).fadeOut ();
				}
			}
		}
	)

});
</script>

