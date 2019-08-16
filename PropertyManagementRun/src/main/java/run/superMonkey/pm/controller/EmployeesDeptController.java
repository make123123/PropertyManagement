package run.superMonkey.pm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.EmployessDeptEntity;
import run.superMonkey.pm.service.EmployeesDeptService;
import run.superMonkey.pm.utils.ResultMessage;

@RestController
@RequestMapping("/employees/dept")
public class EmployeesDeptController {
	@Autowired
	private EmployeesDeptService eds=null;
	@RequestMapping("/get/list")
	public ResultMessage<EmployessDeptEntity> getListByAll()throws Exception{
		ResultMessage<EmployessDeptEntity> result=new ResultMessage<EmployessDeptEntity>("OK","取得员工列表分页成功");
		result.setList(eds.getListByALL());
		return result;
	}
	
}
