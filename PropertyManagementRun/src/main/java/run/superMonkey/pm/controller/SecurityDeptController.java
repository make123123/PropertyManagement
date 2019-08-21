package run.superMonkey.pm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import run.superMonkey.pm.utils.ResultMessage;
import run.superMonkey.pm.model.entity.SecurityDept;
import run.superMonkey.pm.service.SecurityDeptService;


@RestController
@RequestMapping(value="/securitydept")
public class SecurityDeptController {
	
	@Autowired
	private SecurityDeptService sd;
	
	@RequestMapping("/add")
	public void add(int securityno,String securityname,String securitysex,int securityage) throws Exception{
		SecurityDept securityDept = new SecurityDept();
		securityDept.setSecurityno(securityno);
		securityDept.setSecurityname(securityname);
		securityDept.setSecuritysex(securitysex);
		securityDept.setSecurityage(securityage);
		sd.register(securityDept);
	}
	
	@RequestMapping("/modify")
	public void modify(int securityno,String securityname,int securityage) throws Exception{
		SecurityDept securityDept = sd.getByPrimaryKey(securityno);
		securityDept.setSecurityname(securityname);
		securityDept.setSecurityage(securityage);
		sd.update(securityDept);
	}
	
	@RequestMapping("/delete")
	public void delete(Integer securityno) throws Exception{
		sd.delete(securityno);
	}
		
	@RequestMapping("/get")
	public SecurityDept get(int securityno) throws Exception{	
		return sd.getByPrimaryKey(securityno);
	}
	
	@RequestMapping("/getall")
	public List<SecurityDept> getAll() throws Exception{	
		return sd.selectListByAll();
	}
	
	//按检索条件取得员工列表
	@GetMapping(value = "/list/condition/page")
	public ResultMessage<SecurityDept> getListByConditionWitPage(@RequestParam(required = false,defaultValue ="0") String securitysex,@RequestParam(required = false,defaultValue ="0") Integer securityage, @RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<SecurityDept> result = new ResultMessage<SecurityDept>("OK","取得保安列表分页成功");
		result.setCount(sd.getCountByConditionWithSecurityNoWithPage(securitysex, securityage));
		result.setPageCount(sd.getPageCountByConditionWithSecurityNoWithPage(securitysex, securityage, rows));
		result.setList(sd.getListByConditionWithSecurityWithPage(securitysex, securityage, rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//验证员工ID是否存在，如果存在则不合法，不存在则合法，用于增加员工时检查ID是否已经存在
	@GetMapping(value="/checkidexist")
	public boolean checkIdExist(String securityno) throws Exception{
		return !sd.checkIdExist(securityno);
	}
	
}
