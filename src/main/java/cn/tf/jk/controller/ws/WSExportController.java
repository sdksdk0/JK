package cn.tf.jk.controller.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WSExportController {
	
	@RequestMapping("/ws/export/toEdit.action")
	public String toEdit(){
		return "/ws/export/ajaxExport.jsp";
	}

}
