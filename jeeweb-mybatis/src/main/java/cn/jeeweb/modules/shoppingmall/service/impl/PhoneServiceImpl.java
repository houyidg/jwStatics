package cn.jeeweb.modules.shoppingmall.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.shoppingmall.mapper.PhoneMapper;
import cn.jeeweb.modules.shoppingmall.entity.Phone;
import cn.jeeweb.modules.shoppingmall.service.IPhoneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 预订的手机
 * @Description: 预订的手机
 * @author jeeweb
 * @date 2017-10-25 13:53:17
 * @version V1.0   
 *
 */
@Transactional
@Service("phoneService")
public class PhoneServiceImpl  extends CommonServiceImpl<PhoneMapper,Phone> implements  IPhoneService {

}
