package cn.jeeweb.modules.yxsjtj.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.yxsjtj.mapper.UniversityMapper;
import cn.jeeweb.modules.sys.entity.Dict;
import cn.jeeweb.modules.sys.utils.DictUtils;
import cn.jeeweb.modules.yxsjtj.entity.Student;
import cn.jeeweb.modules.yxsjtj.entity.University;
import cn.jeeweb.modules.yxsjtj.service.IUniversityService;
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
 * @Title: 院校管理
 * @Description: 院校表，包含属性：院校代码	院校名称	所在地	所在地市州	院校性质	隶属单位	办学类型	is211	is985	独立学院	新增本科	示范高职	科研机构	民办院校	培养专科	培养本科	培养硕士	培养博士
 * @author zx
 * @date 2017-10-28 23:19:04
 * @version V1.0   
 *
 */
@Transactional
@Service("universityService")
public class UniversityServiceImpl  extends CommonServiceImpl<UniversityMapper,University> implements  IUniversityService {
	@Override
	public boolean resolverAttch(HttpServletRequest request, MultipartFile file) throws Exception {
		ArrayList<University> arrayList = new ReadExcelUtils(file,University.class).readUniversity();
		for(University university:arrayList) {
			university.setAreaid(DictUtils.getDictValue(university.getAreaid(), "yxszd", ""));
			
			university.setFeatureid(DictUtils.getDictValue(university.getFeatureid(), "yxxz", ""));
			
			university.setBelongto(DictUtils.getDictValue(university.getBelongto(), "lsdw", ""));
			
			university.setTypeid(DictUtils.getDictValue(university.getTypeid(), "bxlx", ""));
			
			university.setProvinceid(DictUtils.getDictValue(university.getProvinceid(), "yxszs", ""));
		}
		boolean insertBatch = insertBatch(arrayList);
		System.out.println("insertBatch:"+insertBatch);
		
		return insertBatch;
	}
}
