package run.superMonkey.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import run.superMonkey.pm.model.entity.EmployessEntity;
import run.superMonkey.pm.service.EmployeesService;

@Controller
@RequestMapping("/employees/emp")
public class EmployeesController {
	@Autowired
	private EmployeesService es=null;
	@RequestMapping("/get/list")
	public List<EmployessEntity> getListByAll()throws Exception{
		return es.getListByAll();
	}
	
}
