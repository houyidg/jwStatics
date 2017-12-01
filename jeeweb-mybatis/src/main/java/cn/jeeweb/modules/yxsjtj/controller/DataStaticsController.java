package cn.jeeweb.modules.yxsjtj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import cn.jeeweb.modules.sys.Constants;
import cn.jeeweb.modules.sys.entity.Attachment;
import cn.jeeweb.modules.sys.entity.Dict;
import cn.jeeweb.modules.sys.utils.DictUtils;
import cn.jeeweb.modules.yxsjtj.entity.ChartBaseEntry;
import cn.jeeweb.modules.yxsjtj.entity.ChartModel;
import cn.jeeweb.modules.yxsjtj.entity.ColumnEntry;
import cn.jeeweb.modules.yxsjtj.entity.JylEntry;
import cn.jeeweb.modules.yxsjtj.entity.JyqsEntry;
import cn.jeeweb.modules.yxsjtj.entity.LineEntry;
import cn.jeeweb.modules.yxsjtj.entity.PropertyEntry;
import cn.jeeweb.modules.yxsjtj.entity.PieEntry;
import cn.jeeweb.modules.yxsjtj.entity.Student;
import cn.jeeweb.modules.yxsjtj.entity.University;
import cn.jeeweb.modules.yxsjtj.service.IStudentService;
import cn.jeeweb.modules.yxsjtj.service.IUniversityService;
import cn.jeeweb.modules.yxsjtj.utils.ChartUtils;

