package cn.jeeweb.modules.yxsjtj.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cn.jeeweb.core.common.service.ICommonService;
import cn.jeeweb.modules.yxsjtj.entity.University;

/**   
 * @Title: 院校管理
 * @Description: 院校表，包含属性：院校代码	院校名称	所在地	所在地市州	院校性质	隶属单位	办学类型	is211	is985	独立学院	新增本科	示范高职	科研机构	民办院校	培养专科	培养本科	培养硕士	培养博士
 * @author zx
 * @date 2017-10-28 23:19:04
 * @version V1.0   
 *
 */
public interface IUniversityService extends ICommonService<University> {

	boolean resolverAttch(HttpServletRequest request, MultipartFile file) throws IOException, Exception;

}

