package run.superMonkey.pm.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import run.superMonkey.pm.model.entity.SecurityBoxRecord;
import run.superMonkey.pm.service.SecurityBoxRecordService;


@RestController
@RequestMapping(value="/securityBoxRecord")
public class SecurityBoxRecordController {
	
	@Autowired
	private SecurityBoxRecordService sb;
	
	@RequestMapping("/add")
	public void add(Double boxno,String carno,String boxdate,Double dutyno,String visitname) throws Exception{
		SecurityBoxRecord securityBoxRecord = new SecurityBoxRecord();
		securityBoxRecord.setBoxno(boxno);
		securityBoxRecord.setCarno(carno);
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		securityBoxRecord.setBoxdate(dFormat.parse(boxdate));
		securityBoxRecord.setDutyno(dutyno);
		securityBoxRecord.setVisitname(visitname);
		sb.register(securityBoxRecord);
	}
	
	@RequestMapping("/modify")
	public void modify(Double boxno,String carno,String boxdate,Double dutyno,String visitname) throws Exception{
		SecurityBoxRecord securityBoxRecord = sb.getByVisitName(visitname);
		securityBoxRecord.setBoxno(boxno);
		securityBoxRecord.setCarno(carno);
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		securityBoxRecord.setBoxdate(dFormat.parse(boxdate));
		securityBoxRecord.setDutyno(dutyno);
		securityBoxRecord.setVisitname(visitname);
		sb.update(securityBoxRecord);
	}
	
	@RequestMapping("/delete")
	public void delete(String visitname) throws Exception{
		sb.delete(visitname);
	}
		
	@RequestMapping("/get")
	public SecurityBoxRecord get(String visitname) throws Exception{	
		return sb.getByVisitName(visitname);
	}
	
	@RequestMapping("/getall")
	public List<SecurityBoxRecord> getAll() throws Exception{	
		return sb.selectListByAll();
	}
	
	//按检索条件取得员工列表
	@GetMapping(value = "/list/condition/page")
	public ResultMessage<SecurityBoxRecord> getListByConditionWitPage(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date boxdate,@RequestParam(required = false,defaultValue ="0") Double dutyno, @RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<SecurityBoxRecord> result = new ResultMessage<SecurityBoxRecord>("OK","取得岗亭列表分页成功");
		result.setCount(sb.getCountByConditionWithBoxnoWithPage(boxdate, dutyno));
		
		result.setPageCount(sb.getPageCountByConditionWithBoxnoWithPage(boxdate, dutyno, rows));
		result.setList(sb.getListByConditionWithBoxWithPage(boxdate, dutyno, rows, page));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
	
	//验证员工ID是否存在，如果存在则不合法，不存在则合法，用于增加员工时检查ID是否已经存在
	@GetMapping(value="/checkidexist")
	public boolean checkIdExist(Double boxno) throws Exception{
		return !sb.checkIdExist(boxno);
	}
	
}
