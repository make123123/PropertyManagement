package run.superMonkey.pm.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.EmployessEvaluationEntity;
import run.superMonkey.pm.service.EmployeesEvaluationService;
import run.superMonkey.pm.utils.ResultMessage;

@RestController
@RequestMapping("/employees/evaluation")
public class EmployeesEvaluationController {
	@Autowired
	private EmployeesEvaluationService ees=null;
	@RequestMapping("/add")
	public ResultMessage<EmployessEvaluationEntity> add(
			@RequestParam(required = false)Integer evaluationno,
			@RequestParam(required = false)Integer empname,
			@RequestParam(required = false)String grade,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date evaluationdate) throws Exception{
		EmployessEvaluationEntity em=new EmployessEvaluationEntity();
		em.setEvaluationno(evaluationno);
		em.setEmpid(empname);
		em.setEvaluationgrade(grade);
		em.setEvaluationdate(evaluationdate);
		ees.insert(em);
		return new ResultMessage<EmployessEvaluationEntity>("OK","增加员工考评记录成功");
	}
	
	@RequestMapping("/delete")
	public ResultMessage<EmployessEvaluationEntity>delete(Integer evaluationno)throws Exception{
		ees.delete(evaluationno);
		return new ResultMessage<EmployessEvaluationEntity>("OK","删除员工考评记录成功");
		}
	@RequestMapping("/modify")
	public ResultMessage<EmployessEvaluationEntity> modify(
			@RequestParam(required = false)Integer empid,
			@RequestParam(required = false)Integer deptno,
			@RequestParam(required = false)String empname,
			@RequestParam(required = false)String sex,
			@RequestParam(required = false)Integer age,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date joindate,
			@RequestParam(required = false)String job,
			@RequestParam(required = false)String wx) throws Exception{
		EmployessEvaluationEntity em=new EmployessEvaluationEntity();
		em.setEmpid(empid);
		return new ResultMessage<EmployessEvaluationEntity>("OK","修改员工考评记录成功");
		
	}
	@RequestMapping("/get")
	public EmployessEvaluationEntity getById(Integer evaluationno)throws Exception{
		return ees.selectById(evaluationno);
	}
	@RequestMapping("/get/list")
	public ResultMessage<EmployessEvaluationEntity> getListByAll(
			@RequestParam(required = false,defaultValue ="0") int empid,
			@RequestParam(required = false) String evaluationgrade,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date evaluationdate,
		    @RequestParam(required = false,defaultValue = "1") int page,
		    @RequestParam(required = false,defaultValue ="10") int rows)throws Exception{
		ResultMessage<EmployessEvaluationEntity> result=new ResultMessage<EmployessEvaluationEntity>("OK","取得员工考评列表分页成功");
		result.setCount(ees.getCountByCondition(empid, evaluationgrade, evaluationdate));
		result.setPageCount(ees.getPageCountByCondition(empid, evaluationgrade, evaluationdate, rows));
		result.setList(ees.getListByPage(empid,evaluationgrade,evaluationdate,page,rows));
		result.setPage(page);
		result.setRows(rows);
		return result;
	}
	
	//验证员工考评编号ID是否存在，如果存在则不合法，不存在则合法，用于增加员工时检查ID是否已经存在
		@GetMapping(value="/checkidexist")
		public boolean checkIdExist(Integer evaluationno) throws Exception{
			return !ees.checkIdExist(evaluationno);
		}
	
    //验证员工考评日期是不是大于入职员工的入职日期，如果大于则合法，如果小于则不合法
		@GetMapping(value="/checkdate")
		public boolean checkDate(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false)Date evaluationdate)throws Exception {
			return !ees.checkDate(evaluationdate);
		}

	
}
