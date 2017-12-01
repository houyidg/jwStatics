<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>院校管理</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="universityForm">
    <form:form id="universityForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>院校代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="number" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>院校名称:</label>
		            </td>
					<td class="width-35">
						<form:input path="name" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>所在地市州:</label>
		            </td>
					<td class="width-35">
						<form:select path="areaid" htmlEscape="false" class="form-control"  dict="yxszd"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>院校性质:</label>
		            </td>
					<td class="width-35">
						<form:select path="featureid" htmlEscape="false" class="form-control"  dict="yxxz"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>隶属单位:</label>
		            </td>
					<td class="width-35">
						<form:select path="belongto" htmlEscape="false" class="form-control"  dict="lsdw"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>办学类型:</label>
		            </td>
					<td class="width-35">
						<form:select path="typeid" htmlEscape="false" class="form-control"  dict="bxlx"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>211工程:</label>
		            </td>
					<td class="width-35">
						<form:select path="is211" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>985工程:</label>
		            </td>
					<td class="width-35">
						<form:select path="is985" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>独立学院:</label>
		            </td>
					<td class="width-35">
						<form:select path="isindependent" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>新增本科:</label>
		            </td>
					<td class="width-35">
						<form:select path="isnewbk" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>示范高职:</label>
		            </td>
					<td class="width-35">
						<form:select path="issfgz" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>科研机构:</label>
		            </td>
					<td class="width-35">
						<form:select path="iskyjg" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>民办院校:</label>
		            </td>
					<td class="width-35">
						<form:select path="ismbyx" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>培养专科:</label>
		            </td>
					<td class="width-35">
						<form:select path="ispyzk" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>培养本科:</label>
		            </td>
					<td class="width-35">
						<form:select path="ispybk" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>培养硕士:</label>
		            </td>
					<td class="width-35">
						<form:select path="ispyss" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>培养博士:</label>
		            </td>
					<td class="width-35">
						<form:select path="ispybs" htmlEscape="false" class="form-control"  dict="sf"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>所在地:</label>
		            </td>
					<td class="width-35">
						<form:select path="provinceid" htmlEscape="false" class="form-control"  dict="yxszs"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
		      
		   </tbody>
		</table>   
	</form:form>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor" />
</body>
</html>