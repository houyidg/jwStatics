package cn.jeeweb.modules.yxsjtj.entity;

import cn.jeeweb.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

/**   
 * @Title: 学生管理
 * @Description: 学生表，包含很多属性
 * @author zx
 * @date 2017-10-29 02:17:03
 * @version V1.0   
 *
 */
@TableName("student")
@SuppressWarnings("serial")
public class Student extends AbstractEntity<String> {

    /**考生号*/
    @TableField(value = "ksh")
	private String ksh;
    /**毕业时间*/
    @TableField(value = "bysj")
	private String bysj;
    /**院校代码*/
    @TableField(value = "yxdm")
	private String yxdm;
    /**身份证*/
    @TableField(value = "sfzh")
	private String sfzh;
    /**姓名*/
    @TableField(value = "xm")
	private String xm;
    /**性别代码*/
    @TableField(value = "xbdm")
	private String xbdm;
    /**民族代码*/
    @TableField(value = "mzdm")
	private String mzdm;
    /**政治面貌代码*/
    @TableField(value = "zzmmdm")
	private String zzmmdm;
    /**学历代码*/
    @TableField(value = "xldm")
	private String xldm;
    /**专业代码*/
    @TableField(value = "zydm")
	private String zydm;
    /**专业*/
    @TableField(value = "zy")
	private String zy;
    /**专业方向*/
    @TableField(value = "zyfx")
	private String zyfx;
    /**培养方式代码*/
    @TableField(value = "pyfsdm")
	private String pyfsdm;
    /**生源所在地代码*/
    @TableField(value = "syszddm")
	private String syszddm;
    /**定向或委培单位*/
    @TableField(value = "dxhwpdw")
	private String dxhwpdw;
    /**学制*/
    @TableField(value = "xz")
	private String xz;
    /**入学时间*/
    @TableField(value = "rxsj")
	private String rxsj;
    /**困难生类别代码*/
    @TableField(value = "knslbdm")
	private String knslbdm;
    /**师范生类别代码*/
    @TableField(value = "sfslbdm")
	private String sfslbdm;
    /**毕业去向代码*/
    @TableField(value = "byqxdm")
	private String byqxdm;
    /**单位组织机构代码*/
    @TableField(value = "dwzzjgdm")
	private String dwzzjgdm;
    /**单位名称*/
    @TableField(value = "dwmc")
	private String dwmc;
    /**单位性质代码*/
    @TableField(value = "dwxzdm")
	private String dwxzdm;
    /**单位行业代码*/
    @TableField(value = "dwhydm")
	private String dwhydm;
    /**单位所在地代码*/
    @TableField(value = "dwszddm")
	private String dwszddm;
    /**工作职位类别代码*/
    @TableField(value = "gzzwlbdm")
	private String gzzwlbdm;
    /**报到证签发类别代码*/
    @TableField(value = "bdzqflbdm")
	private String bdzqflbdm;
    /**报到证签往单位名称*/
    @TableField(value = "bdzqwdwmc")
	private String bdzqwdwmc;
    /**签往单位所在地代码*/
    @TableField(value = "qwdwszddm")
	private String qwdwszddm;
    /**报到证编号*/
    @TableField(value = "bdzbh")
	private String bdzbh;
    /**报到起始时间*/
    @TableField(value = "bdqssj")
	private String bdqssj;
    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
	
	/**
	 * 获取  ksh
	 *@return: String  考生号
	 */
	public String getKsh(){
		return this.ksh;
	}

	/**
	 * 设置  ksh
	 *@param: ksh  考生号
	 */
	public void setKsh(String ksh){
		this.ksh = ksh;
	}
	/**
	 * 获取  bysj
	 *@return: String  毕业时间
	 */
	public String getBysj(){
		return this.bysj;
	}

	/**
	 * 设置  bysj
	 *@param: bysj  毕业时间
	 */
	public void setBysj(String bysj){
		this.bysj = bysj;
	}
	/**
	 * 获取  yxdm
	 *@return: String  院校代码
	 */
	public String getYxdm(){
		return this.yxdm;
	}

	/**
	 * 设置  yxdm
	 *@param: yxdm  院校代码
	 */
	public void setYxdm(String yxdm){
		this.yxdm = yxdm;
	}
	/**
	 * 获取  sfzh
	 *@return: String  身份证
	 */
	public String getSfzh(){
		return this.sfzh;
	}

	/**
	 * 设置  sfzh
	 *@param: sfzh  身份证
	 */
	public void setSfzh(String sfzh){
		this.sfzh = sfzh;
	}
	/**
	 * 获取  xm
	 *@return: String  姓名
	 */
	public String getXm(){
		return this.xm;
	}

