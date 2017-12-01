package cn.jeeweb.modules.yxsjtj.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import cn.jeeweb.modules.yxsjtj.entity.University;
 
/**   
 * @Title: 院校管理数据库控制层接口
 * @Description: 院校表，包含属性：院校代码	院校名称	所在地	所在地市州	院校性质	隶属单位	办学类型	is211	is985	独立学院	新增本科	示范高职	科研机构	民办院校	培养专科	培养本科	培养硕士	培养博士数据库控制层接口
 * @author zx
 * @date 2017-10-29 20:19:45
 * @version V1.0   
 *
 */
public interface UniversityMapper extends BaseMapper<University> {
    
}