/**
 * Created by cm on 2017/10/20.
 */
var actiontype = "jyqsfx";
$(function() {
	
	init();
	
	$("#reset").click(function() {
		init();
		if($("#is985").hasClass('checked')){
			$("#is985").removeClass('checked').addClass('uncheck');
		}
		if($("#is211").hasClass('checked')){
			$("#is211").removeClass('checked').addClass('uncheck');
		}
	});
	
	// 点击选择确定
	$("#sure").click(
	function() {
		$("#l-wrapper").show();//显示div  
		// <!--universityid featureid belongto startDate endDate typeid
		// areaid byqxdms byqxdm -->
		var CArea = $("#CArea .fixedId").val();
		var CFeature = $("#CFeature .fixedId").val();
		var CBelongto = $("#CBelongto .fixedId").val();
		var CType = $("#CType .fixedId").val();
		var CName = $("#CName .fixedId").val();
		var CQx = $("#CQx .fixedId").val();
		var CZy = $("#CZy .fixedId").val();
		var is985 = $("#is985").hasClass('checked')?1:'';
		var is211 = $("#is211").hasClass('checked')?1:'';
		// alert(CArea + "," + CFeature + "," + CBelongto + "," + CType+
		// "," + CName+','+start_time);
		var newUrl = realBaseUrl + "/ajaxChartList";
		var arg = "actiontype="+actiontype+"&areaid=" + CArea + "&featureid="
				+ CFeature + "&belongto=" + CBelongto + "&typeid="
				+ CType+"&yxdms="+CName+"&byqxdms="+CQx+"&zy="+CZy+"&is211="+is211
				+"&is985="+is985;
		newUrl += "?" + arg;
		console.log('newUrl',newUrl);
		$.ajax({
			url : newUrl,
			dataType : 'json',
			type : 'GET',
			success : function(data) {
				$("#l-wrapper").hide();//显示div  
				console.log('ajax:', data);
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

function loadCNameByOther(){
	var CQx = $("#CQx .fixedId").val();
	var CArea = $("#CArea .fixedId").val();
	var CFeature = $("#CFeature .fixedId").val();
	var CBelongto = $("#CBelongto .fixedId").val();
	var CType = $("#CType .fixedId").val();
	var is985 = $("#is985").hasClass('checked')?1:'';
	var is211 = $("#is211").hasClass('checked')?1:'';
	var newUrl = realBaseUrl + "/ajaxPropertyList";
	var arg = "type=yxmc&areaid=" + CArea
			+ "&featureid=" + CFeature
			+ "&belongto=" + CBelongto 
			+ "&typeid=" + CType
			+ "&bysqx=" + CQx
			+"&is211="+is211
			+"&is985="+is985;
	initChose("CName", newUrl, arg);
}
function parseParamsInitChose(idname,id, name, _self) {
	if (idname != "CName" && idname != "CZy") {
		loadCNameByOther();
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
		multi :sid=="CZy"?false:true,
		maxSize : 5,
		joinChar : ',',
		clearOpt:true,
		removeCallback :function (id, name, _self){
			parseParamsInitChose(sid,id, name, _self);
		},
		selectedCallback :function(id, name, _self){
			parseParamsInitChose(sid,id, name, _self);
		}
	});
}

/**
 *    legend: {
            data:['最高气温','最低气温']
        },
        xAxis : [
            {
                type : 'category',
                data : ['周一','周二','周三','周四','周五','周六','周日']
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel : {
                    formatter: '{value} °C'
                }
            }
        ],
 *    series : [
            {
                name:'最高气温',
                type:'line',
                data:[11, 11, 15, 13, 12, 13, 10]
            },
            {
                name:'最低气温',
                type:'line',
                data:[1, -2, 2, 5, 3, 2, 0],
            }
        ]
 * @param data
 * @returns
 */
function generateChart (data) {
 var xData = new Array();  ;//bysj
 var legend=[];//yxmc
 var series=[];
 var bysjIndx=0;
 console.log('generateChart data:',data.length);
 for (var index=0,len = data.length;index<len;index++) {
	var element = data[index];
	var innerData = element.entrys;
	legend[index] = element.yxmc;
	series[index] = {name:element.yxmc, type:'line',data:[],itemStyle:{ normal: {label : {show: true}}}};
	for(var dex=0,ilen = innerData.length;dex<ilen;dex++){
		var iElement = innerData[dex];
		if($.inArray(iElement.name, xData)==-1){
			xData[bysjIndx++] = iElement.name;
		}
		series[index].data[dex] = iElement.value;
	};
 }
 xData = xData.sort();
 console.log('generateChart xData:',xData,'legend:',legend,"series:",series);
 var lineChart = echarts.init(document.getElementById("echarts-line-chart"));
    var lineoption = {
        title : {
            text: '就业趋势分析'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:legend
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
        series :series
    };
    lineChart.setOption(lineoption,true);
    $(window).resize(lineChart.resize);
}

