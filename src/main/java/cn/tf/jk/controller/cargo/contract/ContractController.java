package cn.tf.jk.controller.cargo.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tf.jk.controller.BaseController;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.service.ContractCService;

@Controller
public class ContractController extends  BaseController{
	
	@Autowired
	private ContractCService contractCService;
	
	@RequestMapping("/cargo.contract/list.action")
	public String list(Model model){
		List<ContractC> dataList = contractCService.find(null);
		model.addAttribute("dataList",dataList);
		
		return "/cargo/contract/jContractList.jsp";
	}
	
	
	
	

}
