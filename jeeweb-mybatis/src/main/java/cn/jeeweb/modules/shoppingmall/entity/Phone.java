package cn.jeeweb.modules.shoppingmall.entity;

import cn.jeeweb.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import java.util.Date;

/**   
 * @Title: 预订的手机
 * @Description: 预订的手机
 * @author jeeweb
 * @date 2017-10-25 13:53:17
 * @version V1.0   
 *
 */
@TableName("phone")
@SuppressWarnings("serial")
public class Phone extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**创建者*/
    @TableField(value = "create_by",fill = FieldFill.INSERT)
	private String createBy;
    /**创建时间*/
    @TableField(value = "create_date",fill = FieldFill.INSERT)
	private Date createDate;
    /**删除标记（0：正常；1：删除）*/
    @TableField(value = "del_flag")
	private String delFlag;
    /**备注信息*/
    @TableField(value = "remarks")
	private String remarks;
    /**预订人*/
    @TableField(value = "booke_name")
	private String bookeName;
    /**预订日期*/
    @TableField(value = "book_date")
	private Date bookDate;
    /**预订价格*/
    @TableField(value = "book_price")
	private Double bookPrice;
    /**预订数量*/
    @TableField(value = "book_count")
	private Integer bookCount;
    /**预订手机类型id*/
    @TableField(value = "phone_type_id")
	private String phoneTypeId;
	
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
	 * 获取  createBy
	 *@return: String  创建者
	 */
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 * 设置  createBy
	 *@param: createBy  创建者
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 * 获取  createDate
	 *@return: Date  创建时间
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 * 设置  createDate
	 *@param: createDate  创建时间
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
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
	 * 获取  bookeName
	 *@return: String  预订人
	 */
	public String getBookeName(){
		return this.bookeName;
	}

	/**
	 * 设置  bookeName
	 *@param: bookeName  预订人
	 */
	public void setBookeName(String bookeName){
		this.bookeName = bookeName;
	}
	/**
	 * 获取  bookDate
	 *@return: Date  预订日期
	 */
	public Date getBookDate(){
		return this.bookDate;
	}

	/**
	 * 设置  bookDate
	 *@param: bookDate  预订日期
	 */
	public void setBookDate(Date bookDate){
		this.bookDate = bookDate;
	}
	/**
	 * 获取  bookPrice
	 *@return: Double  预订价格
	 */
	public Double getBookPrice(){
		return this.bookPrice;
	}

	/**
	 * 设置  bookPrice
	 *@param: bookPrice  预订价格
	 */
	public void setBookPrice(Double bookPrice){
		this.bookPrice = bookPrice;
	}
	/**
	 * 获取  bookCount
	 *@return: Integer  预订数量
	 */
	public Integer getBookCount(){
		return this.bookCount;
	}

	/**
	 * 设置  bookCount
	 *@param: bookCount  预订数量
	 */
	public void setBookCount(Integer bookCount){
		this.bookCount = bookCount;
	}
	/**
	 * 获取  phoneTypeId
	 *@return: String  预订手机类型id
	 */
	public String getPhoneTypeId(){
		return this.phoneTypeId;
	}

	/**
	 * 设置  phoneTypeId
	 *@param: phoneTypeId  预订手机类型id
	 */
	public void setPhoneTypeId(String phoneTypeId){
		this.phoneTypeId = phoneTypeId;
	}
	
}
