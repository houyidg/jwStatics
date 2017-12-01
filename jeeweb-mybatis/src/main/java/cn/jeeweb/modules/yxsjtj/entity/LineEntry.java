package cn.jeeweb.modules.yxsjtj.entity;

import java.io.Serializable;

public class LineEntry  extends ChartBaseEntry implements Serializable{
	private static final long serialVersionUID = 3890330092640228852L;
	public String bysj;
	public String type;
	public LineEntry(long value, String name,String type) {
		super(value,name);
		this.type = type;
	}
}
