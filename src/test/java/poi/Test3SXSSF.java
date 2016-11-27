package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.junit.Test;

/**
 * @Description:  poi实现输出信息到excel文件
 */
public class Test3SXSSF {
	public static void main(String[] args) throws Exception {
		Test3SXSSF tm = new Test3SXSSF();
		tm.jdbcex(true);
	}
	
	@Test
	public void print() throws Exception{
		String xlsFile = "c:/poiSXXFSBigData.xlsx";
		Workbook wb = new SXSSFWorkbook(100);
		Sheet sheet = wb.createSheet("我的第一个工作簿");		//建立新的sheet对象

		Row nRow = null;
		Cell nCell   = null;
		
		for(int i=0;i<100;i++){
			nRow = sheet.createRow(i);
			for(int j=0;j<20;j++){
				nCell = nRow.createCell(j);
				nCell.setCellValue("我是单元格");
				nCell.setCellStyle(style(wb));
			}
				System.out.println(i);
		}
		FileOutputStream fOut = new FileOutputStream(xlsFile);
		wb.write(fOut);
		fOut.flush();
		fOut.close();
		
		System.out.println("finish.");
	}		

	@Test
	public void jdbcex(boolean isClose) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException, InterruptedException {
		String xlsFile = "c:/poiSXXFSDBBigData.xlsx";					//输出文件
		Workbook wb = new SXSSFWorkbook(100);				//创建excel文件，内存只有100条记录【关键语句】
		Sheet sheet = wb.createSheet("我的第一个工作簿");		//建立新的sheet对象

		Row nRow = null;
		Cell nCell   = null;

		//使用jdbc链接数据库
		Class.forName("com.mysql.jdbc.Driver").newInstance();  
		
		String url = "jdbc:mysql://localhost:3306/jkmore100?characterEncoding=UTF-8";
		String user = "root";
		String password = "root";
		
		Connection conn = DriverManager.getConnection(url, user,password);   
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   

		String sql = "select name,age,des from customer limit 300";   	//100万测试数据
		ResultSet rs = stmt.executeQuery(sql);  						//bug 要分次读取，否则记录过多
		
		
		long  startTime = System.currentTimeMillis();	//开始时间
		System.out.println("strat execute time: " + startTime);
		//context
		int rowNo = 0;
		int colNo = 0;
		while(rs.next()) {
			colNo = 0;
			nRow = sheet.createRow(rowNo++);

			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(rs.getString(colNo));
			
			nCell = nRow.createCell(colNo++);
			nCell.setCellValue(rs.getString(colNo));
			
			if(rowNo%100==0){
				System.out.println("row no: " + rowNo);
			}
			
			Thread.sleep(1);			//休息一下，防止对CPU占用
		}
		
		long finishedTime = System.currentTimeMillis();	//处理完成时间
		System.out.println("finished execute  time: " + (finishedTime - startTime)/1000 + "m");
		
		
		FileOutputStream fOut = new FileOutputStream(xlsFile);
		wb.write(fOut);
		fOut.flush();
		fOut.close();
		
		long stopTime = System.currentTimeMillis();		//写文件时间
		System.out.println("write xlsx file time: " + (stopTime - startTime)/1000 + "m");
		
		if(isClose){
			this.close(rs, stmt, conn);
		}
	}
	
	//close resource
	private void close(ResultSet rs, Statement stmt, Connection conn ) throws SQLException{
		rs.close();   
		stmt.close();   
		conn.close(); 
	}	
	
	//设置单元格样式
	private CellStyle style(Workbook wb){
		CellStyle curStyle = wb.createCellStyle();
		Font curFont = wb.createFont();								//设置字体
		curFont.setFontName("微软雅黑");								//设置英文字体
		curFont.setCharSet(XSSFFont.DEFAULT_CHARSET);					//设置中文字体，那必须还要再对单元格进行编码设置
		curFont.setFontHeightInPoints((short)10);						//字体大小
		curStyle.setFont(curFont);
		
		curStyle.setBorderTop(XSSFCellStyle.BORDER_THICK);				//粗实线
		curStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);			//实线
		curStyle.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);			//比较粗实线
		curStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);				//实线
		
		curStyle.setWrapText(true);  									//换行   
		curStyle.setAlignment(XSSFCellStyle.ALIGN_RIGHT);				//横向具右对齐
		curStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);	//单元格垂直居中
		
		return curStyle;
	}
}
