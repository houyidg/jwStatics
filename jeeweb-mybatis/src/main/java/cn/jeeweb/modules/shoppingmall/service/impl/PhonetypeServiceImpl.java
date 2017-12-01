package cn.jeeweb.modules.shoppingmall.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.core.query.wrapper.EntityWrapper;
import cn.jeeweb.modules.shoppingmall.mapper.PhonetypeMapper;
import cn.jeeweb.modules.shoppingmall.entity.Phonetype;
import cn.jeeweb.modules.shoppingmall.service.IPhonetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.jeeweb.core.utils.ServletUtils;
import cn.jeeweb.core.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringEscapeUtils;

/**   
 * @Title: 手机型号
 * @Description: 手机型号
 * @author zhuxiao
 * @date 2017-10-25 12:55:40
 * @version V1.0   
 *
 */
@Transactional
@Service("phonetypeService")
public class PhonetypeServiceImpl  extends CommonServiceImpl<PhonetypeMapper,Phonetype> implements  IPhonetypeService {
	
	@Override
	public boolean insert(Phonetype phonetype) {
		// 保存主表
		super.insert(phonetype);
		return true;
	}
	
	@Override
	public boolean insertOrUpdate(Phonetype phonetype) {
		try {
			// 更新主表
			super.insertOrUpdate(phonetype);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return true;
	}
	
	
	
}
