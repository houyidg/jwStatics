<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>预订的手机列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="预订的手机">
<div>${requestScope.users }</div>
<grid:grid id="phoneGridId" url="${adminPath}/shoppingmall/phone/ajaxList">
	<grid:column label="sys.common.key" hidden="true" name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete" />
	
    <grid:column label="创建者"  name="createBy"  query="true"  queryMode="input"  condition="eq" />
    <grid:column label="创建时间"  name="createDate" />
    <grid:column label="删除标记（0：正常；1：删除）"  name="delFlag"  query="true"  queryMode="select"  condition="eq"  dict="sf"/>
    <grid:column label="备注信息"  name="remarks" />
    <grid:column label="预订人"  name="bookeName"  query="true"  queryMode="input"  condition="eq" />
    <grid:column label="预订日期"  name="bookDate"  query="true"  queryMode="date"  condition="eq" />
    <grid:column label="预订价格"  name="bookPrice"  query="true"  queryMode="input"  condition="eq" />
    <grid:column label="预订数量"  name="bookCount"  />
    <grid:column label="预订手机类型id"  name="phoneTypeId"  query="true"  queryMode="input"  condition="eq" />
	
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>