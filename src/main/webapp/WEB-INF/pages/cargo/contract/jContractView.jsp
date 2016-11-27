<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
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
 
 
  <div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">

    货物列表
  </div> 
  </div>
  </div>
  
<div>
 <div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">厂家名称</td>
		<td class="tableHeader">货号</td>
		<td class="tableHeader">数量</td>
		<td class="tableHeader">包装单位</td>
		<td class="tableHeader">单价</td>
		<td class="tableHeader">总金额</td>
		
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${obj.contractProductCs}" var="cp" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td>${status.index+1}</td>
		<td>${cp.factoryC.factoryName}</td>
		<td>${cp.productNo}</td>
		<td>${cp.cnumber}</td>
		<td>${cp.packingUnit}</td>
		<td>${cp.price}</td>
		<td>${cp.amount}</td>
		
	</tr>
	
	<c:forEach items="${cp.extCproductCs}" var="ext"  varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><font color="blue">附件:${status.index+1}</font></td>
		<td>${ext.factoryC.factoryName}</td>
		<td>${ext.productNo}</td>
		<td>${ext.cnumber}</td>
		<td>${ext.packingUnit}</td>
		<td>${ext.price}</td>
		<td>${ext.amount}</td>
		
	</tr>
	</c:forEach>
	
	
	
	
	</c:forEach>
	
	</tbody>
</table>
</div>
</div>
 
</form>
</body>
</html>

