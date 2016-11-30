<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
</head>

<script type="text/javascript">
	//必须从此转向，否则路径错误会导致读取配置xml和数据xml文件错误。
 	window.location.href = "<%=request.getParameter("forward")%>/index.html";
</script>

<body>


</body>
</html>
