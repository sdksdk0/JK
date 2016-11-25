<%@ page language="java" pageEncoding="UTF-8"%>


<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>


<li id="view"><a href="#" onclick="formSubmit('toView.action','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('toCreate.action','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('toUpdate.action','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('delete.action','_self');this.blur();">删除</a></li>
<!-- <li id="delete"><a href="#" onclick="formSubmit('deleteById.action','_self');this.blur();">删除一条</a></li>
  -->  
  
<li id="new"><a href="#" onclick="formSubmit('submit.action','_self');this.blur();">上报</a></li>
<li id="new"><a href="#" onclick="formSubmit('cancel.action','_self');this.blur();">取消</a></li>
 
</ul>
  </div>
</div>
</div>
</div>
   
<!-- 页面主体部分（列表等） -->  
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">



    购销合同列表
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
		<td class="tableHeader">合同号</td>
		<td class="tableHeader">缩写</td>
		<td class="tableHeader">联系人</td>
		<td class="tableHeader">制单人</td>
		<td class="tableHeader">手机</td>
		<td class="tableHeader">传真</td>
		<td class="tableHeader">签单日期</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="contractId" value="${o.contractId}"/></td>
		<td>${status.index+1}</td>
		<td><a href="toview.action?id=${o.contractId}">${o.fullName}</a></td>
		<td>${o.factoryName}</td>
		<td>${o.phone}</td>
		<td>${o.mobile}</td>
		<td>${o.fax}</td>
		<td>${o.signingDate}</td>
		<td>
			<c:if test="${o.state==1}"><a href="stop.action?contractId=${o.contractId }" ><font color="green">启用</font></a></c:if>
			<c:if test="${o.state==0}"><a href="start.action?contractId=${o.contractId }" ><font color="red">停用</font></a></c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

