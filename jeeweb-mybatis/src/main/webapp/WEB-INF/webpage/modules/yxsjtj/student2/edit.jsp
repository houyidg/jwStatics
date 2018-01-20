<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title>学生管理</title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="studentForm">
    <form:form id="studentForm" modelAttribute="data" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>考生号:</label>
		            </td>
					<td class="width-35">
						<form:input path="ksh" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>毕业时间:</label>
		            </td>
					<td class="width-35">
						<form:select path="bysj" htmlEscape="false" class="form-control"  dict="bysj"  datatype="*"    />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>院校代码:</label>
		            </td>
					<td class="width-35">
						<form:select path="yxdm"
							htmlEscape="false" class="form-control" items="${universityList}" 
							itemLabel="name" itemValue="number" />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>姓名:</label>
		            </td>
					<td class="width-35">
						<form:input path="xm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>性别代码:</label>
		            </td>
					<td class="width-35">
						<form:select path="xbdm" htmlEscape="false" class="form-control"  dict="sex"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>民族代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="mzdm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>政治面貌代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="zzmmdm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>学历代码:</label>
		            </td>
					<td class="width-35">
						<form:select path="xldm" htmlEscape="false" class="form-control"  dict="xldm"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>专业代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="zydm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>专业:</label>
		            </td>
					<td class="width-35">
						<form:input path="zy" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>专业方向:</label>
		            </td>
					<td class="width-35">
						<form:input path="zyfx" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>培养方式代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="pyfsdm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>生源所在地代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="syszddm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>定向或委培单位:</label>
		            </td>
					<td class="width-35">
						<form:input path="dxhwpdw" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>学制:</label>
		            </td>
					<td class="width-35">
						<form:input path="xz" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>入学时间:</label>
		            </td>
					<td class="width-35">
						<form:select path="rxsj" htmlEscape="false" class="form-control"  dict="rxsj"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>困难生类别代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="knslbdm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>师范生类别代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="sfslbdm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>毕业去向代码:</label>
		            </td>
					<td class="width-35">
						<form:select path="byqxdm" htmlEscape="false" class="form-control"  dict="bysqx"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>单位组织机构代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="dwzzjgdm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>单位名称:</label>
		            </td>
					<td class="width-35">
						<form:input path="dwmc" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>单位性质代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="dwxzdm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>单位行业代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="dwhydm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>单位所在地代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="dwszddm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>工作职位类别代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="gzzwlbdm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>报到证签发类别代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="bdzqflbdm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>报到证签往单位名称:</label>
		            </td>
					<td class="width-35">
						<form:input path="bdzqwdwmc" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>签往单位所在地代码:</label>
		            </td>
					<td class="width-35">
						<form:input path="qwdwszddm" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
				</tr>
				<tr>
					<td  class="width-15 active text-right">	
		              <label>报到证编号:</label>
		            </td>
					<td class="width-35">
						<form:input path="bdzbh" htmlEscape="false" class="form-control"      />
						<label class="Validform_checktip"></label>
					</td>
					<td  class="width-15 active text-right">	
		              <label>报到起始时间:</label>
		            </td>
					<td class="width-35">
						<form:input path="bdqssj" htmlEscape="false" class="form-control"      />
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