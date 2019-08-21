package run.superMonkey.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import run.superMonkey.pm.mapper.AreaMapper;
import run.superMonkey.pm.mapper.RoomMapper;
import run.superMonkey.pm.model.entity.Room;
import run.superMonkey.pm.service.IRoomService;

@Service
public class RoomServiceImpl implements IRoomService{

	@Autowired
	private RoomMapper roomMapper=null;
	@Override
	public List<Room> getListByAllWithoutPage() throws Exception {
		return roomMapper.selectListByAllWithoutPage();
	}

}
