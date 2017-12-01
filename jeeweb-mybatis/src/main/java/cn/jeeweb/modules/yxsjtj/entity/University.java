package cn.jeeweb.modules.yxsjtj.entity;

import cn.jeeweb.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

/**   
 * @Title: 院校管理
 * @Description: 院校表，包含属性：院校代码	院校名称	所在地	所在地市州	院校性质	隶属单位	办学类型	is211	is985	独立学院	新增本科	示范高职	科研机构	民办院校	培养专科	培养本科	培养硕士	培养博士
 * @author zx
 * @date 2017-10-29 20:19:45
 * @version V1.0   
 *
 */
@TableName("university")
@SuppressWarnings("serial")
public class University extends AbstractEntity<String> {

    /**院校代码*/
    @TableField(value = "number")
	private String number;
    /**院校名称*/
    @TableField(value = "name")
	private String name;
    /**所在地市州*/
    @TableField(value = "areaid")
	private String areaid;
    /**院校性质*/
    @TableField(value = "featureid")
	private String featureid;
    /**隶属单位*/
    @TableField(value = "belongto")
	private String belongto;
    /**办学类型*/
    @TableField(value = "typeid")
	private String typeid;
    /**211工程*/
    @TableField(value = "is211")
	private Short is211;
    /**985工程*/
    @TableField(value = "is985")
	private Short is985;
    /**独立学院*/
    @TableField(value = "isindependent")
	private Short isindependent;
    /**新增本科*/
    @TableField(value = "isnewbk")
	private Short isnewbk;
    /**示范高职*/
    @TableField(value = "issfgz")
	private Short issfgz;
    /**科研机构*/
    @TableField(value = "iskyjg")
	private Short iskyjg;
    /**民办院校*/
    @TableField(value = "ismbyx")
	private Short ismbyx;
    /**培养专科*/
    @TableField(value = "ispyzk")
	private Short ispyzk;
    /**培养本科*/
    @TableField(value = "ispybk")
	private Short ispybk;
    /**培养硕士*/
    @TableField(value = "ispyss")
	private Short ispyss;
    /**培养博士*/
    @TableField(value = "ispybs")
	private Short ispybs;
    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**所在地*/
    @TableField(value = "provinceid")
	private String provinceid;
	
	/**
	 * 获取  number
	 *@return: String  院校代码
	 */
	public String getNumber(){
		return this.number;
	}

	/**
	 * 设置  number
	 *@param: number  院校代码
	 */
	public void setNumber(String number){
		this.number = number;
	}
	/**
	 * 获取  name
	 *@return: String  院校名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param: name  院校名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  areaid
	 *@return: String  所在地市州
	 */
	public String getAreaid(){
		return this.areaid;
	}

	/**
	 * 设置  areaid
	 *@param: areaid  所在地市州
	 */
	public void setAreaid(String areaid){
		this.areaid = areaid;
	}
	/**
	 * 获取  featureid
	 *@return: String  院校性质
	 */
	public String getFeatureid(){
		return this.featureid;
	}

	/**
	 * 设置  featureid
	 *@param: featureid  院校性质
	 */
	public void setFeatureid(String featureid){
		this.featureid = featureid;
	}
	/**
	 * 获取  belongto
	 *@return: String  隶属单位
	 */
	public String getBelongto(){
		return this.belongto;
	}

	/**
	 * 设置  belongto
	 *@param: belongto  隶属单位
	 */
	public void setBelongto(String belongto){
		this.belongto = belongto;
	}
	/**
	 * 获取  typeid
	 *@return: String  办学类型
	 */
	public String getTypeid(){
		return this.typeid;
	}

	/**
	 * 设置  typeid
	 *@param: typeid  办学类型
	 */
	public void setTypeid(String typeid){
		this.typeid = typeid;
	}
	/**
	 * 获取  is211
	 *@return: Short  211工程
	 */
	public Short getIs211(){
		return this.is211;
	}

	/**
	 * 设置  is211
	 *@param: is211  211工程
	 */
	public void setIs211(Short is211){
		this.is211 = is211;
	}
	/**
	 * 获取  is985
	 *@return: Short  985工程
	 */
	public Short getIs985(){
		return this.is985;
	}

	/**
	 * 设置  is985
	 *@param: is985  985工程
	 */
	public void setIs985(Short is985){
		this.is985 = is985;
	}
	/**
	 * 获取  isindependent
	 *@return: Short  独立学院
	 */
	public Short getIsindependent(){
		return this.isindependent;
	}

	/**
	 * 设置  isindependent
	 *@param: isindependent  独立学院
	 */
	public void setIsindependent(Short isindependent){
		this.isindependent = isindependent;
	}
	/**
	 * 获取  isnewbk
	 *@return: Short  新增本科
	 */
	public Short getIsnewbk(){
		return this.isnewbk;
	}

	/**
	 * 设置  isnewbk
	 *@param: isnewbk  新增本科
	 */
	public void setIsnewbk(Short isnewbk){
		this.isnewbk = isnewbk;
	}
	/**
	 * 获取  issfgz
	 *@return: Short  示范高职
	 */
	public Short getIssfgz(){
		return this.issfgz;
	}

	/**
	 * 设置  issfgz
	 *@param: issfgz  示范高职
	 */
	public void setIssfgz(Short issfgz){
		this.issfgz = issfgz;
	}
	/**
	 * 获取  iskyjg
	 *@return: Short  科研机构
	 */
	public Short getIskyjg(){
		return this.iskyjg;
	}

	/**
	 * 设置  iskyjg
	 *@param: iskyjg  科研机构
	 */
	public void setIskyjg(Short iskyjg){
		this.iskyjg = iskyjg;
	}
	/**
	 * 获取  ismbyx
	 *@return: Short  民办院校
	 */
	public Short getIsmbyx(){
		return this.ismbyx;
	}

	/**
	 * 设置  ismbyx
	 *@param: ismbyx  民办院校
	 */
	public void setIsmbyx(Short ismbyx){
		this.ismbyx = ismbyx;
	}
	/**
	 * 获取  ispyzk
	 *@return: Short  培养专科
	 */
	public Short getIspyzk(){
		return this.ispyzk;
	}

	/**
	 * 设置  ispyzk
	 *@param: ispyzk  培养专科
	 */
	public void setIspyzk(Short ispyzk){
		this.ispyzk = ispyzk;
	}
	/**
	 * 获取  ispybk
	 *@return: Short  培养本科
	 */
	public Short getIspybk(){
		return this.ispybk;
	}

	/**
	 * 设置  ispybk
	 *@param: ispybk  培养本科
	 */
	public void setIspybk(Short ispybk){
		this.ispybk = ispybk;
	}
	/**
	 * 获取  ispyss
	 *@return: Short  培养硕士
	 */
	public Short getIspyss(){
		return this.ispyss;
	}

	/**
	 * 设置  ispyss
	 *@param: ispyss  培养硕士
	 */
	public void setIspyss(Short ispyss){
		this.ispyss = ispyss;
	}
	/**
	 * 获取  ispybs
	 *@return: Short  培养博士
	 */
	public Short getIspybs(){
		return this.ispybs;
	}

	/**
	 * 设置  ispybs
	 *@param: ispybs  培养博士
	 */
	public void setIspybs(Short ispybs){
		this.ispybs = ispybs;
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
	/**
	 * 获取  provinceid
	 *@return: String  所在地
	 */
	public String getProvinceid(){
		return this.provinceid;
	}

	/**
	 * 设置  provinceid
	 *@param: provinceid  所在地
	 */
	public void setProvinceid(String provinceid){
		this.provinceid = provinceid;
	}
	
}
