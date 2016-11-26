<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<script>
	//设置冗余生产厂家名称
	function setFactoryName(val){
		var ele=document.getElementById("factoryName");
		ele.value=val;
	
	
	}


</script>



<body>
<form method="post"> 
	<input type="hidden"  name="contractProductId"  value="${obj.contractProductId }"  />
	<input  type="hidden"  name="contractId"  value="${obj.contractId }" />

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="update"><a href="#" onclick="formSubmit('update.action','_self');">确定</a></li>
<li id="back"><a href="${ctx }/cargo/contract/list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		修改货物信息
    </div> 
    </div>
    </div>
<div>
 

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">生产厂家名称：</td>
	            <td class="tableContent">
	            	<select  name="factoryId"  onchange="setFactoryName(this.options[this.selectedIndex].text);">
	            	<option value="" >--请选择</option>
	            		<c:forEach  items="${factoryList }"  var="f">
	            			<option  value="${f.factoryId }"  <c:if test="${obj.factoryId==f.factoryId }">selected</c:if>    >${f.factoryName}</option>
	            		</c:forEach>
	            	</select>
	            	<input type="hidden"  id="factoryName" name="factoryName"   value="${obj.factoryName }" />  
	            
	            </td>
	        	<td class="columnTitle_mustbe">货号：</td>
	            <td class="tableContent"><input type="text" name="productNo" value="${obj.productNo }"/></td>
	        </tr>
	        <tr>  
	        	<td class="columnTitle_mustbe">货物照片: </td>
	            <td class="tableContent"><input type="text" name="productImage" value="${obj.productImage }"/></td>
	           
	        </tr>
	        <tr> 
	           <td class="columnTitle_mustbe">数量：</td>
	            <td class="tableContent"><input type="text" name="cnumber" value="${obj.cnumber }"/></td>
	            <td class="columnTitle_mustbe">装率：</td>
	            <td class="tableContent"><input type="text" name="loadingRate" value="${obj.loadingRate }"/></td>
	        </tr>
	        <tr>    
	            <td class="columnTitle_mustbe">箱数：</td>
	            <td class="tableContent"><input type="text" name="boxNum" value="${obj.boxNum }"/></td>
	            <td class="columnTitle_mustbe">包装单位：</td>
	            <td class="tableContent"><input type="text" name="packingUnit" value="${obj.packingUnit }"/></td>
	        </tr>
	        <tr>     
	            <td class="columnTitle_mustbe">单价：</td>
	           <td class="tableContent"><input type="text" name="price" value="${obj.price }"/></td>
	        	<td class="columnTitle_mustbe">排序号：</td>
	           <td class="tableContent"><input type="text" name="orderNo" value="${obj.orderNo }"/></td>
	         
	         </tr>
	         <tr>     
	            <td class="columnTitle_mustbe">货物描述：</td>
	            <td class="tableContent"> <td class="tableContent"><textarea  name="productDesc"  style="height:120px;">${obj.productDesc }</textarea></td>
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
		<td class="tableHeader">装率</td>
		<td class="tableHeader">箱数</td>
		<td class="tableHeader">单价</td>
		<td class="tableHeader">总金额</td>
	
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="contractProductId" value="${o.contractProductId}"/></td>
		<td>${status.index+1}</td>
		<td>${o.factoryName}</td>
		<td>${o.productNo}</td>
		<td>${o.cnumber}</td>
		<td>${o.packingUnit}</td>
		<td>${o.loadingRate}</td>
		<td>${o.boxNum}</td>
		<td>${o.price}</td>
		<td>${o.amount}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
</div>
</form>
</body>
</html>

