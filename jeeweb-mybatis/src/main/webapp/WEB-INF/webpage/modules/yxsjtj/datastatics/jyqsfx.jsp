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
.oneBlock {
	float: left;
	width: 33%;
	margin: 5px 0;
}

.nameLab1 {
	font-size: 16px;
	font-weight: bolder;
}

.checkbox1 {
	margin: 2px;
}

.checkCon {
	margin-right: 20px;
}
</style>
<link href="${staticPath}/statics/script/UI/chosen.css" rel="stylesheet">
<script type="application/javascript"
	src="${staticPath}/statics/JS/UI/My97DatePicker/WdatePicker.js"></script>
<script type="application/javascript"
	src="${staticPath}/statics/JS/UI/chosen.js"></script>
<script type="application/javascript"
	src="${staticPath}/statics/JS/jyqsfx.js"></script>
<script type="text/javascript">
	var baseUrl = "${staticPath}/statics";
	var realBaseUrl = "${adminPath}/yxsjtj/datastatics"
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
				<div class="pageName">就业趋势分析</div>
			</div>
			<div class="CHOSE">
				<div class="oneBlock">
					<div class="nameLab">就业 形势：</div>
					<div class="chosedown" id="CQx"></div>
				</div>
				<div class="oneBlock">
					<div class="nameLab">院校所在地：</div>
					<div class="chosedown" id="CArea"></div>
				</div>

				<div class="oneBlock">
					<div class="nameLab">院校 性质：</div>
					<div class="chosedown" id="CFeature"></div>
				</div>

				<div class="oneBlock">
					<div class="nameLab">隶属 单位：</div>
					<div class="chosedown" id="CBelongto"></div>
				</div>

				<div class="oneBlock">
					<div class="nameLab">办学 类型：</div>
					<div class="chosedown" id="CType"></div>
				</div>
				<div class="oneBlock">
					<div class="nameLab">院 校：</div>
					<div class="chosedown" id="CName"></div>
				</div>
				<div class="oneBlock">
					<div class="nameLab">专 业：</div>
					<div class="chosedown" id="CZy"></div>
				</div>

				<div class="oneBlock">
					<span class="checkCon">
						<input type="checkbox"
						class="checkbox1" id="is985"/>
						<span class="nameLab1">985</span>
						</span>
					<span class="checkCon">
					<input type="checkbox"  data-type="checkbox" class="checkbox1" id="is211" /><span class="nameLab1">211</span></span>
				</div>

			</div>
			<div class="sureCon">
				<span id="sure" class="btnSure">确定</span><span id="reset"
					class="btnReset">重置</span>
			</div>
		</div>
		<!--图形显示-->
		<div class="picCon">
			<div class="top_lab">
				<ul id="tableChose1">
					<!-- 	<!--<li class="nowPic">饼图</li>-->
				</ul>
			</div>
			<div class="pic_con" id="tableShow">
				<div class="Picshow" id="echarts-line-chart"></div>
				<!--<div class="Picshow" id="bar" ></div>-->
			</div>
		</div>
	</div>

	<script type="text/javascript">
		//checkbox
		$("input[id='is985']").click(function() {
			console.log("985");
			loadCNameByOther();
		});
	    $('[data-type="checkbox"]').click(function() {
			console.log("is211");
			loadCNameByOther();
		});
	</script>
</body>
</html>