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
<link href="${staticPath}/statics/script/UI/chosen.css" rel="stylesheet">
 <link href="${staticPath}/statics/script/UI/datagrid.css" rel="stylesheet">
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
	var baseUrl = "${staticPath}/statics";
	var realBaseUrl = "${adminPath}/yxsjtj/datastatics"
	var actiontype = "jylfx";
	function generateChart(data) {
		var xData = [];
		var yData = [];
		for ( var index in data) {
			xData.push(data[index].name);
			yData.push(data[index].value);
		}
		var barChart = echarts.init(document
				.getElementById("echarts-bar-chart"));
		var baroption = {
			title : {
				text : '就业率分析'
			},
			tooltip : {
				trigger : 'item'
			},
			legend : {
				data : [ '就业情况' ]
			},
			//		        calculable : true,
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
			series : [ {
				name : '就业情况',
				type : 'bar',
				data : yData,
			} ]
		};
		barChart.setOption(baroption);
		window.onresize = barChart.resize;
	}
	
	var tableBaseUrl = "${staticPath}/statics/JS"	
	$(function(){
	    dataGrid()
	});
	function dataGrid(){
	    //    var data = $.extend({},getParams(),getPostDate())
	    var data = ''
	    $('#datagrid').Datagrid({
	        url:tableBaseUrl+'/Json/table.json',
	        height: 300,
	        height:340,
	        pageRowList:[10,20,30],
	        heightAdjust:false,
	        hasFirstCol:false,
	        sortRule:'desc',
	        sortOrderBy:'schoolID',
//	      dataParam:data,
	        columns:[
	            {field: 'schoolID', title: '院校代码', width: 80, align: 'left', formatter:function(row)
	            {
	                return  '<span class="schoolID" val="'+ row.schoolID+'">' + row.schoolID+'</span>';
	            }
	            },
	            {field: 'schoolName', title: '院校名称', width:120, align: 'left', formatter:function(row){
	                return  '<span class="schoolName" val="'+ row.schoolName+'">' + row.schoolName+'</span>';
	            }
	            },
	            {field: 'schoolArea', title: '所在地', width: 80, align: 'left', formatter:function(row){
	                return  '<span class="schoolArea" val="'+ row.schoolArea+'">' + row.schoolArea+'</span>';
	            }
	            },
	            {field: 'schoolType', title: '院校性质', width: 100, align: 'left', formatter:function(row){
	                return  '<span class="schoolType" val="'+ row.schoolType+'">' + row.schoolType+'</span>';
	            }
	            },
	            {field: 'upUnit', title: '隶属单位', width: 120, align: 'left', formatter:function(row){
	                return  '<span class="upUnit" val="'+ row.upUnit+'">' + row.upUnit+'</span>';
	            }
	            },
	            {field: 'eduType', title: '办学类型', width: 80, align: 'left', formatter:function(row){
	                return  '<span class="eduType" val="'+ row.eduType+'">' + row.eduType+'</span>';
	            }
	            },
	            {field: 'is211', title: '211', width: 80, align: 'left', formatter:function(row){
	                return  '<span class="is211" val="'+ row.is211+'">' + row.is211+'</span>';
	            }
	            },
	            {field: 'is985', title: '985', width: 80, align: 'left', formatter:function(row){
	                return  '<span class="is985" val="'+ row.is985+'">' + row.is985+'</span>';
	            }
	            },
	            {field: 'graduateTime', title: '毕业时间', width: 80, align: 'left', formatter:function(row){
	                return  '<span class="graduateTime" val="'+ row.graduateTime+'">' + row.graduateTime+'</span>';
	            }
	            },
	            {field: 'graduateNum', title: '毕业人数', width: 80, align: 'left', formatter:function(row){
	                return  '<span class="graduateNum" val="'+ row.graduateNum+'">' + row.graduateNum+'</span>';
	            }
	            },
	            {field: 'employRate', title: "就业率", width: 100, align: 'left',sortable:true,formatter: function(row){
	                return '<span class="employRate" val="'+row.employRate+'">'+row.employRate+'%</span>';
	            }
	            },
	            {field: 'waitEmployRate', title: "待就业率", width: 100, align: 'left',sortable:true,formatter: function(row){
	                return '<span class="waitEmployRate" val="'+row.waitEmployRate+'">'+row.waitEmployRate+'%</span>';
	            }
	            },
	            {field: 'noEmployRate', title: "暂不就业率", width: 100, align: 'left',sortable:true,formatter: function(row){
	                return '<span class="noEmployRate" val="'+row.noEmployRate+'">'+row.noEmployRate+'%</span>';
	            }
	            }

	        ],

	        initCallback: function(self){
	            console.log('vectory');
	        },
	        ajaxCallback: function(data)
	        {
	            console.log('vectory');
	        }

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