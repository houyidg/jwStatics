package cn.jeeweb.modules.yxsjtj.utils;

import java.io.InputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读取Excel
 */
public class ReadExcelUtils<T> {
	private Logger logger = LoggerFactory.getLogger(ReadExcelUtils.class);
	public Workbook wb = null;
	private Sheet sheet;
	private Row row;
	private Class<T> objClazz;

	public ReadExcelUtils(InputStream in, String ext, Class clzz) {
		try {
			objClazz = clzz;

			if (!in.markSupported()) {
				in = new PushbackInputStream(in, 8);
			}
			if (POIFSFileSystem.hasPOIFSHeader(in)) {
				wb =new HSSFWorkbook(in);
			}
			if (POIXMLDocument.hasOOXMLHeader(in)) {
				wb =new XSSFWorkbook(OPCPackage.open(in));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param InputStream
	 * @return String 表头内容的数组
	 * @author zengwendong
	 */
	public String[] readExcelTitle() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			title[i] = row.getCell(i).getStringCellValue();
		}
		return title;
	}

	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param InputStream
	 * @return String 表头内容的数组
	 * @author zengwendong
	 */
	public String[] readExcelTitle2() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			String value = row.getCell(i).getStringCellValue();
			if (value.equals("院校代码")) {
				title[i] = "number";
			} else if (value.equals("院校名称")) {
				title[i] = "name";
			} else if (value.equals("所在地市州")) {
				title[i] = "areaid";
			} else if (value.equals("所在地")) {
				title[i] = "provinceid";
			} else if (value.equals("院校性质")) {
				title[i] = "featureid";
			} else if (value.equals("隶属单位")) {
				title[i] = "belongto";
			} else if (value.equals("办学类型")) {
				title[i] = "typeid";
			} else if (value.equals("is211")) {
				title[i] = "is211";
			} else if (value.equals("is985")) {
				title[i] = "is985";
			} else if (value.equals("独立学院")) {
				title[i] = "isindependent";
			} else if (value.equals("新增本科")) {
				title[i] = "isnewbk";
			} else if (value.equals("示范高职")) {
				title[i] = "issfgz";
			} else if (value.equals("科研机构")) {
				title[i] = "iskyjg";
			} else if (value.equals("民办院校")) {
				title[i] = "ismbyx";
			} else if (value.equals("培养专科")) {
				title[i] = "ispyzk";
			} else if (value.equals("培养本科")) {
				title[i] = "ispybk";
			} else if (value.equals("培养硕士")) {
				title[i] = "ispyss";
			} else if (value.equals("培养博士")) {
				title[i] = "ispybs";
			}
		}
		return title;
	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 * @author zengwendong
	 */
	public ArrayList<T> readExcelContent2() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}

		String[] excelTitle = readExcelTitle2();
		ArrayList<T> list = new ArrayList<>();
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		T student = null;
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			student = objClazz.newInstance();
			Class clzz = student.getClass();
			// 遍历列
			while (j < colNum) {
				String title = excelTitle[j];
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
	public ArrayList<T> readExcelContent() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}
		String[] excelTitle = readExcelTitle();
		ArrayList<T> list = new ArrayList<>();
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
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
				String title = excelTitle[j];
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