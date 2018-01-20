package cn.jeeweb.modules.yxsjtj.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.yxsjtj.mapper.MajorMapper;
import cn.jeeweb.modules.sys.entity.Dict;
import cn.jeeweb.modules.sys.utils.DictUtils;
import cn.jeeweb.modules.yxsjtj.entity.Major;
import cn.jeeweb.modules.yxsjtj.entity.University;
import cn.jeeweb.modules.yxsjtj.service.IMajorService;
import cn.jeeweb.modules.yxsjtj.utils.ReadExcelUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**   
 * @Title: 专业
 * @Description: 专业
 * @author xiaoming
 * @date 2017-12-07 22:23:04
 * @version V1.0   
 *
 */
@Transactional
@Service("majorService")
public class MajorServiceImpl  extends CommonServiceImpl<MajorMapper,Major> implements  IMajorService {
	@Override
	public boolean resolverAttch(HttpServletRequest request, MultipartFile file) throws Exception{
		ArrayList<Major> arrayList = new ReadExcelUtils(file,Major.class).readExcelMajor();
		for(Major major:arrayList) {
			String xldm = DictUtils.getDictValue(major.getXldm().replaceAll("专业", ""), "xldm", "");
			major.setXldm(xldm);
		}
		boolean insertBatch = insertBatch(arrayList);
		System.out.println("insertBatch:"+insertBatch);
		return insertBatch;
	}
}
