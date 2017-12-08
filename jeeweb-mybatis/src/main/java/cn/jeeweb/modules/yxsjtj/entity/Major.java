package cn.jeeweb.modules.yxsjtj.entity;

import cn.jeeweb.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;

/**   
 * @Title: 专业
 * @Description: 专业
 * @author xiaoming
 * @date 2017-12-07 22:23:04
 * @version V1.0   
 *
 */
@TableName("major")
@SuppressWarnings("serial")
public class Major extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**学历代码*/
    @TableField(value = "xldm")
	private String xldm;
    /**专业代码*/
    @TableField(value = "zydm")
	private String zydm;
    /**专业名称*/
    @TableField(value = "zymc")
	private String zymc;
	
	/**
	 * 获取  id
	 *@return: String  字段主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  字段主键
	 */
	public void setId(String id){
		this.id = id;
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
	 * 获取  zymc
	 *@return: String  专业名称
	 */
	public String getZymc(){
		return this.zymc;
	}

	/**
	 * 设置  zymc
	 *@param: zymc  专业名称
	 */
	public void setZymc(String zymc){
		this.zymc = zymc;
	}
	
}
