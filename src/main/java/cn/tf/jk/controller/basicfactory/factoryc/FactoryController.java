package cn.tf.jk.controller.basicfactory.factoryc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
