/**
 * Created by cm on 2017/10/20.
 */
var actiontype = "jyqsfx";
$(function() {
	init();
	// 点击选择确定
	$("#sure").click(
			function() {
				// <!--universityid featureid belongto startDate endDate typeid
				// areaid byqxdms byqxdm -->
				var CArea = $("#CArea .fixedId").val();
				var CFeature = $("#CFeature .fixedId").val();
				var CBelongto = $("#CBelongto .fixedId").val();
				var CType = $("#CType .fixedId").val();
				var CName = $("#CName .fixedId").val();
				var CQx = $("#CQx .fixedId").val();
				// alert(CArea + "," + CFeature + "," + CBelongto + "," + CType+
				// "," + CName+','+start_time);
				var newUrl = realBaseUrl + "/ajaxChartList";
				var arg = "actiontype="+actiontype+"&areaid=" + CArea + "&featureid="
						+ CFeature + "&belongto=" + CBelongto + "&typeid="
						+ CType+"&yxdms="+CName+"&byqxdms="+CQx;
				newUrl += "?" + arg;

				$.ajax({
					url : newUrl,
					dataType : 'json',
					type : 'GET',
					success : function(data) {
						console.log('ajaxChartList:', data);
						generateChart(data);
					}
				});

			});
});
// 初始化
// 你看一下初始化的传值是传空的还是怎么的
// 下拉列表（院校所在州市列表）+下拉列表（院校性质列表）+下拉列表（隶属单位）+下拉列表（办学类型）+ 下拉列表（院校列表）
function init() {
	var url_1 = realBaseUrl + "/ajaxPropertyList";
	initChose("CQx", url_1, 'type=bysqx');
	initChose("CArea", url_1, 'type=yxszd');
	initChose("CFeature", url_1, 'type=yxxz');
	initChose("CBelongto", url_1, 'type=lsdw');
	initChose("CType", url_1, 'type=bxlx');
	initChose("CName", url_1, 'type=yxmc');
	initChose("CZy", url_1, 'type=zy');
}
function parseParamsInitChose(idname,id, name, _self) {
	if (idname != "CName" && idname != "CZy") {
		var CQx = $("#CQx .fixedId").val();
		var CArea = $("#CArea .fixedId").val();
		var CFeature = $("#CFeature .fixedId").val();
		var CBelongto = $("#CBelongto .fixedId").val();
		var CType = $("#CType .fixedId").val();
		var newUrl = realBaseUrl + "/ajaxPropertyList";
		var arg = "type=yxmc&areaid=" + CArea
				+ "&featureid=" + CFeature
				+ "&belongto=" + CBelongto 
				+ "&typeid=" + CType
				+ "&bysqx=" + CQx;
		initChose("CName", newUrl, arg);
	}if (idname == "CName") {
		var CName = $("#CName .fixedId").val();
		var newUrl = realBaseUrl + "/ajaxPropertyList";
		var arg = "type=zy&yxdms=" + CName;
		initChose("CZy", newUrl, arg);
	}
}
function initChose(idname, url, param) {
	url += "?" + param;
	console.log(idname, url)
	$.ajax({
		url : url,
		dataType : 'json',
		type : 'GET',
		success : function(data) {
			console.log('initChose:', data);
			generateChosen(idname,data);
		}
	});
}

function generateChosen(sid,data){
	$("#" + sid).Chosen(
			{
				data : data, // 数据
				chosenWidth : 200, // 选择框宽度
				dataListWidth : 200, // 下拉框的宽度
				dataListHeight : 500, // 下拉框的高度
				placeholderTxt : '全部', // 初始化提示文字
				searchOpt : true,
				multi : true,
				maxSize : 5,
				joinChar : ',',
				clearOpt:true,
				removeCallback : (id, name, _self)=>{
					parseParamsInitChose(sid,id, name, _self);
				},
				selectedCallback :  (id, name, _self)=>{
					parseParamsInitChose(sid,id, name, _self);
				}
			});
}

function generateChart (data) {
	 var xData=[];var yData=[];
	 for (var index in data) {
		 xData.push(data[index].name);
		 yData.push(data[index].value);
	 }
	 var lineChart = echarts.init(document.getElementById("echarts-line-chart"));
	    var lineoption = {
	        title : {
	            text: '就业趋势分析'
	        },
	        tooltip : {
	            trigger: 'axis'
	        },
	        legend: {
	            data:['就业趋势分析']
	        },
	        xAxis : [
	            {
	                type : 'category',
	                data : xData
	            }
	        ],
	        yAxis : [
	            {
	                type : 'value',
	                axisLabel : {
	                    formatter: '{value}'
	                }
	            }
	        ],
	        series : [
	            {
	                name:'就业趋势分析',
	                type:'line',
	                data:yData
	            }
	        ]
	    };
	    lineChart.setOption(lineoption);
	    $(window).resize(lineChart.resize);
}

