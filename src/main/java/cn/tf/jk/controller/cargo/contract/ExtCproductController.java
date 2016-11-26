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
import cn.tf.jk.po.SysCodeB;
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
			
			model.addAttribute("contractProductId",contractProductId);
			
			//分类下拉列表
			List<SysCodeB> ctypeList = extCproductService.getCtypeList();
			model.addAttribute("ctypeList",ctypeList);
			
			
			return "/cargo/contract/jExtCproductCreate.jsp";
		}
		
		@RequestMapping("/cargo/extproduct/insert.action")
		public String insert(ExtCproductC  extCproductC,Model model){
			extCproductService.insert(extCproductC);
			model.addAttribute("contractProductId",extCproductC.getContractProductId());
			return "redirect:/cargo/extproduct/toCreate.action";
		}
	
		//转向修改页面
		@RequestMapping("/cargo/extproduct/toUpdate.action")
		public  String toUpdate(String extCproductId,Model model){
			ExtCproductC obj = extCproductService.get(extCproductId);
			model.addAttribute("obj",obj);
			
			
			//生产厂家
			List<FactoryC>  factoryList=factoryCService.getFactoryList();
			model.addAttribute("factoryList",factoryList);
			
			
			//分类下拉列表
			List<SysCodeB> ctypeList = extCproductService.getCtypeList();
			model.addAttribute("ctypeList",ctypeList);

			return "/cargo/contract/jExtCproductUpdate.jsp";
		}
		
		@RequestMapping("/cargo/extproduct/update.action")
		public String update(ExtCproductC extCproductC,Model model){
			extCproductService.update(extCproductC);
			model.addAttribute("contractProductId",extCproductC.getContractProductId());
			
			return "redirect:/cargo/extproduct/toCreate.action";
		}
		
		//删除多个
		@RequestMapping("/cargo/extproduct/delete.action")
		public String delete(@RequestParam("extCproductId") String[] extCproductIds){
			extCproductService.delete(extCproductIds);
			return "redirect:/cargo/extproduct/toCreate.action";
		}
		

		


}
