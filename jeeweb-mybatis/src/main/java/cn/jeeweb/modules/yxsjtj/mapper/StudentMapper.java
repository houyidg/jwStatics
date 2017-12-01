package cn.jeeweb.modules.yxsjtj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;

import cn.jeeweb.modules.sys.entity.Log;
import cn.jeeweb.modules.yxsjtj.entity.Student;
 
/**   
 * @Title: 学生管理数据库控制层接口
 * @Description: 学生表，包含很多属性数据库控制层接口
 * @author zx
 * @date 2017-10-29 02:17:03
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
	List<Map<String, Object>> getJYQSStatics(Map<String, Object> data);
}