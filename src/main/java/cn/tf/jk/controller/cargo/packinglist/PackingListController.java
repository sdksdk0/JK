package cn.tf.jk.controller.cargo.packinglist;

import java.util.List;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tf.jk.controller.BaseController;
import cn.tf.jk.po.PackingListC;
import cn.tf.jk.service.PackingListCService;

@Controller
public class PackingListController  extends  BaseController {

	@Autowired
	private PackingListCService packingListCService;
	
	
	@RequestMapping("/cargo/packinglist/list.action")
	public String list(Model model){
		List<PackingListC> dataList = packingListCService.find(null);
	
		model.addAttribute("dataList",dataList);
		return "/cargo/packinglist/jPackingList.jsp";
	
	}
	
	@RequestMapping("/cargo/packinglist/toCreat.action")
	public String toCreat(@RequestParam("exportId")String[] exportIds,Model model){
		//携带出口报运的id集合
	    String divDate = packingListCService.getDivDate(exportIds);
		model.addAttribute("divDate",divDate);
		
		return "/cargo/packinglist/jPackingListCreate.jsp";
		
	}
	@RequestMapping("/cargo/packinglist/insert.action")
	public String insert(PackingListC packingListC){
		packingListCService.insert(packingListC);
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
	
	@RequestMapping("/cargo/packinglist/toUpdate.action")
	public String toupdate(String packingListId, Model model){
		PackingListC obj = packingListCService.get(packingListId);
		model.addAttribute("obj", obj);
		
		String _s = packingListCService.getDivDataUpdate(obj.getExportIds().split("\\|"), obj.getExportNos().split("\\|"));
		model.addAttribute("divDate", _s);	
				
		return "/cargo/packinglist/jPackingListUpdate.jsp";
	}
	
	@RequestMapping("/cargo/packinglist/update.action")
	public String update(PackingListC packingList){
		packingListCService.update(packingList);
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
	
	@RequestMapping("/cargo/packinglist/toView.action")
	public String toview(String packingListId, Model model){
		PackingListC obj = packingListCService.get(packingListId);
		model.addAttribute("obj", obj);
		
		model.addAttribute("divDate", packingListCService.getDivDataView(obj.getExportNos().split("\\|")));
		
		return "/cargo/packinglist/jPackingListView.jsp";
	}
	
	
	@RequestMapping("/cargo/packinglist/delete.action")
	public String delete(@RequestParam("packingListId") String[]  packingListIds){
		
		packingListCService.delete(packingListIds);
		
		
		return "redirect:/cargo/packinglist/list.action";
	}
	
	
	
}
