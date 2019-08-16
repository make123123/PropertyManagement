package run.superMonkey.pm.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.EmployessEntity;
import run.superMonkey.pm.service.EmployeesService;
import run.superMonkey.pm.utils.ResultMessage;

@RestController
@RequestMapping("/employees/emp")
public class EmployeesController {
	@Autowired
	private EmployeesService es=null;
	@RequestMapping("/add")
	public ResultMessage<EmployessEntity> add(EmployessEntity e)throws Exception{
		ResultMessage<EmployessEntity> result=new ResultMessage<EmployessEntity>("OK","增加员工成功");
		result.setModel(es.insert(e));
		return result;
		
	}
	@RequestMapping("/get/list")
	public ResultMessage<EmployessEntity> getListByAll()throws Exception{
		ResultMessage<EmployessEntity> result=new ResultMessage<EmployessEntity>("OK","取得员工列表分页成功");
		result.setList(es.getListByAll());
		return result;
	}
	
}
