package cn.jeeweb.modules.yxsjtj.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 * 读取Excel
 */
public class ReadExcelUtils<T> {
	private Logger logger = LoggerFactory.getLogger(ReadExcelUtils.class);
	public org.apache.poi.ss.usermodel.Workbook wb = null;
	private org.apache.poi.ss.usermodel.Sheet sheet;
	private org.apache.poi.ss.usermodel.Row row;
	private Class<T> objClazz;

	@SuppressWarnings("unchecked")
	public ReadExcelUtils(MultipartFile file, Class clzz) {
		try {
			objClazz = clzz;
			checkFile(file);
			wb = getWorkBook(file);
			System.out.println("ReadExcelUtils:wb---" + wb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void checkFile(MultipartFile file) throws IOException {
		// 判断文件是否存在
		if (null == file) {
			throw new FileNotFoundException("文件不存在！");
		}
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 判断文件是否是excel文件
		if (!fileName.endsWith("xls") && !fileName.endsWith("xlsx")) {
			throw new IOException(fileName + "不是excel文件");
		}
	}

	public static Workbook getWorkBook(MultipartFile file) {
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 创建Workbook工作薄对象，表示整个excel
		Workbook workbook = null;
		try {
			// 获取excel文件的io流
			InputStream is = file.getInputStream();
			// 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
			if (fileName.endsWith("xls")) {
				// 2003
				workbook = new HSSFWorkbook(is);
			} else if (fileName.endsWith("xlsx")) {
				// 2007
				workbook = new XSSFWorkbook(is);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}

	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param InputStream
	 * @return String 表头内容的数组
	 * @author zengwendong
	 */
	public List<String> readExcelStudTitle() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		List<String> titleList = new ArrayList<>();
		for (int i = 0; i < colNum; i++) {
			titleList.add(row.getCell(i).getStringCellValue());
		}
		return titleList;
	}

	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param InputStream
	 * @return String 表头内容的数组
	 * @author zengwendong
	 */
	public List<String> readExcelUniverTitle() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		List<String> titleList = new ArrayList<>();
		for (int i = 0; i < colNum; i++) {
			String value = row.getCell(i).getStringCellValue();
			if (value.equals("院校代码")) {
				titleList.add("number");
			} else if (value.equals("院校名称")) {
				titleList.add("name");
			} else if (value.equals("所在地市州")) {
				titleList.add("areaid");
			} else if (value.equals("所在地")) {
				titleList.add("provinceid");
			} else if (value.equals("院校性质")) {
				titleList.add("featureid");
			} else if (value.equals("隶属单位")) {
				titleList.add("belongto");
			} else if (value.equals("办学类型")) {
				titleList.add("typeid");
			} else if (value.equals("is211")) {
				titleList.add("is211");
			} else if (value.equals("is985")) {
				titleList.add("is985");
			} else if (value.equals("独立学院")) {
				titleList.add("isindependent");
			} else if (value.equals("新增本科")) {
				titleList.add("isnewbk");
			} else if (value.equals("示范高职")) {
				titleList.add("issfgz");
			} else if (value.equals("科研机构")) {
				titleList.add("iskyjg");
			} else if (value.equals("民办院校")) {
				titleList.add("ismbyx");
			} else if (value.equals("培养专科")) {
				titleList.add("ispyzk");
			} else if (value.equals("培养本科")) {
				titleList.add("ispybk");
			} else if (value.equals("培养硕士")) {
				titleList.add("ispyss");
			} else if (value.equals("培养博士")) {
				titleList.add("ispybs");
			}
		}
		return titleList;
	}

	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param InputStream
	 * @return String 表头内容的数组
	 * @author zengwendong
	 */
	public List<String> readExcelMajorTitle() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		List<String> titleList = new ArrayList<>();
		for (int i = 0; i < colNum; i++) {
			String value = row.getCell(i).getStringCellValue();
			if (value.equals("学历层次")) {
				titleList.add("xldm");
			} else if (value.equals("专业代码")) {
				titleList.add("zydm");
			} else if (value.equals("专业名称")) {
				titleList.add("zymc");
			}
		}
		return titleList;
	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 * @author zengwendong
	 */
	public ArrayList<T> readUniversity() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}

		List<String> univerTitle = readExcelUniverTitle();
		ArrayList<T> list = new ArrayList<>();
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = univerTitle.size();
		// 正文内容应该从第二行开始,第一行为表头的标题
		T student = null;
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			student = objClazz.newInstance();
			Class clzz = student.getClass();
			// 遍历列
			while (j < colNum) {
				String title = univerTitle.get(j);
				Cell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				Field field = clzz.getDeclaredField(title.toLowerCase());
				field.setAccessible(true);
				if (value.equals("false")) {
					field.set(student, (short) 0);
				} else if (value.equals("true")) {
					field.set(student, (short) 1);
				} else {
					field.set(student, value);
				}

				j++;
			}
			if (student != null) {
				list.add(student);
			}
		}
		return list;
	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 * @author zengwendong
	 */
	public ArrayList<T> readExcelStudent() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}
		List<String> studTitle = readExcelStudTitle();
		ArrayList<T> list = new ArrayList<>();
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = studTitle.size();
		// 正文内容应该从第二行开始,第一行为表头的标题
		T student = null;
		System.out.println("rowNum:" + rowNum + ",colNum:" + colNum);
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			System.out.println("loop:rowNumber:" + i + ",totalrowNum:" + rowNum);
			student = objClazz.newInstance();
			Class clzz = student.getClass();
			// 遍历列
			int j = -1;
			while ((++j) < colNum) {
				String title = studTitle.get(j);
				Cell cell = row.getCell(j);

				if (cell == null) {
					continue;
				}
				String value = null;
				if(cell.getCellType() ==  Cell.CELL_TYPE_NUMERIC) {
					value = ((int)cell.getNumericCellValue())+"";
					System.out.println("value:"+value);
				}else {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					value = cell.getStringCellValue();
				}
				
				try {
					Field field = clzz.getDeclaredField(title.toLowerCase());
					field.setAccessible(true);
					field.set(student, value);
				} catch (NoSuchFieldException e) {
					System.out.println("NoSuchFieldException:,title:" + title);
				}
			}

