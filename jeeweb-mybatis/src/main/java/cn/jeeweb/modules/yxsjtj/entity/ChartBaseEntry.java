package cn.jeeweb.modules.yxsjtj.entity;

import java.io.Serializable;

public class ChartBaseEntry implements Serializable{
	public long value;
	public String name;
	public ChartBaseEntry() {}
	public ChartBaseEntry(long value, String name) {
		this.value = value;
		this.name = name;
	}
}
