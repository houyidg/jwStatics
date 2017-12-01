package cn.jeeweb.modules.shoppingmall.entity;

import cn.jeeweb.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import java.util.Date;

/**   
 * @Title: 手机型号
 * @Description: 手机型号
 * @author zhuxiao
 * @date 2017-10-25 12:55:40
 * @version V1.0   
 *
 */
@TableName("phonetype")
@SuppressWarnings("serial")
public class Phonetype extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**更新者*/
    @TableField(value = "update_by",fill = FieldFill.UPDATE)
	private String updateBy;
    /**更新时间*/
    @TableField(value = "update_date",fill = FieldFill.UPDATE)
	private Date updateDate;
    /**删除标记（0：正常；1：删除）*/
    @TableField(value = "del_flag")
	private String delFlag;
    /**备注信息*/
    @TableField(value = "remarks")
	private String remarks;
    /**手机型号*/
    @TableField(value = "name")
	private String name;
    /**价格*/
    @TableField(value = "price")
	private Double price;
    /**价格单位*/
    @TableField(value = "price_unit")
	private String priceUnit;
	
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
	 * 获取  updateBy
	 *@return: String  更新者
	 */
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 * 设置  updateBy
	 *@param: updateBy  更新者
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 * 获取  updateDate
	 *@return: Date  更新时间
	 */
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 * 设置  updateDate
	 *@param: updateDate  更新时间
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 * 获取  delFlag
	 *@return: String  删除标记（0：正常；1：删除）
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param: delFlag  删除标记（0：正常；1：删除）
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * 获取  remarks
	 *@return: String  备注信息
	 */
	public String getRemarks(){
		return this.remarks;
	}

	/**
	 * 设置  remarks
	 *@param: remarks  备注信息
	 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	/**
	 * 获取  name
	 *@return: String  手机型号
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param: name  手机型号
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  price
	 *@return: Double  价格
	 */
	public Double getPrice(){
		return this.price;
	}

	/**
	 * 设置  price
	 *@param: price  价格
	 */
	public void setPrice(Double price){
		this.price = price;
	}
	/**
	 * 获取  priceUnit
	 *@return: String  价格单位
	 */
	public String getPriceUnit(){
		return this.priceUnit;
	}

	/**
	 * 设置  priceUnit
	 *@param: priceUnit  价格单位
	 */
	public void setPriceUnit(String priceUnit){
		this.priceUnit = priceUnit;
	}
	
}