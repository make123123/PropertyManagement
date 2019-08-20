package run.superMonkey.pm.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResultMessage<EmployessEntity> add(
			@RequestParam(required = false)Integer empid,
			@RequestParam(required = false)Integer deptno,
			@RequestParam(required = false)String empname,
			@RequestParam(required = false)String sex,
			@RequestParam(required = false)Integer age,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date joindate,
			@RequestParam(required = false)String job,
			@RequestParam(required = false)String wx)throws Exception{
		EmployessEntity em=new EmployessEntity();
		em.setEmpid(empid);
		em.setDeptno(deptno);
		em.setEmpname(empname);
		em.setSex(sex);
		em.setAge(age);
		em.setJoindate(joindate);
		em.setJob(job);
		em.setWx(wx);
		es.insert(em);
		return new ResultMessage<EmployessEntity>("OK","增加员工成功");
	}
	
	@PostMapping("/get/list")
	public ResultMessage<EmployessEntity> getListByAll(
			@RequestParam(required = false,defaultValue ="0") int deptno,
			@RequestParam(required = false,defaultValue ="") String sex,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date joindate,
		    @RequestParam(required = false,defaultValue = "1") int page,
		    @RequestParam(required = false,defaultValue ="10") int rows)throws Exception{
		ResultMessage<EmployessEntity> result=new ResultMessage<EmployessEntity>("OK","取得员工列表分页成功");
		result.setCount(es.getCountByCondition(deptno, sex, joindate));
		result.setPageCount(es.getPageCountByCondition(deptno, sex, joindate, rows));
		result.setList(es.getListByPage(deptno,sex,joindate,page,rows));
		result.setPage(page);
		result.setRows(rows);
		return result;
	}
	
	//验证员工ID是否存在，如果存在则不合法，不存在则合法，用于增加员工时检查ID是否已经存在
		@GetMapping(value="/checkidexist")
		public boolean checkIdExist(Integer empid) throws Exception{
			return !es.checkIdExist(empid);
		}
		
	
}
