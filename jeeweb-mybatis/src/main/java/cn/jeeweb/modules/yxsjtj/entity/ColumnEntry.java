package cn.jeeweb.modules.yxsjtj.entity;

import java.io.Serializable;

public class ColumnEntry  extends ChartBaseEntry implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 522375644151981563L;
	public String type;
	public ColumnEntry(long value, String name) {
		super(value, name);
	}
	public ColumnEntry(long value, String name,String type) {
		super(value, name);
		this.type = type;
	}
	@Override
	public String toString() {
		return "ColumnEntry [type=" + type + ", value=" + value + ", name=" + name + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
