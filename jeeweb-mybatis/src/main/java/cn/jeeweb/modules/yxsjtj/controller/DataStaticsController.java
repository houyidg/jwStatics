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
import com.sun.xml.bind.v2.TODO;

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
import cn.jeeweb.modules.yxsjtj.entity.JylColumn;
import cn.jeeweb.modules.yxsjtj.entity.JylEntry;
import cn.jeeweb.modules.yxsjtj.entity.JyqsEntry;
import cn.jeeweb.modules.yxsjtj.entity.JyqsLine;
import cn.jeeweb.modules.yxsjtj.entity.LineEntry;
import cn.jeeweb.modules.yxsjtj.entity.Major;
import cn.jeeweb.modules.yxsjtj.entity.PropertyEntry;
import cn.jeeweb.modules.yxsjtj.entity.PieEntry;
import cn.jeeweb.modules.yxsjtj.entity.Student;
import cn.jeeweb.modules.yxsjtj.entity.University;
import cn.jeeweb.modules.yxsjtj.service.IMajorService;
import cn.jeeweb.modules.yxsjtj.service.IStudentService;
import cn.jeeweb.modules.yxsjtj.service.IUniversityService;
import cn.jeeweb.modules.yxsjtj.service.impl.MajorServiceImpl;
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
	protected IMajorService majorService;
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
		} else if ("zy".equals(type)) {// zy
//			Map<String, Object> paramtersMap = getRequestParamterMap(request.getParameterMap());
//			List<Map<String,Object>> zyMapByYxdms = studentService.getZyMapByYxdms(paramtersMap);
			
			EntityWrapper<Major> entityWrapper = new EntityWrapper<>(Major.class);
			entityWrapper.setSqlSelect("zydm,zymc");
			// 整理院校数据
			List<Map<String,Object>> selectMaps = majorService.selectMaps(entityWrapper);
			for (Map<String,Object> map : selectMaps) {
				areaList.add(new PropertyEntry(map.get("zydm").toString(), map.get("zymc").toString()));
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
			if(arr.length>0) {
				entityWrapper.and();
				if("is211".equals(parameterKey) || "is985".equals(parameterKey)) {
					entityWrapper.eq(parameterKey, arr[0]);
				}else {
					entityWrapper.in(parameterKey, arr);
				}
			}
		}
	}

	// |,|
	@RequestMapping(value = "ajaxChartList", method = { RequestMethod.GET, RequestMethod.POST })
	private void ajaxChartList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String actiontype = request.getParameter("actiontype");
		Map<String, Object> paramtersMap = getRequestParamterMap(request.getParameterMap());
		String content = "";

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
			List<Map<String, Object>> dataList = studentService.getJYLStatics(paramtersMap);
			System.out.println("ajaxChartList ACTION_TYPE_JYLFX:" + dataList);
			String type = "全部";
			List<JylColumn> jylColumns = new ArrayList<>();

			JylColumn jylColumnAll = null, jylColumn = null;

			// 需要对比的获取院校
			String[] yxdms = (String[]) paramtersMap.get("yxdms");
			if (yxdms == null) {
				jylColumnAll = new JylColumn(type);
				jylColumns.add(jylColumnAll);
			}else {
				for(String yxdm :yxdms) {
					JylColumn column = new JylColumn(yxdm);
					generateJylColumn(jylColumns, column);
				}
			}
			/** 院校代码 院校名称 所在地 院校性质 隶属单位 办学类型 211 985 毕业时间 毕业人数
			 */
			for (Map<String, Object> map : dataList) {
				System.out.println("ACTION_TYPE_JYLFX yxdm:"+map.get("yxdm").toString());
				JylColumn column = new JylColumn(map.get("yxdm").toString());
				int indexOf = jylColumns.indexOf(column);
				if(indexOf==-1) {
					column = generateJylColumn(jylColumns, column);
					jylColumn = column;
				}else {
					jylColumn = jylColumns.get(indexOf);
				}

				long tempCount = (Long) map.get("count");
				String tempDm = (String) map.get("byqxdm");

				if (jylColumnAll != null) {
					setJylColumn(jylColumnAll, tempCount, tempDm);
				}

				if (jylColumn != null) {
					setJylColumn(jylColumn, tempCount, tempDm);
				}
			}
			content = JSON.toJSONString(jylColumns);
		} else if (ACTION_TYPE_JYQSFX.equals(actiontype)) {
			List<Map<String, Object>> dataList = studentService.getJYQSStatics(paramtersMap);
			System.out.println("ajaxChartList dataList" + dataList);
			String[] yxdms = (String[]) paramtersMap.get("yxdms");
			String type = "全部";
			
			List<JyqsLine> jyqsLines = new ArrayList<JyqsLine>();
			JyqsLine jyqsLineAll = null,jyqsLine=null;
			if(yxdms==null) {
				jyqsLineAll = new JyqsLine(type);
				jyqsLineAll.yxmc = type;
				jyqsLines.add(jyqsLineAll);
			}else {
				for(String yxdm:yxdms) {
					JyqsLine line = new JyqsLine(yxdm);
					generateJyqsLine(jyqsLines,line);
				}
			}
			
			for (Map<String, Object> map : dataList) {
				String yxdm = map.get("yxdm").toString();
				int indexOf = jyqsLines.indexOf(new JyqsLine(yxdm));
				if(indexOf==-1) {
					jyqsLine = null;
				}else {
					jyqsLine = jyqsLines.get(indexOf);
				}
				
				String bysj = (((String) map.get("bysj")).substring(0, 4));
				long count = (long) map.get("count");
				
				if(jyqsLineAll!=null) {
					setJyqsLine(jyqsLineAll, bysj, count);
				}
				
				if(jyqsLine!=null) {
					setJyqsLine(jyqsLine, bysj, count);
				}
			}
			System.out.println("jyqsLines"+jyqsLines.size()+",jyqsLineAll:"+jyqsLineAll);
			content = JSON.toJSONString(jyqsLines);
		}
		System.out.println("ajaxChartList actiontype:" + actiontype + ", content" + content);
		StringUtils.printJson(response, content);
	}

	private List<JyqsLine.Entry> setJyqsLine(JyqsLine jyqsLineAll, String bysj, long count) {
		List<JyqsLine.Entry> valueList = jyqsLineAll.entrys;
		cn.jeeweb.modules.yxsjtj.entity.JyqsLine.Entry entry =  jyqsLineAll.new Entry(bysj,0);
		boolean contains = valueList.contains(entry);
		if(contains) {
			entry = valueList.get(valueList.indexOf(entry));
		}else {
			valueList.add(entry);
		}
		entry.value+=count;
		return valueList;
	}

	private void generateJyqsLine(List<JyqsLine> jyqsLines, JyqsLine jyqsLine) {
			// 从院校db根据院校代码读取院校名称
			EntityWrapper<University> wrapper = new EntityWrapper<>(University.class);
			wrapper.setSqlSelect("name");
			wrapper.eq("number", jyqsLine.yxdm);
			jyqsLine.yxmc = (String) universityService.selectObj(wrapper);
			jyqsLines.add(jyqsLine);
	}

	private JylColumn generateJylColumn(List<JylColumn> jylColumns, JylColumn column) {
		EntityWrapper<University> wrapper = new EntityWrapper<>(University.class);
		wrapper.eq("number", column.yxdm);
		University university = universityService.selectOne(wrapper);
		if(university==null) {
			return null;
		}
		column.yxmc = university.getName();
		column.yxszd = DictUtils.getDictLabel(university.getAreaid(), "yxszd", university.getAreaid());
		column.yxxz = DictUtils.getDictLabel(university.getFeatureid(), "yxxz", university.getFeatureid());
		column.yxlsdw =  DictUtils.getDictLabel(university.getBelongto(), "lsdw", university.getBelongto());
		column.yxbxlx = DictUtils.getDictLabel(university.getTypeid(), "bxlx", university.getTypeid()); 
		column.is211 = university.getIs211();
		column.is985 = university.getIs985();
		jylColumns.add(column);
		return column;
	}

	private void setJylColumn(JylColumn jylColumnAll, long tempCount, String tempDm) {
		jylColumnAll.count += tempCount;
		if ("70".equals(tempDm)) {
			jylColumnAll.djyrs += tempCount;
		} else if ("71".equals(tempDm)) {
			jylColumnAll.bjynsxrs += tempCount;
		} else if ("72".equals(tempDm)) {
			jylColumnAll.qtzbjyrs += tempCount;
		}
		jylColumnAll.jyrs = jylColumnAll.count - jylColumnAll.djyrs - jylColumnAll.bjynsxrs - jylColumnAll.qtzbjyrs;
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
				} else if("zy".equals(key)){
					map.put(key, value[0]);
					System.out.println("key:"+key+",value[0]:"+value[0]);
				}else {
					String[] arr = value[0].split(arrConStr);
					map.put(key, arr);
				}
			}
		}
		return map;
	}
}
