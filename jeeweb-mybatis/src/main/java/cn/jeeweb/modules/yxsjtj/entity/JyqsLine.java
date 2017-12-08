package cn.jeeweb.modules.yxsjtj.entity;

import java.util.ArrayList;
import java.util.List;

public class JyqsLine {
	public List<Entry> entrys = new ArrayList<>();
	public String yxmc;//
	public String yxdm;//
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((yxdm == null) ? 0 : yxdm.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JyqsLine other = (JyqsLine) obj;
		if (yxdm == null) {
			if (other.yxdm != null)
				return false;
		} else if (!yxdm.equals(other.yxdm))
			return false;
		return true;
	}
	public JyqsLine(String yxdm) {
		super();
		this.yxdm = yxdm;
	}
	public class Entry{
		public String name;
		public long value;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		public Entry(String name, long value) {
			super();
			this.name = name;
			this.value = value;
		}
	}
}
