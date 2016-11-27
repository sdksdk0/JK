package poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class TestPOI {
	
	//基本使用
	@Test
	public void HSSF() throws IOException{
		//1.创建一个工作簿
		Workbook wb=new HSSFWorkbook();
		//2.创建一个工作表sheet
		Sheet  sheet=wb.createSheet();
		//3.创建一个行对象
		Row  nRow=sheet.createRow(4); //从0开始
		//4、创建一个单元格对象，指定列
		Cell nCell=nRow.createCell(4);
		//5、设置内容
		nCell.setCellValue("指令汇科技");
		//6.保存
		OutputStream stream=new FileOutputStream(new File("D:\\test1.xls")); 
		wb.write(stream);
		//7.关闭
		stream.close();
	
	}
	
	//带格式
	@Test
	public void HSSF1() throws IOException{
		//1.创建一个工作簿
		Workbook wb=new HSSFWorkbook();
		//2.创建一个工作表sheet
		Sheet  sheet=wb.createSheet();
		//3.创建一个行对象
		Row  nRow=sheet.createRow(4); //从0开始
		//4、创建一个单元格对象，指定列
		Cell nCell=nRow.createCell(4);
		//5、设置内容
		nCell.setCellValue("指令汇科技");
		
		
		CellStyle titleStyle=wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("微软雅黑");  //设置字体类型
		font.setFontHeightInPoints((short) 26);  //设置字体大小
		titleStyle.setFont(font);
		
		//再创建一个单元格
		
		
		
		
					
		nCell.setCellStyle(titleStyle);
		//6.保存
		OutputStream stream=new FileOutputStream(new File("D:\\test1.xls")); 
		wb.write(stream);
		//7.关闭
		stream.close();
	
	}
	
	
	
	
	

}
