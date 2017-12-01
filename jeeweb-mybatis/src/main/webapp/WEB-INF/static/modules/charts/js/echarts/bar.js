$(function () {
    var barChart = echarts.init(document.getElementById("echarts-bar-chart"));
    var baroption = {
        title : {
            text: '某地区蒸发量和降水量'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            data:['蒸发量','降水量']
        },
//        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        label:{ 
        	normal:{ 
        	show: true, 
        	position: 'top'} 
        	},
        series : [
            {
                name:'蒸发量',
                type:'bar',
                data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
            },
            {
                name:'降水量',
                type:'bar',
                data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
            }
        ]
    };
    barChart.setOption(baroption);

    window.onresize = barChart.resize;

   

});
