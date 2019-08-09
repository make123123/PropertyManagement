package run.superMonkey.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import run.superMonkey.pm.model.entity.Test;
import run.superMonkey.pm.service.TestService;

@Controller
public class TestController {
	
	public TestController(TestService ts) {
		this.ts = ts;
	}
	
	
	@Autowired
	private final TestService ts;
	
	
	@RequestMapping("/test")
	@ResponseBody
	public String testController() {
		List<Test> list = ts.queryAll();
		System.out.println("aaa");
		return list.toString();
		
		
	}
}
