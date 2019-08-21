package run.superMonkey.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.BuildingType;
import run.superMonkey.pm.model.entity.Room;
import run.superMonkey.pm.service.IBuildingTypeService;
import run.superMonkey.pm.service.IRoomService;

@RestController
@RequestMapping(value="/buildingtype")
public class BuildingTypeController {
	@Autowired
	private IBuildingTypeService buildingTypeService=null;
	//取得所有的小区信息列表
	@GetMapping("/get/list")
	public List<BuildingType> getListByAll() throws Exception{
		return buildingTypeService.getListByAllWithoutPage(); //不取关联
	}
}
