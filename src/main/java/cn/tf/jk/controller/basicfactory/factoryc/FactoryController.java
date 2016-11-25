package cn.tf.jk.controller.basicfactory.factoryc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tf.jk.controller.BaseController;
import cn.tf.jk.po.FactoryC;
import cn.tf.jk.service.FactoryCService;

@Controller
public class FactoryController  extends BaseController {
	
	@Autowired
	private FactoryCService  factoryCService;
	
	@RequestMapping("/basicinfo/factory/list.action")
	public String list(Model  model){
		List<FactoryC> dataList = factoryCService.find(null);
		model.addAttribute("dataList",dataList);
		return "/basicinfo/factory/jFactoryList.jsp";
	}
	
	//转向新增页面
	@RequestMapping("/basicinfo/factory/toCreate.action")
	public String toCreate(){
		return "/basicinfo/factory/jFactoryCreate.jsp";
	}
	
	@RequestMapping("/basicinfo/factory/insert.action")
	public String insert(FactoryC  factoryC){
		factoryCService.insert(factoryC);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//转向修改页面
	@RequestMapping("/basicinfo/factory/toUpdate.action")
	public  String toUpdate(String factoryId,Model model){
		FactoryC obj = factoryCService.get(factoryId);
		model.addAttribute("obj",obj);
		return "/basicinfo/factory/jFactoryUpdate.jsp";
	}
	
	@RequestMapping("/basicinfo/factory/update.action")
	public String update(FactoryC factoryC){
		factoryCService.update(factoryC);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//删除一个
	@RequestMapping("/basicinfo/factory/deleteById.action")
	public String deleteById(String factoryId){
		factoryCService.deleteById(factoryId);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//删除多个
	@RequestMapping("/basicinfo/factory/delete.action")
	public String delete(@RequestParam("factoryId") String[] factoryIds){
		factoryCService.delete(factoryIds);
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//查看
	@RequestMapping("/basicinfo/factory/toView.action")
	public String toview(String factoryId,Model model){
		FactoryC obj = factoryCService.get(factoryId);
		model.addAttribute("obj",obj);
		return "/basicinfo/factory/jFactoryView.jsp";
	}
	

}
