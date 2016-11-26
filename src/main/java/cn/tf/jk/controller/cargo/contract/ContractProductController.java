package cn.tf.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tf.jk.controller.BaseController;
import cn.tf.jk.po.ContractProductC;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.service.ContractProductCService;
import cn.tf.jk.service.FactoryCService;

@Controller
public class ContractProductController extends  BaseController{
	
	@Autowired
	private ContractProductCService contractProductCService;
	@Autowired
	private FactoryCService factoryCService;

	
	//转向新增页面
		@RequestMapping("/cargo/contractproduct/toCreate.action")
		public String toCreate(String contractId,Model model){
			model.addAttribute("contractId",contractId);
			
			//准备下拉列表
			List<FactoryC>  factoryList=factoryCService.getFactoryList();
			model.addAttribute("factoryList",factoryList);
			
			//货物显示的列表
			Map paraMap=new HashMap();
			paraMap.put("contractId", contractId);
			List<ContractProductC> dataList = contractProductCService.find(paraMap);
			model.addAttribute("dataList",dataList);
			contractProductCService.find(paraMap);

			return "/cargo/contract/jContractProductCreate.jsp";
		}
		
		@RequestMapping("/cargo/contractproduct/insert.action")
		public String insert(ContractProductC  contractProductC,Model model){
			contractProductCService.insert(contractProductC);
			model.addAttribute("contractId",contractProductC.getContractId());
			
			return "redirect:/cargo/contractproduct/toCreate.action";
		}
		
		
	
		//转向修改页面
		@RequestMapping("/cargo/contractproduct/toUpdate.action")
		public  String toUpdate(String contractProductId,Model model){
			ContractProductC obj = contractProductCService.get(contractProductId);
			model.addAttribute("obj",obj);
			
			//准备下拉列表
			List<FactoryC>  factoryList=factoryCService.getFactoryList();
			model.addAttribute("factoryList",factoryList);
			
			return "/cargo/contract/jContractProductUpdate.jsp";
		}
		
		@RequestMapping("/cargo/contractproduct/update.action")
		public String update(ContractProductC ContractProductC){
			contractProductCService.update(ContractProductC);
			return "redirect:/cargo/contractproduct/toCreate.action";
		}
		
		//删除多个
		@RequestMapping("/cargo/contractproduct/delete.action")
		public String delete(@RequestParam("contractProductId") String[] contractProductIds){
			contractProductCService.delete(contractProductIds);
			return "redirect:/cargo/contractproduct/toCreate.action";
		}
		
		//查看
		@RequestMapping("/cargo/contractproduct/toView.action")
		public String toview(String contractProductId,Model model){
			ContractProductC obj = contractProductCService.get(contractProductId);
			model.addAttribute("obj",obj);
			return "redirect:/cargo/contractproduct/toCreate.action";
		}
		
		

}
