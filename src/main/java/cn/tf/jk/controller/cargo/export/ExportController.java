package cn.tf.jk.controller.cargo.export;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tf.jk.controller.BaseController;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.ExportC;
import cn.tf.jk.service.ExportCService;


@Controller
public class ExportController extends BaseController{
	@Autowired
	private ExportCService   exportCService;
	
	@RequestMapping("/cargo/export/list.action")
	public String list(Model model){
		List<ExportC> dataList = exportCService.find(null);
	
		model.addAttribute("dataList",dataList)	;
		
		return "/cargo/export/jExportList.jsp";
	}
	
	//购销合同列表查询
	@RequestMapping("/cargo/export/contractlist.action")
	public String contractList(Model model){
		List<ContractC> dataList = exportCService.getContractList();
		model.addAttribute("dataList",dataList)	;
		
		return "/cargo/export/jContractList.jsp";
	
	}
	
	
	//报运新增
	@RequestMapping("/cargo/export/insert.action")
	public String insert(@RequestParam("contractId")String[] contractIds){
		exportCService.insert(contractIds);
		return "redirect:/cargo/export/list.action";
	}
	
	//修改
	@RequestMapping("/cargo/export/toUpdate.action")
	public String toUpdate(String exportId,Model model){
		ExportC obj=exportCService.get(exportId);
		model.addAttribute("obj",obj);
		return "/cargo/export/jExportUpdate.jsp";
		
	}
	
	@RequestMapping("/cargo/export/update.action")
	public String update(ExportC exportC){
		exportCService.update(exportC);
		return "redirect:/cargo/export/list.action";
	}
	
	//上报
	@RequestMapping("/cargo/export/submit.action")
	public String submit(@RequestParam("exportId") String[] exportIds){
		exportCService.submit(exportIds);
		return "redirect:/cargo/export/list.action";
	}
	//取消
	@RequestMapping("/cargo/export/cancel.action")
	public String cancel(@RequestParam("exportId") String[] exportIds){
		exportCService.cancel(exportIds);
		return "redirect:/cargo/export/list.action";
	}
	
	//删除
	@RequestMapping("/cargo/export/delete.action")
	public String delete(@RequestParam("exportId") String[] exportIds){
		exportCService.delete(exportIds);
		return "redirect:/cargo/export/list.action";
	}

}
