package cn.tf.jk.controller.cargo.outproduct;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tf.jk.controller.BaseController;
import cn.tf.jk.service.OutProductService;
import cn.tf.jk.util.DownloadUtil;
import cn.tf.jk.vo.OutProductVO;

@Controller
public class OutProductController extends BaseController{
	
	@Autowired
	private OutProductService outProductService;
	
	
	//转向输入年月的页面
	@RequestMapping("/cargo/outproduct/toEdit.action")
	public String toEdit(){
		return "/cargo/outproduct/jOutProduct.jsp";
	}
	//方案3
	//XSSF
		@RequestMapping("/cargo/outproduct/printXSSF.action")
		public void printTempleXSSF(String inputDate,HttpServletRequest request,HttpServletResponse  response) throws IOException{
			List<OutProductVO> dataList = outProductService.find(inputDate);
			
			//获取模板存放的路径
			String path=request.getSession().getServletContext().getRealPath("/")+"/make/xlsprint/";
			InputStream  is=new FileInputStream(new File(path+"出货表.xlsx"));
			
			
			Workbook wb=new XSSFWorkbook(is);  //2007版本
			Sheet sheet = wb.getSheetAt(0);
			Row nRow=null;
			Cell nCell=null;
			
			//行号
			int  rowNo=0;
			//列号
			int colNo=1;
			
			//获取模板上的单元格样式
			
			nRow=sheet.getRow(2);
			
			//客户的样式
			nCell=nRow.getCell(1);
			CellStyle customStyle=nCell.getCellStyle();
			//订单的样式
			nCell=nRow.getCell(2);
			CellStyle contractNoStyle=nCell.getCellStyle();
			//货号的样式
			nCell=nRow.getCell(3);
			CellStyle productNoStyle=nCell.getCellStyle();
			//数量的样式
			nCell=nRow.getCell(4);
			CellStyle numStyle=nCell.getCellStyle();
			//生产厂家的样式
			nCell=nRow.getCell(5);
			CellStyle factoryStyle=nCell.getCellStyle();
			//日期的样式
			nCell=nRow.getCell(6);
			CellStyle dateStyle=nCell.getCellStyle();
			//贸易条款
			nCell=nRow.getCell(8);
			CellStyle tradeStyle=nCell.getCellStyle();
			
			
			//大标题
			nRow=sheet.getRow(rowNo++);  //获取一个行对象
			nCell=nRow.getCell(colNo);  //获取一个单元格对象
			nCell.setCellValue(inputDate.replace("-0", "年").replaceFirst("-", "年")+"月份出货表");
			
			//跳过静态表格头
			rowNo++;

			
			//换行
			for(int j=0;j<dataList.size();j++){
				OutProductVO op=dataList.get(j);
				colNo=1;
				
				nRow=sheet.createRow(rowNo++);
				
				nCell=nRow.createCell(colNo++);
				nCell.setCellValue(op.getCustomName());
				nCell.setCellStyle(customStyle);
				
				
				nCell=nRow.createCell(colNo++);
				nCell.setCellValue(op.getContractNo());
				nCell.setCellStyle(contractNoStyle);
				
				
				nCell=nRow.createCell(colNo++);
				nCell.setCellValue(op.getProductNo());
				nCell.setCellStyle(productNoStyle);
				
				
				nCell=nRow.createCell(colNo++);
				nCell.setCellValue(op.getCnumber());
				nCell.setCellStyle(numStyle);
				
				
				
				nCell=nRow.createCell(colNo++);
				nCell.setCellValue(op.getFactoryName());
				nCell.setCellStyle(factoryStyle);
				
				
				
				nCell=nRow.createCell(colNo++);
				nCell.setCellValue(op.getDeliveryPeriod());
				nCell.setCellStyle(dateStyle);
				
				
				nCell=nRow.createCell(colNo++);
				nCell.setCellValue(op.getSpipTime());
				nCell.setCellStyle(dateStyle);
				
				
				nCell=nRow.createCell(colNo++);
				nCell.setCellValue(op.getTradeTerms());
				nCell.setCellStyle(tradeStyle);
			}
			
			//下载
			DownloadUtil dUtil=new DownloadUtil();
			ByteArrayOutputStream os=new ByteArrayOutputStream();
			wb.write(os);
			dUtil.download(os, response, "出货表.xlsx");
			os.flush();
			os.close();
		
		}
	
	
	
	
	//方案2
	//模板
	@RequestMapping("/cargo/outproduct/printTemple.action")
	public void printTemple(String inputDate,HttpServletRequest request,HttpServletResponse  response) throws IOException{
		List<OutProductVO> dataList = outProductService.find(inputDate);
		
		//获取模板存放的路径
		String path=request.getSession().getServletContext().getRealPath("/")+"/make/xlsprint/";
		InputStream  is=new FileInputStream(new File(path+"出货表.xls"));
		
		
		Workbook wb=new HSSFWorkbook(is);
		Sheet sheet = wb.getSheetAt(0);
		Row nRow=null;
		Cell nCell=null;
		
		//行号
		int  rowNo=0;
		//列号
		int colNo=1;
		
		//获取模板上的单元格样式
		
		nRow=sheet.getRow(2);
		
		//客户的样式
		nCell=nRow.getCell(1);
		CellStyle customStyle=nCell.getCellStyle();
		//订单的样式
		nCell=nRow.getCell(2);
		CellStyle contractNoStyle=nCell.getCellStyle();
		//货号的样式
		nCell=nRow.getCell(3);
		CellStyle productNoStyle=nCell.getCellStyle();
		//数量的样式
		nCell=nRow.getCell(4);
		CellStyle numStyle=nCell.getCellStyle();
		//生产厂家的样式
		nCell=nRow.getCell(5);
		CellStyle factoryStyle=nCell.getCellStyle();
		//日期的样式
		nCell=nRow.getCell(6);
		CellStyle dateStyle=nCell.getCellStyle();
		//贸易条款
		nCell=nRow.getCell(8);
		CellStyle tradeStyle=nCell.getCellStyle();
		
		
		//大标题
		nRow=sheet.getRow(rowNo++);  //获取一个行对象
		nCell=nRow.getCell(colNo);  //获取一个单元格对象
		nCell.setCellValue(inputDate.replace("-0", "年").replaceFirst("-", "年")+"月份出货表");
		
		//跳过静态表格头
		rowNo++;

		
		//换行
		for(int j=0;j<dataList.size();j++){
			OutProductVO op=dataList.get(j);
			colNo=1;
			
			nRow=sheet.createRow(rowNo++);
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getCustomName());
			nCell.setCellStyle(customStyle);
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getContractNo());
			nCell.setCellStyle(contractNoStyle);
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getProductNo());
			nCell.setCellStyle(productNoStyle);
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getCnumber());
			nCell.setCellStyle(numStyle);
			
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getFactoryName());
			nCell.setCellStyle(factoryStyle);
			
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getDeliveryPeriod());
			nCell.setCellStyle(dateStyle);
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getSpipTime());
			nCell.setCellStyle(dateStyle);
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getTradeTerms());
			nCell.setCellStyle(tradeStyle);
		}
		
		//下载
		DownloadUtil dUtil=new DownloadUtil();
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		wb.write(os);
		dUtil.download(os, response, "出货表.xls");
		os.flush();
		os.close();
	
	}
	
	//方案1
	@RequestMapping("/cargo/outproduct/print.action")
	public void print(String inputDate,HttpServletResponse  response) throws IOException{
		List<OutProductVO> dataList = outProductService.find(inputDate);
		
		Workbook wb=new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		Row nRow=null;
		Cell nCell=null;
		
		//行号
		int  rowNo=0;
		//列号
		int colNo=1;
		
		//声明样式对象和字体对象
		CellStyle nStyle=wb.createCellStyle();
		Font font = wb.createFont();
		
		//列宽
		sheet.setColumnWidth(0,2*300);
		sheet.setColumnWidth(1,26*300);
		sheet.setColumnWidth(2,12*300);
		sheet.setColumnWidth(3,29*300);
		sheet.setColumnWidth(4,10*300);
		sheet.setColumnWidth(5,12*300);
		sheet.setColumnWidth(6,8*300);
		sheet.setColumnWidth(7,10*300);
		sheet.setColumnWidth(8,10*300);
		sheet.setColumnWidth(9,9*300);
		
		
		
		//大标题，合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,1,9));  //开始行，结束行，开始列，结束列
		//合并单元格的内容写在合并前第一个单元格中
		nRow=sheet.createRow(rowNo++);
		
		nRow.setHeightInPoints(36);
		
		
		
		
		nCell=nRow.createCell(1);
		nCell.setCellValue(inputDate.replace("-0", "年").replaceFirst("-", "年")+"月份出货表");
		nCell.setCellStyle(this.bigTitle(wb, nStyle, font));
		
		
		
		String[] title=new 	String[]{"客户","订单号","货号","数量","工厂","附件","工厂交期","船期","贸易条款"  };
		
		nRow=sheet.createRow(rowNo++);
		nRow.setHeightInPoints(26.25f);
		
		//初始化
		nStyle=wb.createCellStyle();
		font=wb.createFont();
	
		for(int  i=0;i<title.length;i++){
			nCell=nRow.createCell(i+1);
			nCell.setCellValue(title[i]);
			nCell.setCellStyle(this.Title(wb, nStyle, font));
			
		}
		//初始化
		nStyle=wb.createCellStyle();
		font=wb.createFont();
		
		//换行
		for(int j=0;j<dataList.size();j++){
			OutProductVO op=dataList.get(j);
			colNo=1;
			
			nRow=sheet.createRow(rowNo++);
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getCustomName());
			nCell.setCellStyle(this.Text(wb, nStyle, font));
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getProductNo());
			nCell.setCellStyle(this.Text(wb, nStyle, font));
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getContractNo());
			nCell.setCellStyle(this.Text(wb, nStyle, font));
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getCnumber());
			nCell.setCellStyle(this.Text(wb, nStyle, font));
			
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getFactoryName());
			nCell.setCellStyle(this.Text(wb, nStyle, font));
			
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getExts());
			nCell.setCellStyle(this.Text(wb, nStyle, font));
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getDeliveryPeriod());
			nCell.setCellStyle(this.Text(wb, nStyle, font));
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getSpipTime());
			nCell.setCellStyle(this.Text(wb, nStyle, font));
			
			
			nCell=nRow.createCell(colNo++);
			nCell.setCellValue(op.getTradeTerms());
			nCell.setCellStyle(this.Text(wb, nStyle, font));
			
			
		}
		
		

		//OutputStream  os=new FileOutputStream(new File("D:\\outProduct.xls"));
		/*wb.write(os);
		os.flush();
		os.close();*/
		
		//下载
		DownloadUtil dUtil=new DownloadUtil();
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		wb.write(os);
		dUtil.download(os, response, "出货表.xls");
		
	
	}
	
	//大标题的样式
	public CellStyle bigTitle(Workbook wb,CellStyle nStyle,Font font){
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 16);	
		//字体加粗
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		//横向居中
		nStyle.setAlignment(CellStyle.ALIGN_CENTER);
		//纵向居中
		nStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//单元格垂直居中
		
		nStyle.setFont(font);
		return nStyle;
	}
	
	//标题样式
	public CellStyle Title(Workbook wb,CellStyle nStyle,Font font){
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 12);	

		//横向居中
		nStyle.setAlignment(CellStyle.ALIGN_CENTER);
		//纵向居中
		nStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//单元格垂直居中
		
		//表格线
		nStyle.setBorderTop(CellStyle.BORDER_THICK);			//粗实线
		nStyle.setBorderBottom(CellStyle.BORDER_THIN);			//实线
		nStyle.setBorderLeft(CellStyle.BORDER_THIN);			//比较粗实线
		nStyle.setBorderRight(CellStyle.BORDER_THIN);			//实线
		
		nStyle.setFont(font);
		return nStyle;
	}
	
	//文字样式
	public CellStyle Text(Workbook wb,CellStyle nStyle,Font font){
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 10);	
	
		//横向居中
		nStyle.setAlignment(CellStyle.ALIGN_CENTER);
		//纵向居中
		nStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//单元格垂直居中
		
		//表格线

		nStyle.setBorderBottom(CellStyle.BORDER_THIN);			//实线
		nStyle.setBorderLeft(CellStyle.BORDER_THIN);			//比较粗实线
		nStyle.setBorderRight(CellStyle.BORDER_THIN);			//实线
		
		nStyle.setFont(font);
		return nStyle;
	}
	
	
	
	
	
	

}
