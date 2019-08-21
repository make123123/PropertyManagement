package run.superMonkey.pm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import run.superMonkey.pm.model.entity.Area;
import run.superMonkey.pm.model.entity.Room;
import run.superMonkey.pm.service.IAreaService;
import run.superMonkey.pm.service.IRoomService;

@RestController
@RequestMapping(value="/room")
public class RoomController {
	@Autowired
	private IRoomService roomService=null;
	
	//取得所有的小区信息列表
			@GetMapping("/get/list")
			public List<Room> getListByAll() throws Exception{
				return roomService.getListByAllWithoutPage(); //不取关联
			}
}