			if (student != null) {
				list.add(student);
			}
		}
		return list;
	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 * @author zengwendong
	 */
	public ArrayList<T> readExcelMajor() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}
		List<String> majorTitle = readExcelMajorTitle();
		ArrayList<T> list = new ArrayList<>();
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = majorTitle.size();
		// 正文内容应该从第二行开始,第一行为表头的标题
		T student = null;
		System.out.println("rowNum:" + rowNum + ",colNum:" + colNum);
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			System.out.println("loop:rowNumber:" + i + ",totalrowNum:" + rowNum);
			student = objClazz.newInstance();
			Class clzz = student.getClass();
			// 遍历列
			int j = -1;
			while ((++j) < colNum) {
				String title = majorTitle.get(j);
				Cell cell = row.getCell(j);
				if (cell == null) {
					continue;
				}
				cell.setCellType(Cell.CELL_TYPE_STRING);
				String value = cell.getStringCellValue();
				try {
					Field field = clzz.getDeclaredField(title.toLowerCase());
					field.setAccessible(true);
					field.set(student, value);
				} catch (NoSuchFieldException e) {
					System.out.println("NoSuchFieldException:,title:" + title);
				}
			}

			if (student != null) {
				list.add(student);
			}
		}
		return list;
	}

	/**
	 * 
	 * 根据Cell类型设置数据
	 * 
	 * @param cell
	 * @return
	 * @author zengwendong
	 */
	private Object getCellFormatValue(Cell cell) {

		Object cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
			case Cell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (DateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式
					// data格式是带时分秒的：2013-7-10 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();
					// data格式是不带带时分秒的：2013-7-10
					Date date = cell.getDateCellValue();
					cellvalue = date;
				} else {// 如果是纯数字

					// 取得当前Cell的数值
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			default:// 默认的Cell值
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}
}