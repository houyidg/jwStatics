package cn.jeeweb.modules.yxsjtj.entity;

public class JylEntry {
	/**
	 * 就业人数=毕业生总数-（待就业人数+不就业拟升学人数+其他暂不就业人数） 待就业人数 70 暂不就业人数=不就业拟升学人数+其他暂不就业人数 71+72
	 */
	public long count = 0;
	public long jyrs = 0;//就业人数
	public long djyrs = 0;//待就业 70
	public long bjynsxrs = 0;//不就业拟升学 71
	public long qtzbjyrs = 0;//其他暂不就业 72
}
