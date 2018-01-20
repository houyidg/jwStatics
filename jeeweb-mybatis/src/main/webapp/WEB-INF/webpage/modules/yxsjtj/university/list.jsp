<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>院校管理列表</title>
  <meta name="decorator" content="list"/>
  <html:css name="syntaxhighlighter" />
<html:component name="bootstrap-fileinput" />
</head>
<body title="院校管理">
<div style="margin-bottom: 20px">
		<form:fileinput nested="false" path="infoid" uploadSuccessCallback="refreshCallback"
			buttonText="批量添加" multiple="false"
			uploadUrl="${adminPath}/yxsjtj/university/uploadSimditor"
			extend="xls,xlsx" />
	</div>
<grid:grid id="universityGridId" url="${adminPath}/yxsjtj/university/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button groupname="opt" function="delete" />
    <grid:column label="院校代码"  name="number"  query="true"  queryMode="input"  condition="eq" />
    <grid:column label="院校名称"  name="name"  query="true"  queryMode="input"  condition="eq" />
    <grid:column label="所在地市州"  name="areaid"  query="true"  queryMode="select"  condition="eq"  dict="yxszd"/>
    <grid:column label="院校性质"  name="featureid"  query="true"  queryMode="select"  condition="eq"  dict="yxxz"/>
    <grid:column label="隶属单位"  name="belongto"  query="true"  queryMode="select"  condition="eq"  dict="lsdw"/>
    <grid:column label="办学类型"  name="typeid"  query="true"  queryMode="select"  condition="eq"  dict="bxlx"/>
    <grid:column label="211工程"  name="is211"  query="true"  queryMode="select"  condition="eq"  dict="sf"/>
    <grid:column label="985工程"  name="is985"  query="true"  queryMode="select"  condition="eq"  dict="sf"/>
    <grid:column label="独立学院"  name="isindependent"  dict="sf"/>
    <grid:column label="新增本科"  name="isnewbk"  dict="sf"/>
    <grid:column label="示范高职"  name="issfgz"  dict="sf"/>
    <grid:column label="科研机构"  name="iskyjg"  dict="sf"/>
    <grid:column label="民办院校"  name="ismbyx"  dict="sf"/>
    <grid:column label="培养专科"  name="ispyzk"  dict="sf"/>
    <grid:column label="培养本科"  name="ispybk"  dict="sf"/>
    <grid:column label="培养硕士"  name="ispyss"  dict="sf"/>
    <grid:column label="培养博士"  name="ispybs"  dict="sf"/>
    <grid:column label="所在地"  name="provinceid"  query="true"  queryMode="select"  condition="eq"  dict="yxszs"/>
	<grid:toolbar function="create"/>
	<grid:toolbar function="update"/>
	<grid:toolbar function="delete"/>
	
	<grid:toolbar function="search"/>
	<grid:toolbar function="reset"/>
</grid:grid>
<script>
function infoiduploadsuccess(event, data, previewId, index) {
		  console.log(data);
		  reset('universityGridIdGrid');
		  search('universityGridIdGrid');
		  alert("导入完成");
	  }
	</script>
</body>
</html>