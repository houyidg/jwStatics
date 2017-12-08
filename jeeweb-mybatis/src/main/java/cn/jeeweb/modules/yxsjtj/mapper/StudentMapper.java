package cn.jeeweb.modules.yxsjtj.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.jeeweb.modules.yxsjtj.entity.Student;
 
/**   
 * @Title: 学生管理数据库控制层接口
 * @Description: 学生表，包含很多属性数据库控制层接口
 * @author zx
 * @date 2017-12-07 23:18:56
 * @version V1.0   
 *
 */
public interface StudentMapper extends BaseMapper<Student> {
	/**
	 * map 所包含的值 <!--universityid featureid belongto startDate endDate typeid areaid byqxdms -->
	 * @param data
	 * @return
	 */
	List<Map<String, Object>> getStatics(Map<String, Object> data);
	List<Map<String, Object>> getJYLStatics(Map<String, Object> data);
	List<Map<String, Object>> getJYQSStatics(Map<String, Object> data);//getZyMapByYxdms
	List<Map<String, Object>> getZyMapByYxdms(Map<String, Object> data);//
}