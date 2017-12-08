package cn.jeeweb.modules.yxsjtj.entity;

public class JylColumn {
	public long count = 0;// 总人数
	public long jyrs = 0;// 就业人数
	public long djyrs = 0;// 待就业 70
	public long bjynsxrs = 0;// 不就业拟升学 71
	public long qtzbjyrs = 0;// 其他暂不就业 72
	//// 院校代码 院校名称 所在地 院校性质 隶属单位 办学类型 211 985 毕业时间 毕业人数
	public String yxdm;//
	public String yxmc;//
	public String yxszd;//
	public String yxxz;//
	public String yxlsdw;//
	public String yxbxlx;//
	public Short is211;//
	public Short is985;//
	public JylColumn() {
		super();
	}
	public JylColumn(String yxdm) {
		super();
		this.yxdm = yxdm;
	}

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
		JylColumn other = (JylColumn) obj;
		if (yxdm == null) {
			if (other.yxdm != null)
				return false;
		} else if (!yxdm.equals(other.yxdm))
			return false;
		return true;
	}

}
