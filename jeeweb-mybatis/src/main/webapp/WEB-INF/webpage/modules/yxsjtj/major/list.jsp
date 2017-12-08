<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>专业列表</title>
  <meta name="decorator" content="list"/>
  <html:component name="bootstrap-fileinput" />
  <script>
	  function refreshCallback(obj){
		  reset('majorGridIdGrid');
		  search('majorGridIdGrid');
		  // var fileid= attachmentList[i].data.id;
	  }
	</script>
</head>
<body title="专业">
<div style="margin-bottom: 20px">
		<form:fileinput nested="false" path="infoid" uploadSuccessCallback="refreshCallback"
			buttonText="批量添加" multiple="false"
			uploadUrl="${adminPath}/yxsjtj/major/uploadSimditor"
			extend="xls,xlsx" />
	</div>
<grid:grid id="majorGridId" url="${adminPath}/yxsjtj/major/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete" />
    <grid:column label="学历代码"  name="xldm"  query="true"  queryMode="select"  condition="eq"  dict="xldm"/>
    <grid:column label="专业代码"  name="zydm"  query="true"  queryMode="input"  condition="eq" />
    <grid:column label="专业名称"  name="zymc"  query="true"  queryMode="input"  condition="eq" />
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
</body>
</html>