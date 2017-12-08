package cn.jeeweb.modules.yxsjtj.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cn.jeeweb.core.common.service.ICommonService;
import cn.jeeweb.modules.yxsjtj.entity.Major;

/**   
 * @Title: 专业
 * @Description: 专业
 * @author xiaoming
 * @date 2017-12-07 22:23:04
 * @version V1.0   
 *
 */
public interface IMajorService extends ICommonService<Major> {
	boolean resolverAttch(HttpServletRequest request, MultipartFile file) throws Exception;
}

