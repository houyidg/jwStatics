/**
 * Created by cm on 2017/10/20.
 */
var start_time, end_time;
$(function() {
	init();
	$("#reset").click(function() {
		init();
	});
	// 点击选择确定
	$("#sure").click(
			function() {
				$("#l-wrapper").show();//显示div  
				// <!--universityid featureid belongto startDate endDate typeid
				// areaid byqxdms byqxdm -->
				start_time = $("#startTime").val();
				start_time = start_time != "" ? start_time + "00" : "";
				end_time = $("#endTime").val();
				end_time = end_time != "" ? end_time + "12" : "";
				var CArea = $("#CArea .fixedId").val();
				var CFeature = $("#CFeature .fixedId").val();
				var CBelongto = $("#CBelongto .fixedId").val();
				var CType = $("#CType .fixedId").val();
				var CName = $("#CName .fixedId").val();
				var CZy = $("#CZy .fixedId").val();
				// alert(CArea + "," + CFeature + "," + CBelongto + "," + CType+
				// "," + CName+','+start_time);
				var newUrl = realBaseUrl + "/ajaxChartList";
				var arg = "actiontype=" + actiontype + "&areaid=" + CArea
						+ "&featureid=" + CFeature + "&belongto=" + CBelongto
						+ "&typeid=" + CType + "&yxdms=" + CName+"&zy="+CZy
						+ "&startDate=" + start_time + "&endDate=" + end_time;
				newUrl += "?" + arg;
				$.ajax({
					url : newUrl,
					dataType : 'json',
					type : 'GET',
					success : function(data) {
						$("#l-wrapper").hide();//显示div  
						console.log('newUrl ajaxChartList:', data);
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
	initChose("CArea", url_1, 'type=yxszd');
	initChose("CFeature", url_1, 'type=yxxz');
	initChose("CBelongto", url_1, 'type=lsdw');
	initChose("CType", url_1, 'type=bxlx');
	initChose("CName", url_1, 'type=yxmc');
	initChose("CZy", url_1, 'type=zy');
}
function parseParamsInitChose(idname, id, name, _self) {
	if (idname != "CName" && idname != "CZy") {
		var CQx = $("#CQx .fixedId").val();
		var CArea = $("#CArea .fixedId").val();
		var CFeature = $("#CFeature .fixedId").val();
		var CBelongto = $("#CBelongto .fixedId").val();
		var CType = $("#CType .fixedId").val();
		var newUrl = realBaseUrl + "/ajaxPropertyList";
		var arg = "type=yxmc&areaid=" + CArea + "&featureid=" + CFeature
				+ "&belongto=" + CBelongto + "&typeid=" + CType + "&bysqx="
				+ CQx;
		initChose("CName", newUrl, arg);
	}
	
}
function initChose(idname, url, param) {
	url += "?" + param;
	$.ajax({
		url : url,
		dataType : 'json',
		type : 'GET',
		success : function(data) {
			generateChosen(idname, data);
		}
	});
}

function generateChosen(sid, data) {
	$("#" + sid).Chosen({
		data : data, // 数据
		chosenWidth : 200, // 选择框宽度
		dataListWidth : 200, // 下拉框的宽度
		dataListHeight : 500, // 下拉框的高度
		placeholderTxt : '全部', // 初始化提示文字
		searchOpt : true,
		multi :sid=="CZy"?false:true,
		maxSize : 5,
		joinChar : ',',
		clearOpt : true,
		removeCallback : function(id, name, _self) {
			console.log('removeCallback');
			parseParamsInitChose(sid, id, name, _self);
		},
		clearOptCallback: function(id, name, _self) {
			console.log('clearOptCallback');
			parseParamsInitChose(sid, id, name, _self);
		},
		selectedCallback : function(id, name, _self) {
			console.log('selectedCallback');
			parseParamsInitChose(sid, id, name, _self);
		}
	});
}