	/**
	 * 设置  xm
	 *@param: xm  姓名
	 */
	public void setXm(String xm){
		this.xm = xm;
	}
	/**
	 * 获取  xbdm
	 *@return: String  性别代码
	 */
	public String getXbdm(){
		return this.xbdm;
	}

	/**
	 * 设置  xbdm
	 *@param: xbdm  性别代码
	 */
	public void setXbdm(String xbdm){
		this.xbdm = xbdm;
	}
	/**
	 * 获取  mzdm
	 *@return: String  民族代码
	 */
	public String getMzdm(){
		return this.mzdm;
	}

	/**
	 * 设置  mzdm
	 *@param: mzdm  民族代码
	 */
	public void setMzdm(String mzdm){
		this.mzdm = mzdm;
	}
	/**
	 * 获取  zzmmdm
	 *@return: String  政治面貌代码
	 */
	public String getZzmmdm(){
		return this.zzmmdm;
	}

	/**
	 * 设置  zzmmdm
	 *@param: zzmmdm  政治面貌代码
	 */
	public void setZzmmdm(String zzmmdm){
		this.zzmmdm = zzmmdm;
	}
	/**
	 * 获取  xldm
	 *@return: String  学历代码
	 */
	public String getXldm(){
		return this.xldm;
	}

	/**
	 * 设置  xldm
	 *@param: xldm  学历代码
	 */
	public void setXldm(String xldm){
		this.xldm = xldm;
	}
	/**
	 * 获取  zydm
	 *@return: String  专业代码
	 */
	public String getZydm(){
		return this.zydm;
	}

	/**
	 * 设置  zydm
	 *@param: zydm  专业代码
	 */
	public void setZydm(String zydm){
		this.zydm = zydm;
	}
	/**
	 * 获取  zy
	 *@return: String  专业
	 */
	public String getZy(){
		return this.zy;
	}

	/**
	 * 设置  zy
	 *@param: zy  专业
	 */
	public void setZy(String zy){
		this.zy = zy;
	}
	/**
	 * 获取  zyfx
	 *@return: String  专业方向
	 */
	public String getZyfx(){
		return this.zyfx;
	}

	/**
	 * 设置  zyfx
	 *@param: zyfx  专业方向
	 */
	public void setZyfx(String zyfx){
		this.zyfx = zyfx;
	}
	/**
	 * 获取  pyfsdm
	 *@return: String  培养方式代码
	 */
	public String getPyfsdm(){
		return this.pyfsdm;
	}

	/**
	 * 设置  pyfsdm
	 *@param: pyfsdm  培养方式代码
	 */
	public void setPyfsdm(String pyfsdm){
		this.pyfsdm = pyfsdm;
	}
	/**
	 * 获取  syszddm
	 *@return: String  生源所在地代码
	 */
	public String getSyszddm(){
		return this.syszddm;
	}

	/**
	 * 设置  syszddm
	 *@param: syszddm  生源所在地代码
	 */
	public void setSyszddm(String syszddm){
		this.syszddm = syszddm;
	}
	/**
	 * 获取  dxhwpdw
	 *@return: String  定向或委培单位
	 */
	public String getDxhwpdw(){
		return this.dxhwpdw;
	}

	/**
	 * 设置  dxhwpdw
	 *@param: dxhwpdw  定向或委培单位
	 */
	public void setDxhwpdw(String dxhwpdw){
		this.dxhwpdw = dxhwpdw;
	}
	/**
	 * 获取  xz
	 *@return: String  学制
	 */
	public String getXz(){
		return this.xz;
	}

	/**
	 * 设置  xz
	 *@param: xz  学制
	 */
	public void setXz(String xz){
		this.xz = xz;
	}
	/**
	 * 获取  rxsj
	 *@return: String  入学时间
	 */
	public String getRxsj(){
		return this.rxsj;
	}

	/**
	 * 设置  rxsj
	 *@param: rxsj  入学时间
	 */
	public void setRxsj(String rxsj){
		this.rxsj = rxsj;
	}
	/**
	 * 获取  knslbdm
	 *@return: String  困难生类别代码
	 */
	public String getKnslbdm(){
		return this.knslbdm;
	}

	/**
	 * 设置  knslbdm
	 *@param: knslbdm  困难生类别代码
	 */
	public void setKnslbdm(String knslbdm){
		this.knslbdm = knslbdm;
	}
	/**
	 * 获取  sfslbdm
	 *@return: String  师范生类别代码
	 */
	public String getSfslbdm(){
		return this.sfslbdm;
	}

	/**
	 * 设置  sfslbdm
	 *@param: sfslbdm  师范生类别代码
	 */
	public void setSfslbdm(String sfslbdm){
		this.sfslbdm = sfslbdm;
	}
	/**
	 * 获取  byqxdm
	 *@return: String  毕业去向代码
	 */
	public String getByqxdm(){
		return this.byqxdm;
	}

