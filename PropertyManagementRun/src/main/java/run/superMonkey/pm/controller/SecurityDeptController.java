package run.superMonkey.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import run.superMonkey.pm.model.entity.SecurityDept;
import run.superMonkey.pm.service.SecurityDeptService;


@Controller
@RequestMapping("/securitydept")
public class SecurityDeptController {
	
	@Autowired
	private SecurityDeptService sd=null;
	
	
	
	@RequestMapping("/get")
	public String tolist(Model model) throws Exception{
		System.out.println("get1111");
		SecurityDept securityDept=sd.getByPrimaryKey(1);
		model.addAttribute("securityDept",  securityDept);
		return "security";
		
	}
	
	
}
