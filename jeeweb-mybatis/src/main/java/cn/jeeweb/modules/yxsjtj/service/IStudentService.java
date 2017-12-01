package cn.jeeweb.modules.yxsjtj.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cn.jeeweb.core.common.service.ICommonService;
import cn.jeeweb.modules.sys.entity.Attachment;
import cn.jeeweb.modules.yxsjtj.entity.Student;

/**   
 * @Title: 学生管理
 * @Description: 学生表，包含很多属性
 * @author zx
 * @date 2017-10-29 00:04:16
 * @version V1.0   
 *
 */
public interface IStudentService extends ICommonService<Student> {

	boolean resolverStudents(HttpServletRequest request, MultipartFile file) throws IOException, Exception;

	List<Map<String, Object>> getStatics(Map<String, Object> data);
	List<Map<String, Object>> getJYQSStatics(Map<String, Object> data);
	List<Map<String, Object>> getJYLStatics(Map<String, Object> data);
}

