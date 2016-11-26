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
import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.ExtCproductC;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.service.ContractCService;
import cn.tf.jk.service.ExtCproductService;
import cn.tf.jk.service.FactoryCService;

@Controller
public class ExtCproductController extends  BaseController{
	
	@Autowired
	private ExtCproductService extCproductService;
	@Autowired
	private FactoryCService factoryCService;

	
	//转向新增页面
		@RequestMapping("/cargo/extproduct/toCreate.action")
		public String toCreate(String contractProductId,Model model){
			//准备列表数据
			Map paraMap=new HashMap();
			paraMap.put("contractProductId", contractProductId);
			List<ExtCproductC>  dataList=extCproductService.find(paraMap);
			model.addAttribute("dataList",dataList);
			//生产厂家
			List<FactoryC>  factoryList=factoryCService.getFactoryList();
			model.addAttribute("factoryList",factoryList);
			
			
			return "/cargo/contract/jExtCproductCreate.jsp";
		}
		
		@RequestMapping("/cargo/extproduct/insert.action")
		public String insert(ExtCproductC  extCproductC,Model model){
			extCproductService.insert(extCproductC);
			model.addAttribute("contractProductId",extCproductC.getContractProductId());
			return "/cargo/extproduct/toCreate.action";
		}
	
		/*//转向修改页面
		@RequestMapping("/cargo/contract/toUpdate.action")
		public  String toUpdate(String contractId,Model model){
			ContractC obj = extCproductService.get(contractId);
			model.addAttribute("obj",obj);
			return "/cargo/contract/jContractUpdate.jsp";
		}
		
		@RequestMapping("/cargo/contract/update.action")
		public String update(ContractC contractC){
			extCproductService.update(contractC);
			return "redirect:/cargo/contract/list.action";
		}
		
		//删除多个
		@RequestMapping("/cargo/contract/delete.action")
		public String delete(@RequestParam("contractId") String[] contractIds){
			extCproductService.delete(contractIds);
			return "redirect:/cargo/contract/list.action";
		}
		
		//查看
		@RequestMapping("/cargo/contract/toView.action")
		public String toview(String contractId,Model model){
			ContractC obj = extCproductService.get(contractId);
			model.addAttribute("obj",obj);
			return "/cargo/contract/jContractView.jsp";
		}*/
		


}
