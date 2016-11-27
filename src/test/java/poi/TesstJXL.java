package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.junit.Test;


public class TesstJXL {

	@Test
	public void print() throws IOException, RowsExceededException, WriteException {
		WritableWorkbook workbook = null;
		String worksheet = "List";// 输出的excel文件工作表名
		String[] title = { "序号", "客户姓名", "联系电话", "拜访内容", "再访时间", "递交建议书数量","客户来源", "是否签要保书", "是否收取保费", "金额", "件数", "犹豫期退保件数" };// excel工作表的标题

		OutputStream os = new FileOutputStream("c:\\testJXL.xls");
		workbook = Workbook.createWorkbook(os);

		// 创建第一页的sheet
		WritableSheet sheet1 = workbook.createSheet("MySheet1", 0); 		// 可添加第一个工作
		// WritableSheet sheet2 = workbook.createSheet("MySheet2", 1);
		// //可添加第二个工作

		for (int i = 0; i < title.length; i++) {
			Label label = new jxl.write.Label(i, 0, title[i]); 				// put the title	// Label(列号,行号 ,内容 )
																			// in row1
			sheet1.addCell(label);
		}
		
		workbook.write();		// 输出到文件
		workbook.close();		// 关闭文件
	}
	
	@Test
	public void printWithStyle() throws IOException, RowsExceededException, WriteException {
		WritableWorkbook workbook = null;
		String worksheet = "List";// 输出的excel文件工作表名
		String[] title = { "序号", "客户姓名", "联系电话", "拜访内容", "再访时间", "递交建议书数量","客户来源", "是否签要保书", "是否收取保费", "金额", "件数", "犹豫期退保件数" };// excel工作表的标题
		
		OutputStream os = new FileOutputStream("c:\\testJXL.xls");
		workbook = Workbook.createWorkbook(os);
		
		// 创建第一页的sheet
		WritableSheet sheet = workbook.createSheet("MySheet1", 0); // 可添加第一个工作
		// WritableSheet sheet2 = workbook.createSheet("MySheet2", 1);
		// //可添加第二个工作
		
		for (int i = 0; i < title.length; i++) {
			// Label(列号,行号 ,内容 )
			Label label = new jxl.write.Label(i, 0, title[i]); // put the title
			// in row1
			sheet.addCell(label);
		}
		
		//添加数字
		jxl.write.Number number = new jxl.write.Number(3, 4, 3.14159); //put the number 3.14159 in cell D5
		sheet.addCell(number);

		//添加带有字型Formatting的对象 
		jxl.write.WritableFont wf = new jxl.write.WritableFont(WritableFont.TIMES,10,WritableFont.BOLD,true); 
		jxl.write.WritableCellFormat wcfF = new jxl.write.WritableCellFormat(wf); 
		jxl.write.Label labelCF = new jxl.write.Label(4,4,"文本",wcfF); 
		sheet.addCell(labelCF); 

		//添加带有字体颜色,带背景颜色 Formatting的对象 
		jxl.write.WritableFont wfc = new jxl.write.WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD,false,jxl.format.UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.RED); 
		jxl.write.WritableCellFormat wcfFC = new jxl.write.WritableCellFormat(wfc); 
		wcfFC.setBackground(jxl.format.Colour.BLUE);
		jxl.write.Label labelCFC = new jxl.write.Label(1,5,"带颜色",wcfFC); 
		sheet.addCell(labelCFC); 

		//添加带有formatting的Number对象 
		jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#.##"); 
		jxl.write.WritableCellFormat wcfN = new jxl.write.WritableCellFormat(nf); 
		jxl.write.Number labelNF = new jxl.write.Number(1,1,3.1415926,wcfN); 
		sheet.addCell(labelNF); 

		//3.添加Boolean对象 
		jxl.write.Boolean labelB = new jxl.write.Boolean(0,2,false); 
		sheet.addCell(labelB); 

		//4.添加DateTime对象 
		jxl.write.DateTime labelDT = new jxl.write.DateTime(0,3,new java.util.Date()); 
		sheet.addCell(labelDT); 

		//添加带有formatting的DateFormat对象 
		jxl.write.DateFormat df = new jxl.write.DateFormat("ddMMyyyyhh:mm:ss"); 
		jxl.write.WritableCellFormat wcfDF = new jxl.write.WritableCellFormat(df); 
		jxl.write.DateTime labelDTF = new jxl.write.DateTime(1,3,new java.util.Date(),wcfDF); 
		sheet.addCell(labelDTF); 

		//合并单元格
		//sheet.mergeCells(int col1,int row1,int col2,int row2);//左上角到右下角
		sheet.mergeCells(4,5,8,10);//左上角到右下角
		wfc = new jxl.write.WritableFont(WritableFont.ARIAL,40,WritableFont.BOLD,false,jxl.format.UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.GREEN); 
		jxl.write.WritableCellFormat wchB = new jxl.write.WritableCellFormat(wfc); 
		wchB.setAlignment(jxl.format.Alignment.CENTRE);
		labelCFC = new jxl.write.Label(4,5,"单元合并",wchB); 
		sheet.addCell(labelCFC); //


		//设置边框
		jxl.write.WritableCellFormat wcsB = new jxl.write.WritableCellFormat(); 
		wcsB.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THICK);
		labelCFC = new jxl.write.Label(0,6,"边框设置",wcsB); 
		sheet.addCell(labelCFC); 		
		
		workbook.write();		// 输出到文件
		workbook.close();		// 关闭文件
	}

}
