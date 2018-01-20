<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>

<!DOCTYPE html>
<html>
<head>
<title>数据统计</title>
<meta name="decorator" content="list" />
<html:css name="syntaxhighlighter" />
<link href="${staticPath}/statics/script/common.css" rel="stylesheet">
<link href="${staticPath}/statics/script/EmploymentTrengAnalysis.css"
	rel="stylesheet">
<style type="text/css">
</style>
<link href="${staticPath}/statics/script/UI/chosen.css" rel="stylesheet">
<script type="application/javascript"
	src="${staticPath}/statics/JS/UI/My97DatePicker/WdatePicker.js"></script>
<script type="application/javascript"
	src="${staticPath}/statics/JS/UI/chosen.js"></script>
<script type="application/javascript"
	src="${staticPath}/statics/JS/byqxfx.js"></script>
<script type="text/javascript">
	var baseUrl = "${staticPath}/statics";
	var realBaseUrl = "${adminPath}/yxsjtj/datastatics"
	var actiontype = "byqxfx";
	function generateChart(data) {
		var pieChart = echarts.init(document
				.getElementById("echarts-pie-chart"));
		var legendData = [];
		for ( var index in data) {
			legendData.push(data[index].name);
		}
		console.log('legendData', legendData);
		var pieoption = {
			title : {
				text : '毕业去向分析',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				x : 'left',
				data : legendData
			},
			label : {
				normal : {
					show : true,
					formatter : '{b}: {c}({d}%)'
				}
			},
			calculable : true,
			series : [ {
				name : '毕业去向分析',
				type : 'pie',
				data : data
			} ]
		};
		pieChart.setOption(pieoption);
		$(window).resize(pieChart.resize);
	}
</script>
<!-- 全局js -->
<html:js name="echarts" />
<!--下拉列表（院校所在州市列表）+下拉列表（院校性质列表）+下拉列表（隶属单位）+下拉列表（办学类型）+ 下拉列表（院校列表）+下拉列表（查询开始毕业时间）+下拉列表（查询终止毕业时间） -->
</head>
<body title="数据统计">
	<div class="contain">
		<!--条件选择-->
		<div class="choseCon1">
			<div class="nameAndDate">
				<div class="pageName">毕业去向分析</div>
				<div class="date" id="date">
					<input id="startTime" class="Wdate" type="text" value="2013"
						onclick="var endTime=$dp.$('endTime');WdatePicker({lang:'zh-cn',dateFmt:'yyyy',onpicked:function(){endTime.click();},maxDate:'#F{$dp.$D(\'endTime\')}'})" />
					&nbsp;至&nbsp; <input id="endTime" class="Wdate" type="text"
						value="2016"
						onclick="var startTime=$dp.$('startTime');WdatePicker({lang:'zh-cn',dateFmt:'yyyy',minDate:'#F{$dp.$D(\'startTime\')}'})" />
				</div>

			</div>
			<div class="CHOSE">
				<div class="oneBlock">
					<div class="nameLab">院校所在地：</div>
					<div class="chosedown" id="CArea"></div>
				</div>

				<div class="oneBlock">
					<div class="nameLab">院校性质：</div>
					<div class="chosedown" id="CFeature"></div>
				</div>

				<div class="oneBlock">
					<div class="nameLab">隶属单位：</div>
					<div class="chosedown" id="CBelongto"></div>
				</div>

				<div class="oneBlock">
					<div class="nameLab">办学类型：</div>
					<div class="chosedown" id="CType"></div>
				</div>
				<div class="oneBlock">
					<div class="nameLab">院校：</div>
					<div class="chosedown" id="CName"></div>
				</div>
				<div class="oneBlock">
					<div class="nameLab">专业：</div>
					<div class="chosedown" id="CZy"></div>
				</div>
			</div>
			<div class="sureCon">
				<span id="sure" class="btnSure">确定</span> <span id="reset"
					class="btnReset">重置</span>
			</div>
		</div>
		<!--图形显示-->
		<div class="picCon">
			<div class="pic_con" id="tableShow">
				<div class="Picshow" id="echarts-pie-chart"></div>
				<!--<div class="Picshow" id="bar" ></div>-->
			</div>
		</div>
		<%@include file="../common/loading.jsp" %>
	</div>

</body>
</html>