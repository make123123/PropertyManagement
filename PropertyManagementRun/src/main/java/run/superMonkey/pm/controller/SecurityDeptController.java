package run.superMonkey.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.SecurityDept;
import run.superMonkey.pm.service.SecurityDeptService;


@Controller
public class SecurityDeptController {
	
	@Autowired
	private SecurityDeptService sd;
	
	
	
	@RequestMapping("/get")
	public SecurityDept get() throws Exception{
		System.out.println("get1111");	
		
		return sd.getByPrimaryKey(1);
		
	}
	
	@GetMapping("/get1")
	public String toIndex() {
		return "index";
	}
	
	
}
