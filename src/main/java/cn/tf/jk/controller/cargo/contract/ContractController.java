package cn.tf.jk.controller.cargo.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tf.jk.controller.BaseController;
import cn.tf.jk.po.ContractC;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.service.ContractCService;
import cn.tf.jk.vo.ContractVO;

@Controller
public class ContractController extends  BaseController{
	
	@Autowired
	private ContractCService contractCService;
	
	@RequestMapping("/cargo/contract/list.action")
	public String list(Model model){
		List<ContractC> dataList = contractCService.find(null);
		model.addAttribute("dataList",dataList);
		
		return "/cargo/contract/jContractList.jsp";
	}
	
	//转向新增页面
		@RequestMapping("/cargo/contract/toCreate.action")
		public String toCreate(){
			return "/cargo/contract/jContractCreate.jsp";
		}
		
		@RequestMapping("/cargo/contract/insert.action")
		public String insert(ContractC  contractC){
			contractCService.insert(contractC);
			return "redirect:/cargo/contract/list.action";
		}
	
		//转向修改页面
		@RequestMapping("/cargo/contract/toUpdate.action")
		public  String toUpdate(String contractId,Model model){
			ContractC obj = contractCService.get(contractId);
			model.addAttribute("obj",obj);
			return "/cargo/contract/jContractUpdate.jsp";
		}
		
		@RequestMapping("/cargo/contract/update.action")
		public String update(ContractC contractC){
			contractCService.update(contractC);
			return "redirect:/cargo/contract/list.action";
		}
		
		//删除多个
		@RequestMapping("/cargo/contract/delete.action")
		public String delete(@RequestParam("contractId") String[] contractIds){
			contractCService.delete(contractIds);
			return "redirect:/cargo/contract/list.action";
		}
		
		//查看
		@RequestMapping("/cargo/contract/toView.action")
		public String toview(String contractId,Model model){
			ContractVO obj = contractCService.view(contractId);
			model.addAttribute("obj",obj);
			return "/cargo/contract/jContractView.jsp";
		}
		
		//上报
		@RequestMapping("/cargo/contract/submit.action")
		public String submit(@RequestParam("contractId") String[] contractIds){
			contractCService.submit(contractIds);
			return "redirect:/cargo/contract/list.action";
		}
		
		//取消
		@RequestMapping("/cargo/contract/cancel.action")
		public String cancel(@RequestParam("contractId") String[] contractIds){
			contractCService.cancel(contractIds);
			return "redirect:/cargo/contract/list.action";
		}
	

}
