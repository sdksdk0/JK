<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
</head>
<body>
<form method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('insert.action','_self');">确定</a></li>
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
		新增装箱单信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">卖方：</td>
	            <td class="tableContent"><textarea name="seller" style="height:120px;"></textarea></td>
	            <td class="columnTitle_mustbe">买方：</td>
	            <td class="tableContent"><textarea name="buyer" style="height:120px;"></textarea></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">发票号：</td>
	            <td class="tableContent"><input type="text" name="invoiceNo"/></td>
	            <td class="columnTitle_mustbe">发票日期：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="invoiceDate"
	             			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">唛头：</td>
	            <td class="tableContent"><textarea name="marks" style="height:120px;"></textarea></td>
	            <td class="columnTitle_mustbe">描述：</td>
	            <td class="tableContent"><textarea name="descriptions" style="height:120px;"></textarea></td>
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
	${divDate}
</div>
 
</form>
</body>
</html>

