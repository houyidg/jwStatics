package cn.jeeweb.modules.yxsjtj.entity;

import java.io.Serializable;

public class ChartModel implements Serializable {
	private static final long serialVersionUID = -2434038091805004508L;
	public class Legend {
		public String[] data;

		public Legend(String[] data) {
			super();
			this.data = data;
		}
		
	}

	public class Tooltip {
		public String trigger = "axis";
		public String formatter;
		public Tooltip(String trigger, String formatter) {
			super();
			this.trigger = trigger;
			this.formatter = formatter;
		}
		
	}
	
	public enum ChartType {
		pie(1), bar(2), line(3);
		private int value;
		// 构造方法
		private ChartType(int index) {
			this.value = index;
		}
	}
	
	public class xAxis {
		public String type = "category";
		public String[] data;
		public xAxis(String type, String[] data) {
			super();
			this.type = type;
			this.data = data;
		}
		
	}
	
	public class yAxis {
		public String type = "value";

		public yAxis(String type) {
			super();
			this.type = type;
		}
		
	}
	
	public class label {
		public normal normal;
		class normal {
			public boolean show;
			public String position;
			public String formatter;
			public normal(boolean show, String position, String formatter) {
				super();
				this.show = show;
				this.position = position;
				this.formatter = formatter;
			}
			
		}
		public label(boolean show, String position, String formatter) {
			super();
			this.normal = new normal(show, position, formatter);
		}
		
	}
	public class Serie {
		public String name;
		public String type;
		public String[] data;
		public Serie(String name, String type, String[] data) {
			super();
			this.name = name;
			this.type = type;
			this.data = data;
		}
		
	}
	
	public class Title{
		public String text;
		public String x="center";
		public Title(String text, String x) {
			this.text = text;
			this.x = x;
		}
		
	}
	private ChartType chartType;
	private boolean isSuccess;
	private Title title;
	private Tooltip tooltip;
	private label label;
	private Legend legend;
	private xAxis[] xAxis;
	private yAxis[] yAxis;
	private Serie[] series;
	public ChartType getChartType() {
		return chartType;
	}
	public void setChartType(ChartType chartType) {
		this.chartType = chartType;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Tooltip getTooltip() {
		return tooltip;
	}
	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}
	public label getLabel() {
		return label;
	}
	public void setLabel(label label) {
		this.label = label;
	}
	public Legend getLegend() {
		return legend;
	}
	public void setLegend(Legend legend) {
		this.legend = legend;
	}
	public xAxis[] getxAxis() {
		return xAxis;
	}
	public void setxAxis(xAxis[] xAxis) {
		this.xAxis = xAxis;
	}
	public yAxis[] getyAxis() {
		return yAxis;
	}
	public void setyAxis(yAxis[] yAxis) {
		this.yAxis = yAxis;
	}
	public Serie[] getSeries() {
		return series;
	}
	public void setSeries(Serie[] series) {
		this.series = series;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	
}
