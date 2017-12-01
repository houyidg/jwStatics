package cn.jeeweb.modules.yxsjtj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;

import cn.jeeweb.core.common.controller.BaseBeanController;
import cn.jeeweb.core.common.data.DuplicateValid;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.model.PageJson;
import cn.jeeweb.core.model.ValidJson;
import cn.jeeweb.core.query.annotation.PageableDefaults;
import cn.jeeweb.core.query.data.PageRequest;
import cn.jeeweb.core.query.data.PropertyPreFilterable;
import cn.jeeweb.core.query.data.QueryRequest;
import cn.jeeweb.core.query.data.Queryable;
import cn.jeeweb.core.query.utils.QueryableConvertUtils;
import cn.jeeweb.core.query.wrapper.EntityWrapper;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.core.utils.MessageUtils;
import cn.jeeweb.core.utils.ObjectUtils;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.core.utils.upload.exception.FileNameLengthLimitExceededException;
import cn.jeeweb.core.utils.upload.exception.InvalidExtensionException;
import cn.jeeweb.modules.sys.entity.Attachment;
import cn.jeeweb.modules.yxsjtj.entity.Student;
import cn.jeeweb.modules.yxsjtj.entity.University;
import cn.jeeweb.modules.yxsjtj.service.IStudentService;
import cn.jeeweb.modules.yxsjtj.service.IUniversityService;

/**
 * @Title: 学生管理
 * @Description: 学生表，包含很多属性
 * @author zx
 * @date 2017-10-28 23:59:56
 * @version V1.0
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/yxsjtj/student")
@RequiresPathPermission("yxsjtj:student")
public class StudentController extends BaseBeanController<Student> {

	@Autowired
	protected IStudentService studentService;
	@Autowired
	protected IUniversityService universityService;

	public Student get(String id) {
		if (!ObjectUtils.isNullOrEmpty(id)) {
			return studentService.selectById(id);
		} else {
			return newModel();
		}
	}

	@RequiresMethodPermissions("list")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
		return display("list");
	}

	@RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
	@PageableDefaults(sort = "id=desc")
	private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		EntityWrapper<Student> entityWrapper = new EntityWrapper<Student>(entityClass);
		propertyPreFilterable.addQueryProperty("id");
		// 预处理
		QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageJson<Student> pagejson = new PageJson<Student>(studentService.list(queryable, entityWrapper));
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response, content);
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(Model model, HttpServletRequest request, HttpServletResponse response) {
		if (!model.containsAttribute("data")) {
			model.addAttribute("data", newModel());
		}
		// 需要获取学校数据
		Queryable newQueryable = QueryRequest.newQueryable();
		PageRequest pageRequest = new PageRequest(0, 100);
		newQueryable.setPageable(pageRequest);
		List<University> universityList = universityService.listWithNoPage(newQueryable);
		model.addAttribute("universityList", universityList);
		return display("edit");
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson create(Model model, @Valid @ModelAttribute("data") Student student, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		return doSave(student, request, response, result);
	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		Student student = get(id);
		model.addAttribute("data", student);
		// 需要获取学校数据
		Queryable newQueryable = QueryRequest.newQueryable();
		PageRequest pageRequest = new PageRequest(0, 100);
		newQueryable.setPageable(pageRequest);
		List<University> universityList = universityService.listWithNoPage(newQueryable);
		model.addAttribute("universityList", universityList);
		return display("edit");
	}

	/**
	 * 
	 * @title: ajaxUpload
	 * @description: 文件上传
	 * @param request
	 * @param response
	 * @param files
	 * @return
	 * @return: AjaxUploadResponse
	 */
	@RequestMapping(value = "uploadSimditor", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson uploadSimditor(final HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/plain");
		AjaxJson ajaxJson = new AjaxJson();
		List<Attachment> attachmentList = new ArrayList<Attachment>();

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		System.out.println("multipartResolver:" + multipartResolver.getFileUpload().getSizeMax());
		Map<String, Object> data = new HashMap<String, Object>();
		boolean isSuccess = false;
		if (multipartResolver.isMultipart(request)) { // 判断request是否有文件上传
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> ite = multiRequest.getFileNames();
			while (ite.hasNext()) {
				final MultipartFile file = multiRequest.getFile(ite.next());
//				new Thread(new Runnable() {
//					@Override
//					public void run() {
//						
//					}
//				}).start();
				try {
					studentService.resolverStudents(request, file);
					isSuccess = true;
				} catch (Exception e) {
					e.printStackTrace();
					isSuccess = false;
				}
				break;
			}
		}
		Attachment attachment = new Attachment();
		attachment.setStatus(isSuccess + "");
		attachment.setId("id");
		attachmentList.add(attachment);
		ajaxJson.setData(attachmentList);
		System.out.println("uploadSimditor:" + isSuccess);

		return ajaxJson;
	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson update(Model model, @Valid @ModelAttribute("data") Student student, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		return doSave(student, request, response, result);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doSave(Student student, HttpServletRequest request, HttpServletResponse response,
			BindingResult result) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("保存成功");
		if (hasError(student, result)) {
			// 错误提示
			String errorMsg = errorMsg(result);
			if (!StringUtils.isEmpty(errorMsg)) {
				ajaxJson.fail(errorMsg);
			} else {
				ajaxJson.fail("保存失败");
			}
			return ajaxJson;
		}
		try {
			if (StringUtils.isEmpty(student.getId())) {
				studentService.insert(student);
			} else {
				studentService.insertOrUpdate(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("保存失败!<br />原因:" + e.getMessage());
		}
		return ajaxJson;
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson delete(@PathVariable("id") String id) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("删除成功");
		try {
			studentService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("删除失败");
		}
		return ajaxJson;
	}

	@RequestMapping(value = "batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(value = "ids", required = false) String[] ids) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("删除成功");
		try {
			List<String> idList = java.util.Arrays.asList(ids);
			studentService.deleteBatchIds(idList);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("删除失败");
		}
		return ajaxJson;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable("id") String id, HttpServletRequest request,
			HttpServletResponse response) {
		Student student = get(id);
		model.addAttribute("data", student);
		return display("edit");
	}

	@RequestMapping(value = "validate", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ValidJson validate(DuplicateValid duplicateValid, HttpServletRequest request) {
		ValidJson validJson = new ValidJson();
		Boolean valid = Boolean.FALSE;
		try {
			EntityWrapper<Student> entityWrapper = new EntityWrapper<Student>(entityClass);
			valid = studentService.doValid(duplicateValid, entityWrapper);
			if (valid) {
				validJson.setStatus("y");
				validJson.setInfo("验证通过!");
			} else {
				validJson.setStatus("n");
				if (!StringUtils.isEmpty(duplicateValid.getErrorMsg())) {
					validJson.setInfo(duplicateValid.getErrorMsg());
				} else {
					validJson.setInfo("当前信息重复!");
				}
			}
		} catch (Exception e) {
			validJson.setStatus("n");
			validJson.setInfo("验证异常，请检查字段是否正确!");
		}
		return validJson;
	}
}
