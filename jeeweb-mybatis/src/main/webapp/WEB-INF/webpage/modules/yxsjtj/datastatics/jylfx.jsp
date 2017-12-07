<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<html>
<head>
<title>数据统计</title>
<meta name="decorator" content="list" />
<html:css name="syntaxhighlighter" />
<link href="${staticPath}/statics/script/common.css" rel="stylesheet">
<link href="${staticPath}/statics/script/datagrid.css" rel="stylesheet">
<link href="${staticPath}/statics/script/EmploymentTrengAnalysis.css"
	rel="stylesheet">
<link href="${staticPath}/statics/script/UI/chosen.css" rel="stylesheet">
<link href="${staticPath}/statics/script/UI/datagrid.css"
	rel="stylesheet">
<style type="text/css">
.btnReset {
	cursor: pointer;
	padding: 5px 18px;
	background: #d08e29;
	color: #f4f4f4;
	border-radius: 7px;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	-o-border-radius: 7px;
}
</style>

<script type="application/javascript"
	src="${staticPath}/statics/JS/UI/My97DatePicker/WdatePicker.js"></script>
<script type="application/javascript"
	src="${staticPath}/statics/JS/UI/chosen.js"></script>
<script type="application/javascript"
	src="${staticPath}/statics/JS/jylfx.js"></script>
<script type="application/javascript"
	src="${staticPath}/statics/JS/datagrid.js"></script>
