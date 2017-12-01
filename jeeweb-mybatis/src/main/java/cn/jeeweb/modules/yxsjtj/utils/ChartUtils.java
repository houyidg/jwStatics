package cn.jeeweb.modules.yxsjtj.utils;

import java.util.Map;
import java.util.Set;

import cn.jeeweb.modules.sys.Constants;
import cn.jeeweb.modules.sys.utils.DictUtils;
import cn.jeeweb.modules.yxsjtj.entity.ChartModel;
import cn.jeeweb.modules.yxsjtj.entity.ChartModel.Title;

public class ChartUtils {
	/**
	 *  title : {
	            text: '某站点用户访问来源',
	            subtext: '纯属虚构',
	            x:'center'
	        },
	        tooltip : {
	            trigger: 'item',
	            formatter: "{a} <br/>{b} : {c} ({d}%)"
	        },
	        legend: {
	            orient : 'vertical',
	            x : 'left',
	            data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
	        },
	        label: {
                normal: {
                    show: true,
                    formatter: '{b}: {c}({d}%)'
                }
            },
	        calculable : true,
	        series : [
	            {
	            	
	                name:'访问来源',
	                type:'pie',
	                data:[
	                    {value:335, name:'直接访问'},
	                    {value:310, name:'邮件营销'},
	                    {value:234, name:'联盟广告'},
	                    {value:135, name:'视频广告'},
	                    {value:1548, name:'搜索引擎'}
	                ]
	            }
	        ]
	 * @param dataList 
	 * @return
	 */
//	public static ChartModel generate(Map<String, Object> dataList) {
//		 Set<java.util.Map.Entry<String,Object>> entrySet = dataList.entrySet();
//		 String[] lData=new String[entrySet.size()];
//		 String[] lData=new Dta[entrySet.size()];
//		 int i=0;
//	     for(java.util.Map.Entry<String,Object> entry:entrySet) {
//	    	 String key = entry.getKey();
//	    	 String label = DictUtils.getDictLabel(key, Constants.BYQXDM, "sf");
//	    	 String value = (String) entry.getValue();
//	    	lData[i++] = label; 
//	     }
//		ChartModel chartModel = new ChartModel();
//		chartModel.setTitle(chartModel.new Title("毕业去向", "center"));
//		chartModel.setTooltip(chartModel.new Tooltip("item", "{a} <br/>{b} : {c} ({d}%)"));
//		chartModel.setLegend(chartModel.new Legend("vertical","left",));
//		//chartModel.new label(true, "center", "{b}: {c}({d}%)")
//		return chartModel; 
//	}
}
