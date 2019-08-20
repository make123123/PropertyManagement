package run.superMonkey.pm.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import run.superMonkey.pm.message.ResultMessage;
import run.superMonkey.pm.model.entity.Area;
import run.superMonkey.pm.service.IAreaService;



/*
 * 模块：HR 房产管理
 * Controller层：小区控制器Controller类
 * @Author: 陈钟豪
 */
@RestController
@RequestMapping(value="/area")
public class AreaController {
	
	@Autowired
	private IAreaService areaService=null;
	
	//增加小区
		@RequestMapping("/add")
		public ResultMessage<Area> add(Area area) throws Exception {
			areaService.register(area);
			return new ResultMessage<Area>("OK","增加员工成功");
		}
		//修改小区
		@PostMapping("/modify")
		public ResultMessage<Area> modify(Area area) throws Exception {
			areaService.modify(area);
			return new ResultMessage<Area>("OK","修改员工成功");
		}
		//删除小区
		@PostMapping("/delete")
		public ResultMessage<Area> delete(Area area) throws Exception {
			areaService.delete(area);
			return new ResultMessage<Area>("OK","删除员工成功");
		}
		//取得指定的小区
		@GetMapping("/get")
		public Area getByAreano(Double areano) throws Exception{
			return areaService.getByAreano(areano);
		}
		
		
		//取得所有的小区信息列表
		@GetMapping("/get/list")
		public List<Area> getListByAll() throws Exception{
			return areaService.getListByAllWithoutPage(); //不取关联
		}
		
		//按检索条件取得员工列表
		@GetMapping(value="/list/condition/page")
		public ResultMessage<Area> getListByConditionWitPage(@RequestParam(required = false,defaultValue ="") String  areaname,@RequestParam(required = false,defaultValue ="") String aaddress,@RequestParam(required = false,defaultValue ="") String developer,@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
			ResultMessage<Area> result=new ResultMessage<Area>("OK","取得员工列表分页成功");
			result.setCount(areaService.getCount(areaname, aaddress, developer));
			result.setPageCount(areaService.getPageCount(areaname, aaddress, developer, rows));
			result.setList(areaService.getListByConditionWithPage(areaname, aaddress, developer, rows, page));
			result.setPage(page);
			result.setRows(rows);
			
			return result;
		}
		//验证小区areano是否存在，如果存在则不合法，不存在则合法，用于增加员工时检查areano是否已经存在
		@GetMapping(value="/checkareanoexist")
		public boolean checkAreanoExist(Double areano) throws Exception{
			return !areaService.checkAreanoExist(areano);
		}
		
}
