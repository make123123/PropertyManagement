package run.superMonkey.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.SecurityDept;
import run.superMonkey.pm.service.SecurityDeptService;


@RestController
@RequestMapping("/securitydept")
public class SecurityDeptController {
	
	@Autowired
	private SecurityDeptService sd;
	
	@RequestMapping("/add")
	public void add(int securityno,String securityname) throws Exception{
		SecurityDept securityDept = new SecurityDept();
		securityDept.setSecurityno(securityno);
		securityDept.setSecurityname(securityname);
		sd.register(securityDept);
	}
	
	@RequestMapping("/modify")
	public void modify(int securityno,String securityname) throws Exception{
		SecurityDept securityDept = sd.getByPrimaryKey(securityno);
		securityDept.setSecurityname(securityname);
		sd.update(securityDept);
	}
	
	@RequestMapping("/delete")
	public void delete(int securityno) throws Exception{
		sd.delete(securityno);
	}
		
	@RequestMapping("/get")
	public SecurityDept get() throws Exception{	
		return sd.getByPrimaryKey(1);
	}
	
	@RequestMapping("/getall")
	public List<SecurityDept> getAll() throws Exception{	
		return sd.selectListByAll();
	}
	
	
}
