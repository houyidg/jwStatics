<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
<title>学生管理列表</title>
<meta name="decorator" content="list" />
<html:css name="syntaxhighlighter" />
<html:component name="bootstrap-fileinput" />
</head>
<body title="学生管理">
	<div style="margin-bottom: 20px">
		<form:fileinput nested="false" path="infoid" uploadSuccessCallback="refreshCallback"
			buttonText="批量添加" multiple="false"
			uploadUrl="${adminPath}/yxsjtj/student/uploadSimditor"
			extend="xls,xlsx" />
	</div>
	<grid:grid id="studentGridId"
		url="${adminPath}/yxsjtj/student/ajaxList">
		<grid:column label="sys.common.key" hidden="true" name="id"
			width="100" />
		<grid:column label="sys.common.opt" name="opt" formatter="button"
			width="100" />
		<grid:button groupname="opt" function="delete" />
		<grid:column label="考生号" name="ksh" query="true" queryMode="input"
			condition="eq" />
		<grid:column label="毕业时间" name="bysj" query="true" queryMode="select"
			condition="eq" dict="bysj" />
		<grid:column label="院校代码" name="yxdm" query="true" queryMode="input"
			condition="eq" dict="yxdm" />
		<grid:column label="身份证" name="sfzh" />
		<grid:column label="姓名" name="xm" query="true" queryMode="input"
			condition="eq" />
		<grid:column label="性别代码" name="xbdm" dict="sex" />
		<grid:column label="民族代码" name="mzdm" />
		<grid:column label="政治面貌代码" name="zzmmdm" />
		<grid:column label="学历代码" name="xldm" />
		<grid:column label="专业" name="zy" />
		<grid:column label="入学时间" name="rxsj" dict="rxsj" />
		<grid:column label="毕业去向代码" name="byqxdm" query="true"
			queryMode="select" condition="eq" dict="bysqx" />
		<grid:column label="单位名称" name="dwmc" />
		<grid:column label="报到起始时间" name="bdqssj" />
		<grid:toolbar function="create" />
		<grid:toolbar function="update" />
		<grid:toolbar function="delete" />

		<grid:toolbar function="search" />
		<grid:toolbar function="reset" />
	</grid:grid>
	<script>
	  function refreshCallback(obj){
		  reset('studentGridIdGrid');
		  search('studentGridIdGrid');
		  // var fileid= attachmentList[i].data.id;
	  }
	</script>
</body>
</html>