<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="back"><a href="list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		浏览装箱单信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">卖方：</td>
	            <td class="tableContent"><pre>${obj.seller}</pre></td>
	            <td class="columnTitle_mustbe">买方：</td>
	            <td class="tableContent"><pre>${obj.buyer}</pre></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">发票号：</td>
	            <td class="tableContent">${obj.invoiceNo}</td>
	            <td class="columnTitle_mustbe">发票日期：</td>
	            <td class="tableContent"><fmt:formatDate value="${obj.invoiceDate}" pattern="yyyy-MM-dd"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">唛头：</td>
	            <td class="tableContent"><pre>${obj.marks}</pre></td>
	            <td class="columnTitle_mustbe">描述：</td>
	            <td class="tableContent"><pre>${obj.descriptions}</pre></td>
	        </tr>
		</table>
	</div>
</div>
 
<div class="textbox" id="centerTextbox">
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		报运信息
    </div> 
    </div>
    </div>
<div>

<div style="text-align:left;">
	${divData}
</div>
 
</form>
</body>
</html>