	/**
	 * 设置  byqxdm
	 *@param: byqxdm  毕业去向代码
	 */
	public void setByqxdm(String byqxdm){
		this.byqxdm = byqxdm;
	}
	/**
	 * 获取  dwzzjgdm
	 *@return: String  单位组织机构代码
	 */
	public String getDwzzjgdm(){
		return this.dwzzjgdm;
	}

	/**
	 * 设置  dwzzjgdm
	 *@param: dwzzjgdm  单位组织机构代码
	 */
	public void setDwzzjgdm(String dwzzjgdm){
		this.dwzzjgdm = dwzzjgdm;
	}
	/**
	 * 获取  dwmc
	 *@return: String  单位名称
	 */
	public String getDwmc(){
		return this.dwmc;
	}

	/**
	 * 设置  dwmc
	 *@param: dwmc  单位名称
	 */
	public void setDwmc(String dwmc){
		this.dwmc = dwmc;
	}
	/**
	 * 获取  dwxzdm
	 *@return: String  单位性质代码
	 */
	public String getDwxzdm(){
		return this.dwxzdm;
	}

	/**
	 * 设置  dwxzdm
	 *@param: dwxzdm  单位性质代码
	 */
	public void setDwxzdm(String dwxzdm){
		this.dwxzdm = dwxzdm;
	}
	/**
	 * 获取  dwhydm
	 *@return: String  单位行业代码
	 */
	public String getDwhydm(){
		return this.dwhydm;
	}

	/**
	 * 设置  dwhydm
	 *@param: dwhydm  单位行业代码
	 */
	public void setDwhydm(String dwhydm){
		this.dwhydm = dwhydm;
	}
	/**
	 * 获取  dwszddm
	 *@return: String  单位所在地代码
	 */
	public String getDwszddm(){
		return this.dwszddm;
	}

	/**
	 * 设置  dwszddm
	 *@param: dwszddm  单位所在地代码
	 */
	public void setDwszddm(String dwszddm){
		this.dwszddm = dwszddm;
	}
	/**
	 * 获取  gzzwlbdm
	 *@return: String  工作职位类别代码
	 */
	public String getGzzwlbdm(){
		return this.gzzwlbdm;
	}

	/**
	 * 设置  gzzwlbdm
	 *@param: gzzwlbdm  工作职位类别代码
	 */
	public void setGzzwlbdm(String gzzwlbdm){
		this.gzzwlbdm = gzzwlbdm;
	}
	/**
	 * 获取  bdzqflbdm
	 *@return: String  报到证签发类别代码
	 */
	public String getBdzqflbdm(){
		return this.bdzqflbdm;
	}

	/**
	 * 设置  bdzqflbdm
	 *@param: bdzqflbdm  报到证签发类别代码
	 */
	public void setBdzqflbdm(String bdzqflbdm){
		this.bdzqflbdm = bdzqflbdm;
	}
	/**
	 * 获取  bdzqwdwmc
	 *@return: String  报到证签往单位名称
	 */
	public String getBdzqwdwmc(){
		return this.bdzqwdwmc;
	}

	/**
	 * 设置  bdzqwdwmc
	 *@param: bdzqwdwmc  报到证签往单位名称
	 */
	public void setBdzqwdwmc(String bdzqwdwmc){
		this.bdzqwdwmc = bdzqwdwmc;
	}
	/**
	 * 获取  qwdwszddm
	 *@return: String  签往单位所在地代码
	 */
	public String getQwdwszddm(){
		return this.qwdwszddm;
	}

	/**
	 * 设置  qwdwszddm
	 *@param: qwdwszddm  签往单位所在地代码
	 */
	public void setQwdwszddm(String qwdwszddm){
		this.qwdwszddm = qwdwszddm;
	}
	/**
	 * 获取  bdzbh
	 *@return: String  报到证编号
	 */
	public String getBdzbh(){
		return this.bdzbh;
	}

	/**
	 * 设置  bdzbh
	 *@param: bdzbh  报到证编号
	 */
	public void setBdzbh(String bdzbh){
		this.bdzbh = bdzbh;
	}
	/**
	 * 获取  bdqssj
	 *@return: String  报到起始时间
	 */
	public String getBdqssj(){
		return this.bdqssj;
	}

	/**
	 * 设置  bdqssj
	 *@param: bdqssj  报到起始时间
	 */
	public void setBdqssj(String bdqssj){
		this.bdqssj = bdqssj;
	}
	/**
	 * 获取  id
	 *@return: String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  id
	 */
	public void setId(String id){
		this.id = id;
	}
	
}