<script type="text/javascript">
	/*
	 * 
	 series : [
		 {
		 name:'蒸发量',
		 type:'bar',
		 data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
		 itemStyle : { normal: {label : {show: true}}},
		 },
		 {
		 name:'降水量',
		 type:'bar',
		 data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
		 }
	 ]
	 
	tableData :{"total":"156","rows":
				[
				{"schoolID":10610,"schoolName":"鍥涘窛澶у","schoolArea":"鎴愰兘","schoolType":"缁煎悎澶у","upUnit":"鏁欒偛閮�","eduType":"澶у","is211":"True","is985":"True","graduateTime":201607,"graduateNum":100000,"employRate":67,"waitEmployRate":24,"noEmployRate":9},
				]
			  }
	 */
	var baseUrl = "${staticPath}/statics";
	var realBaseUrl = "${adminPath}/yxsjtj/datastatics"
	var actiontype = "jylfx";

	function generateChart(data) {
		var xData = [ "就业", "待就业", "暂不就业" ];
		var name = "";
		var type = 'bar';
		var isContainAll = false;
		var series = [];
		var legend=[];
		var tableData = {};
		var index = 0;
		var size = data.length;
		//判断是否含有 yxdm == 全部
		if (size > 0 && data[index].yxdm == "全部") {
			series[index] = {};
			series[index].name = data[index].yxdm + name;
			series[index].type = type;
			series[index].data = [ data[index].jyrs, data[index].djyrs,
					data[index].bjynsxrs + data[index].qtzbjyrs ];
			series[index].itemStyle = { normal: {label : {show: true}}};
			legend[index] = series[index].name;
			index++;
			isContainAll = true;
		}

		if (isContainAll) {
			tableData.total = size - 1;
		} else {
			tableData.total = size;
		}
		tableData.rows = [];
		var tabIndex = 0;
		if (size > 0) {
			for (; index < size; index++) {
				var element = data[index];
				//组装图表数据
				if (!isContainAll) {
					series[index] = {};
					series[index].name = data[index].yxmc + name;
					series[index].type = type;
					series[index].data = [ data[index].jyrs, data[index].djyrs,data[index].bjynsxrs + data[index].qtzbjyrs ];
					series[index].itemStyle = { normal: {label : {show: true}}};
					legend[index] = series[index].name;
				}
				//组装表格数据
				/*
				tableData :{"total":"156","rows":
				[
				{"schoolID":10610,"schoolName":"鍥涘窛澶у","schoolArea":"鎴愰兘","schoolType":"缁煎悎澶у","upUnit":"鏁欒偛閮�","eduType":"澶у",
					"is211":"True","is985":"True","graduateTime":201607,"graduateNum":100000,"employRate":67,"waitEmployRate":24,"noEmployRate":9},
				]
				}
				public long count = 0;// 总人数
				public long jyrs = 0;// 就业人数
				public long djyrs = 0;// 待就业 70
				public long bjynsxrs = 0;// 不就业拟升学 71
				public long qtzbjyrs = 0;// 其他暂不就业 72
				//// 院校代码 院校名称 所在地 院校性质 隶属单位 办学类型 211 985 毕业时间 毕业人数
				public String yxdm;//
				public String yxmc;//
				public String yxszd;//
				public String yxxz;//
				public String yxlsdw;//
				public String yxbxlx;//
				public Short is211;//
				public Short is985;//
				 */
				var tab = tableData.rows[tabIndex++] = {};
				tab.schoolID = data[index].yxdm;
				tab.schoolName = data[index].yxmc;
				tab.schoolArea = data[index].yxszd;
				tab.schoolType = data[index].yxxz;
				tab.upUnit = data[index].yxlsdw;

				tab.eduType = data[index].yxbxlx;
				tab.is211 = data[index].is211 == 1 ? true
						: false;
				tab.is985 = data[index].is985 == 1 ? true
						: false;

				tab.graduateTime = start_time + "-"
						+ end_time;
				tab.graduateNum = data[index].count;
				tab.employRate = (data[index].jyrs * 1.0 / data[index].count).toFixed(4);
				tab.waitEmployRate = (data[index].djyrs * 1.0
						/ data[index].count).toFixed(4);
				tab.noEmployRate = ((data[index].bjynsxrs + data[index].qtzbjyrs)
						* 1.0 / data[index].count).toFixed(4);
			}
		}
		console.log("series:", series)
		console.log("tableData:", tableData)
		chart(series, xData,legend);
		dataGrid(tableData);
	}

	function chart(series, xData,legend) {
		var barChart = echarts.init(document
				.getElementById("echarts-bar-chart"));
		var baroption = {
			title : {
				text : '就业率分析'
			},
			tooltip : {
				trigger : 'item',
				show: true
			},
			legend : {
				data : legend
			},
			xAxis : [ {
				type : 'category',
				data : xData
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			label : {
				normal : {
					show : true,
					position : 'top'
				}
			},
			series : series
		};
		barChart.setOption(baroption, true);
		window.onresize = barChart.resize;
	}

	function dataGrid(tableData) {
		$('#datagrid').Datagrid(
						{
							pagination:false,
							staticData: tableData,
							heightAdjust : true,
							hasFirstCol : true,
							sortRule : 'desc',
							sortOrderBy : 'schoolID',
							columns : [
									{
										field : 'schoolID',
										title : '院校代码',
										width : 80,
										align : 'center',
										formatter : function(row) {
											return '<span class="schoolID" val="'+ row.schoolID+'">'
													+ row.schoolID + '</span>';
										}
									},
									{
										field : 'schoolName',
										title : '院校名称',
										width : 120,
										align : 'center',
										formatter : function(row) {
											return '<span class="schoolName" val="'+ row.schoolName+'">'
													+ row.schoolName
													+ '</span>';
										}
									},
									{
										field : 'schoolArea',
										title : '所在地',
										width : 80,
										align : 'center',
										formatter : function(row) {
											return '<span class="schoolArea" val="'+ row.schoolArea+'">'
													+ row.schoolArea
													+ '</span>';
										}
									},
									{
										field : 'schoolType',
										title : '院校性质',
										width : 100,
										align : 'center',
										formatter : function(row) {
											return '<span class="schoolType" val="'+ row.schoolType+'">'
													+ row.schoolType
													+ '</span>';
										}
									},
									{
										field : 'upUnit',
										title : '隶属单位',
										width : 120,
										align : 'center',
										formatter : function(row) {
											return '<span class="upUnit" val="'+ row.upUnit+'">'
													+ row.upUnit + '</span>';
										}
									},
									{
										field : 'eduType',
										title : '办学类型',
										width : 80,
										align : 'center',
										formatter : function(row) {
											return '<span class="eduType" val="'+ row.eduType+'">'
													+ row.eduType + '</span>';
										}
									},
									{
										field : 'is211',
										title : '211',
										width : 80,
										align : 'center',
										formatter : function(row) {
											return '<span class="is211" val="'+ row.is211+'">'
													+ row.is211 + '</span>';
										}
									},
									{
										field : 'is985',
										title : '985',
										width : 80,
										align : 'center',
										formatter : function(row) {
											return '<span class="is985" val="'+ row.is985+'">'
													+ row.is985 + '</span>';
										}
									},
									{
										field : 'graduateTime',
										title : '毕业时间',
										width : 80,
										align : 'center',
										formatter : function(row) {
											return '<span class="graduateTime" val="'+ row.graduateTime+'">'
													+ row.graduateTime
													+ '</span>';
										}
									},
									{
										field : 'graduateNum',
										title : '毕业人数',
										width : 80,
										align : 'center',
										formatter : function(row) {
											return '<span class="graduateNum" val="'+ row.graduateNum+'">'
													+ row.graduateNum
													+ '</span>';
										}
									},
									{
										field : 'employRate',
										title : "就业率",
										width : 100,
										align : 'center',
										sortable : true,
										formatter : function(row) {
											return '<span class="employRate" val="'+row.employRate+'">'
													+ row.employRate
													+ '%</span>';
										}
									},
									{
										field : 'waitEmployRate',
										title : "待就业率",
										width : 100,
										align : 'center',
										sortable : true,
										formatter : function(row) {
											return '<span class="waitEmployRate" val="'+row.waitEmployRate+'">'
													+ row.waitEmployRate
													+ '%</span>';
										}
									},
									{
										field : 'noEmployRate',
										title : "暂不就业率",
										width : 100,
										align : 'center',
										sortable : true,
										formatter : function(row) {
											return '<span class="noEmployRate" val="'+row.noEmployRate+'">'
													+ row.noEmployRate
													+ '%</span>';
										}
									}

							]
						});
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
				<div class="pageName">就业率分析</div>
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
				<div class="Picshow" id="echarts-bar-chart"></div>
			</div>
		</div>

		<div id="datagrid" style="margin: 0 auto"></div>
	</div>
</body>
</html>