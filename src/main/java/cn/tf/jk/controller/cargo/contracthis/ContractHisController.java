package cn.tf.jk.controller.cargo.contracthis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tf.jk.po.ContractC;
import cn.tf.jk.service.ContractHisService;

@Controller
public class ContractHisController {
	
	@Autowired
	private ContractHisService contractHisService;
	
	
	@RequestMapping("/cargo/contracthis/list.action")
	public String list(Model model){
		List<ContractC> dataList = contractHisService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/contracthis/jContractHisList.jsp";
	
	}
	
	
	//归档
	@RequestMapping("/cargo/contracthis/pigeingole.action")
	public String pigeingole(@RequestParam("contractId") String[] contractIds){
		contractHisService.pigeinhole(contractIds);
		
		return "redirect:/cargo/contracthis/list.action";
		
	}
	
	//取消归档
		@RequestMapping("/cargo/contracthis/pigeouthole.action")
		public String pigeouthole(@RequestParam("contractId") String[] contractIds){
			contractHisService.pigeouthole(contractIds);
			
			return "redirect:/cargo/contracthis/list.action";
		}

}
