<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>手机型号列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="手机型号">
<grid:grid id="phonetypeGridId" url="${adminPath}/shoppingmall/phonetype/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button title="sys.common.delete"  groupname="opt" function="delObj" outclass="btn-danger" innerclass="fa-trash" url="${adminPath}/shoppingmall/phonetype/delete" />
    <grid:column label="更新者"  name="updateBy"  query="true"  queryMode="input"  condition="eq" />
    <grid:column label="更新时间"  name="updateDate" />
    <grid:column label="删除标记（0：正常；1：删除）"  name="delFlag"  query="true"  queryMode="select"  condition="eq"  dict="sf"/>
    <grid:column label="备注信息"  name="remarks" />
    <grid:column label="价格"  name="price"  query="true"  queryMode="input"  condition="eq" />
    <grid:column label="价格单位"  name="priceUnit"  query="true"  queryMode="select"  condition="eq"  dict="coinunit"/>
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>