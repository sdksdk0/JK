<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
		浏览生成厂家信息
    </div> 
    </div>
    </div>
<div>
 

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">客户名称：</td>
	            <td class="tableContent">${obj.customName }</td>
	        	<td class="columnTitle_mustbe">合同号：</td>
	            <td class="tableContent">${obj.contractNo }</td>
	        </tr>
	        <tr>  
	        	<td class="columnTitle_mustbe">制单人: </td>
	            <td class="tableContent">${obj.inputBy }</td>
	            <td class="columnTitle_mustbe">审单人:</td>
	            <td class="tableContent">${obj.checkBy }</td>
	        </tr>
	        <tr> 
	           <td class="columnTitle_mustbe">验货员：</td>
	            <td class="tableContent">${obj.inspector }</td>
	            <td class="columnTitle_mustbe">签单日期：</td>
	            <td class="tableContent"><fmt:formatDate value="${obj.signingDate }"  pattern="yyyy-MM-dd" /></td>
	        </tr>
	        <tr>    
	            <td class="columnTitle_mustbe">交货期限：</td>
	            <td class="tableContent"><fmt:formatDate value="${obj.deliveryPeriod }"  pattern="yyyy-MM-dd" /></td>
	            <td class="columnTitle_mustbe">船期：</td>
	            <td class="tableContent"><fmt:formatDate value="${obj.shipTime }"  pattern="yyyy-MM-dd" /></td>
	        </tr>
	        <tr>     
	            <td class="columnTitle_mustbe">总金额：</td>
	           <td class="tableContent">${obj.totalAmount }</td>
	         </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

