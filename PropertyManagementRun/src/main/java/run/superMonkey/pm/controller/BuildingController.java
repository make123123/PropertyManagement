package run.superMonkey.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.message.ResultMessage;
import run.superMonkey.pm.model.entity.Area;
import run.superMonkey.pm.model.entity.Building;
import run.superMonkey.pm.service.IAreaService;
import run.superMonkey.pm.service.IBuildingService;

@RestController
@RequestMapping(value="/building")
public class BuildingController {
	@Autowired
	private IBuildingService buildingService=null;
	
	//增加小区
		@RequestMapping("/add")
		public ResultMessage<Building> add(Building building) throws Exception {
			buildingService.register(building);
			//为楼宇配房间
			
			return new ResultMessage<Building>("OK","增加楼宇成功");
		}
		//修改小区
		@PostMapping("/modify")
		public ResultMessage<Building> modify(Building building) throws Exception {
			buildingService.modify(building);
			return new ResultMessage<Building>("OK","修改楼宇成功");
		}
		//删除小区
		@PostMapping("/delete")
		public ResultMessage<Building> delete(Building building) throws Exception {
			buildingService.delete(building);
			return new ResultMessage<Building>("OK","删除楼宇成功");
		}
		//取得指定的小区
		@GetMapping("/get")
		public Building getByBuildingno(Double buildingno) throws Exception{
			return buildingService.getByBuildingnoWithAreaBuildingTypeAndRooms(buildingno);
		}
		
		
		//取得所有的小区信息列表
		@GetMapping("/get/list")
		public List<Building> getListByAll() throws Exception{
			return buildingService.getListByAllWithoutPage(); //不取关联
		}
		
		//按检索条件取得员工列表
		@GetMapping(value="/list/condition/page")
		public ResultMessage<Building> getListByConditionWitPage(@RequestParam(required = false,defaultValue ="0") Double areaNo,@RequestParam(required = false,defaultValue ="0") Double buildingtypeNo,@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
			ResultMessage<Building> result=new ResultMessage<Building>("OK","取得楼宇列表分页成功");
			result.setCount(buildingService.getCountByConditionWithPage(areaNo,buildingtypeNo));
			result.setPageCount(buildingService.getPageCountByConditionWithAreaAndBuildingTypeAndRoomWithPage(areaNo,buildingtypeNo, rows));
			result.setList(buildingService.getListByConditionWithAreaAndBuildingtypeAndRoomNoWithPage(areaNo,buildingtypeNo, rows, page));
			result.setPage(page);
			result.setRows(rows);
			
			return result;
		}
		//验证小区areano是否存在，如果存在则不合法，不存在则合法，用于增加员工时检查areano是否已经存在
		@GetMapping(value="/checkbuildingnoexist")
		public boolean checkBuildingnoExist(Double buildingno) throws Exception{
			return !buildingService.checkBuildingnoExist(buildingno);
		}
}