/**
 * @Title: 学生管理
 * @Description: 学生表，包含很多属性
 * @author zx
 * @date 2017-10-28 23:59:56
 * @version V1.0
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/yxsjtj/datastatics")
@RequiresPathPermission("yxsjtj:datastatics")
public class DataStaticsController extends BaseBeanController<ChartModel> {
	private static final String ACTION_TYPE_BYQXFX = "byqxfx";// 毕业去向分析
	private static final String ACTION_TYPE_JYLFX = "jylfx";// 就业率分析
	private static final String ACTION_TYPE_JYQSFX = "jyqsfx";// 就业趋势分析
	@Autowired
	protected IStudentService studentService;
	@Autowired
	protected IUniversityService universityService;
	private String AllCountId = "-1";// 展示所有数据
	private String AllCountValue = "全部";// 展示所有数据
	private static final String TYPE_JR = "就业";//
	private static final String TYPE_DJR = "待就业";//
	private static final String TYPE_ZBJR = "暂不就业";//
	private static final String arrConStr = ",";

	@RequestMapping(value = "ajaxPropertyList", method = { RequestMethod.GET, RequestMethod.POST })
	private void ajaxPropertyList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String type = request.getParameter("type");
		List<PropertyEntry> areaList = new ArrayList<>();
		if ("yxmc".equals(type)) {// 院校名称请求
			EntityWrapper<University> entityWrapper = new EntityWrapper<>(University.class);
			int selectCount = universityService.selectCount(entityWrapper);
			addCondition(entityWrapper, "areaid", request);
			addCondition(entityWrapper, "featureid", request);
			addCondition(entityWrapper, "belongto", request);
			addCondition(entityWrapper, "typeid", request);
			addCondition(entityWrapper, "is985", request);
			addCondition(entityWrapper, "is211", request);
			// 整理院校数据
			List<University> selectList = universityService.selectList(entityWrapper);
			if (selectCount == selectList.size()) {
				areaList.add(new PropertyEntry(AllCountId, AllCountValue));
			}
			for (University university : selectList) {
				areaList.add(new PropertyEntry(university.getNumber(), university.getName()));
			}
		} else if ("zy".equals(type)) {// 院校名称请求
			// 整理专业数据 universityid
			EntityWrapper<Student> entityWrapper2 = new EntityWrapper<>(Student.class);
			entityWrapper2.setSqlSelect(" DISTINCT zy ");
			addUniversityCondition(entityWrapper2, "yxdms", request);
			List<Object> resullList = studentService.selectObjs(entityWrapper2);
			for (Object value : resullList) {
				areaList.add(new PropertyEntry(value.toString(), value.toString()));
			}
		} else {
			List<Dict> dictList = DictUtils.getDictList(type);
			areaList.add(new PropertyEntry(AllCountId, AllCountValue));
			for (Dict dict : dictList) {
				areaList.add(new PropertyEntry(dict.getValue(), dict.getLabel()));
			}
		}
		String content = JSON.toJSONString(areaList);
		System.out.println("ajaxPropertyList:type:" + type + ",areaList:" + areaList.size() + "----content:" + content);
		StringUtils.printJson(response, content);
	}

	private void addUniversityCondition(EntityWrapper<Student> entityWrapper2, String parameterKey,
			HttpServletRequest request) {
		List<String> idList = new ArrayList<>();
		String parameterValue = request.getParameter(parameterKey);
		if (parameterValue != null && !parameterValue.equals(AllCountId) && !parameterValue.trim().equals("")) {
			String[] arr = parameterValue.split(arrConStr);
			for (String value : arr) {
				idList.add(value);
			}
		}
		if (!idList.isEmpty())
			entityWrapper2.in("yxdm", idList);
		entityWrapper2.groupBy("zy");
	}

	private void addCondition(EntityWrapper<University> entityWrapper, String parameterKey,
			HttpServletRequest request) {
		String parameterValue = request.getParameter(parameterKey);
		if (parameterValue != null && !parameterValue.equals(AllCountId) && !parameterValue.trim().equals("")) {
			String[] arr = parameterValue.split(arrConStr);
			for (String value : arr) {
				entityWrapper.and(parameterKey + " = {0}", parameterValue);
			}
		}
	}

	// |,|
	@RequestMapping(value = "ajaxChartList", method = { RequestMethod.GET, RequestMethod.POST })
	private void ajaxChartList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String actiontype = request.getParameter("actiontype");
		Map<String, Object> paramtersMap = getRequestParamterMap(request.getParameterMap());
		String content="";

		if (ACTION_TYPE_BYQXFX.equals(actiontype)) {
			List<ChartBaseEntry> list = new ArrayList<>();
			List<Map<String, Object>> dataList = studentService.getStatics(paramtersMap);
			System.out.println("ajaxChartList dataList" + dataList);
			for (Map<String, Object> map : dataList) {

				PieEntry pieEntry = new PieEntry();
				list.add(pieEntry);
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					if ("count".equals(entry.getKey())) {
						pieEntry.value = (Long) entry.getValue();
					} else if ("byqxdm".equals(entry.getKey())) {
						pieEntry.name = DictUtils.getDictLabel((String) entry.getValue(), Constants.BYSQX, "sf");
					}
				}
			}
			 content = JSON.toJSONString(list);
		} else if (ACTION_TYPE_JYLFX.equals(actiontype)) {
			List<ColumnEntry> list = new ArrayList<>();
			// 需要对比的获取院校
			String[] yxdms = (String[]) paramtersMap.get("yxdms");
			List<Map<String, Object>> dataList = studentService.getJYLStatics(paramtersMap);
			System.out.println("ajaxChartList ACTION_TYPE_JYLFX:" + dataList);
			Map<String, JylEntry> resultMap = new HashMap<>();
			String type = "全部";
			if (yxdms == null) {
				resultMap.put(type, new JylEntry());
			} else {
				for (String yxdm : yxdms) {
					resultMap.put(yxdm, new JylEntry());
				}
			}

			JylEntry jylEntry = null;
			for (Map<String, Object> map : dataList) {
				long tempCount = Long.MAX_VALUE;
				String tempDm = null;
				if (yxdms == null) {
					jylEntry = resultMap.get(type);
				} else {
					jylEntry = resultMap.get(map.get("yxdm"));
				}
				//
				tempCount = (Long) map.get("count");
				tempDm = (String) map.get("byqxdm");

				// count
				if (tempCount != Long.MAX_VALUE)
					jylEntry.count += tempCount;
				if ("70".equals(tempDm)) {
					jylEntry.djyrs += tempCount;
				} else if ("71".equals(tempDm)) {
					jylEntry.bjynsxrs += tempCount;
				} else if ("72".equals(tempDm)) {
					jylEntry.qtzbjyrs += tempCount;
				}
				jylEntry.jyrs = jylEntry.count - jylEntry.djyrs - jylEntry.bjynsxrs - jylEntry.qtzbjyrs;
			}
			for (String key : resultMap.keySet()) {
				jylEntry = resultMap.get(key);
				if (!type.equals(key)) {
					// 从院校db根据院校代码读取院校名称
					EntityWrapper<University> wrapper = new EntityWrapper<>(University.class);
					wrapper.setSqlSelect("name");
					wrapper.eq("number", key);
					key = (String) universityService.selectObj(wrapper);
				}
				System.out.println("ajaxChartList key:" + key);
				// 就业人数
				list.add(new ColumnEntry(jylEntry.jyrs, TYPE_JR, key));
				// 待就业人数
				list.add(new ColumnEntry(jylEntry.djyrs, TYPE_DJR, key));
				// 暂不就业
				list.add(new ColumnEntry(jylEntry.bjynsxrs + jylEntry.qtzbjyrs, TYPE_ZBJR, key));
			}
			 content = JSON.toJSONString(list);
		} else if (ACTION_TYPE_JYQSFX.equals(actiontype)) {
			List<LineEntry> list = new ArrayList<LineEntry>();
			List<Map<String, Object>> dataList = studentService.getJYQSStatics(paramtersMap);
			System.out.println("ajaxChartList dataList" + dataList);
			String[] yxdms = (String[]) paramtersMap.get("yxdms");
			Map<String, JyqsEntry> resultMap = new HashMap<>();
			String type = "全部";
			
			JyqsEntry jylEntry = null;
			String name = null;
			for (Map<String, Object> map : dataList) {
				if (yxdms == null) {
					name = type+"-"+(((String) map.get("bysj")).substring(0, 4));
				} else {
					name = map.get("yxdm")+"-"+(((String) map.get("bysj")).substring(0, 4));
				}
				
				if(resultMap.containsKey(name)) {
					jylEntry = resultMap.get(name);
				}else {
					jylEntry = new JyqsEntry();
					resultMap.put(name, jylEntry);
				}
				
				jylEntry.value += ((long) map.get("count"));
				jylEntry.name = name.split("-")[1];
			}

			for (String key : resultMap.keySet()) {
				jylEntry = resultMap.get(key);
				key = key.split("-")[0];//获取院校代码
				if (!type.equals(key)) {
					// 从院校db根据院校代码读取院校名称
					EntityWrapper<University> wrapper = new EntityWrapper<>(University.class);
					wrapper.setSqlSelect("name");
					wrapper.eq("number", key);
					key = (String) universityService.selectObj(wrapper);
				}
				// 就业人数
				list.add(new LineEntry(jylEntry.value, jylEntry.name, key));
			}
			 content = JSON.toJSONString(list);
		}
		System.out.println("ajaxChartList actiontype:" + actiontype + ", content" + content);
		StringUtils.printJson(response, content);
	}

	@RequestMapping(value = "jyqsfxList", method = RequestMethod.GET)
	public String jyqsfxList(Model model, HttpServletRequest request, HttpServletResponse response) {
		setUniversityDataToModel(model);
		return display("jyqsfx");
	}

	@RequestMapping(value = "byqxfxList", method = RequestMethod.GET)
	public String byqxfxList(Model model, HttpServletRequest request, HttpServletResponse response) {
		// 需要获取学校数据
		setUniversityDataToModel(model);
		return display("byqxfx");
	}

	@RequestMapping(value = "jylfxList", method = RequestMethod.GET)
	public String jylfxList(Model model, HttpServletRequest request, HttpServletResponse response) {
		setUniversityDataToModel(model);
		return display("jylfx");
	}

	private void setUniversityDataToModel(Model model) {
		Queryable newQueryable = QueryRequest.newQueryable();
		PageRequest pageRequest = new PageRequest(0, 1000);
		newQueryable.setPageable(pageRequest);
		List<University> universityList = universityService.listWithNoPage(newQueryable);
		model.addAttribute("universityList", universityList);
	}

	private Map<String, Object> getRequestParamterMap(Map<String, String[]> parameterMap) {
		Set<java.util.Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
		Map<String, Object> map = new HashMap<>();
		for (java.util.Map.Entry<String, String[]> entry : entrySet) {
			String[] value = entry.getValue();
			String key = entry.getKey();
			if (!value[0].trim().equals("") && !value[0].equals(AllCountId)) {
				if ("startDate".equals(key) || "endDate".equals(key)) {
					map.put(key, value[0]);
				} else {
					String[] arr = value[0].split(arrConStr);
					map.put(key, arr);
				}
			}
		}
		return map;
	}
}
