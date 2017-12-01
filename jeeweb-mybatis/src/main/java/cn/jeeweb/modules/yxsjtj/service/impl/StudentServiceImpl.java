package cn.jeeweb.modules.yxsjtj.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.yxsjtj.entity.Student;
import cn.jeeweb.modules.yxsjtj.mapper.StudentMapper;
import cn.jeeweb.modules.yxsjtj.service.IStudentService;
import cn.jeeweb.modules.yxsjtj.utils.ReadExcelUtils;

/**
 * @Title: 学生管理
 * @Description: 学生表，包含很多属性
 * @author zx
 * @date 2017-10-29 00:04:16
 * @version V1.0
 *
 */
@Transactional
@Service("studentService")
public class StudentServiceImpl extends CommonServiceImpl<StudentMapper, Student> implements IStudentService {
	@Override
	public boolean resolverStudents(HttpServletRequest request, MultipartFile file) throws Exception {
		InputStream inputStream = file.getInputStream();
		String filename = file.getOriginalFilename();
		String fileext = StringUtils.getExtensionName(filename);
		ArrayList<Student> arrayList = new ReadExcelUtils(inputStream, fileext, Student.class).readExcelContent();
		boolean insertBatch = insertBatch(arrayList);
		System.out.println("insertBatch:" + insertBatch);
		return true;
	}

	@Override
	public List<Map<String, Object>> getStatics(Map<String, Object> data) {
		List<Map<String, Object>> list = baseMapper.getStatics(data);
		System.out.println("getStatics:---"+list);
		return list;
	}

	@Override
	public List<Map<String, Object>> getJYQSStatics(Map<String, Object> data) {
		List<Map<String, Object>> list = baseMapper.getJYQSStatics(data);
		System.out.println("getJYQSStatics:---"+list);
		return list;
	}

	@Override
	public List<Map<String, Object>> getJYLStatics(Map<String, Object> data) {
		List<Map<String, Object>> list = baseMapper.getJYLStatics(data);
		System.out.println("getZys:---"+list);
		return list;
	}
}
