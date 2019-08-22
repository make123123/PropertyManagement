package run.superMonkey.pm.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.EmployessDeptEntity;
import run.superMonkey.pm.service.EmployeesDeptService;
import run.superMonkey.pm.utils.ResultMessage;

@RestController
@RequestMapping("/employees/dept")
public class EmployeesDeptController {
	@Autowired
	private EmployeesDeptService eds=null;
	
	@RequestMapping("/add")
	public ResultMessage<EmployessDeptEntity> add (	
			@RequestParam(required = false)Integer deptno,
			@RequestParam(required = false)String deptname)throws Exception{
		EmployessDeptEntity ede=new EmployessDeptEntity();
		ede.setDeptno(deptno);
		ede.setDeptname(deptname);
		eds.insert(ede);
		return new ResultMessage<EmployessDeptEntity>("OK","增加员工成功");
	}
	
	@RequestMapping("/delete")
	public ResultMessage<EmployessDeptEntity>delete(Integer deptno)throws Exception{
		eds.delete(deptno);
		return new ResultMessage<EmployessDeptEntity>("OK","删除部门成功");
		}
	@RequestMapping("/modify")
	public ResultMessage<EmployessDeptEntity> modify(
			@RequestParam(required = false)Integer deptno,
			@RequestParam(required = false)String deptname) throws Exception{
		EmployessDeptEntity em=new EmployessDeptEntity();
		em.setDeptno(deptno);
		em.setDeptname(deptname);
		eds.update(em);
		return new ResultMessage<EmployessDeptEntity>("OK","修改部门成功");
		
	}
	@RequestMapping("/get")
	public EmployessDeptEntity getById(Integer deptno)throws Exception{
		return eds.selectById(deptno);
	}		
	@RequestMapping("/get/list")
	public ResultMessage<EmployessDeptEntity> getListByAll(
		    @RequestParam(required = false,defaultValue = "1") int page,
		    @RequestParam(required = false,defaultValue ="2") int rows)throws Exception{
		ResultMessage<EmployessDeptEntity> result=new ResultMessage<EmployessDeptEntity>("OK","取得员工列表分页成功");
		result.setCount(eds.getCountByCondition());
		result.setPageCount(eds.getPageCountByCondition(rows));
		result.setList(eds.getListByPage(page,rows));
		result.setPage(page);
		result.setRows(rows);
		return result;
	}
	
	//验证部门ID是否存在，如果存在则不合法，不存在则合法，用于增加部门时检查ID是否已经存在
			@GetMapping(value="/checkidexist")
			public boolean checkIdExist(Integer deptno) throws Exception{
				return !eds.checkIdExist(deptno);
			}
}
