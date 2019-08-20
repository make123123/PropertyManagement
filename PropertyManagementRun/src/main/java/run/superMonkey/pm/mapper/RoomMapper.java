package run.superMonkey.pm.mapper;

import java.util.List;

import run.superMonkey.pm.model.entity.Area;
import run.superMonkey.pm.model.entity.Room;

public interface RoomMapper {
	//c
	public void create(Room room) throws Exception;
	//u
	public void update(Room room) throws Exception;
	//d
	public void delete(Room room) throws Exception;
	//R  取得列表
	public List<Room> selectListByAll() throws Exception;
	//R  查询返回单个对象，一般根据表的主键字段值获取
	public Room selectByRoomno(Double roomno) throws Exception;
}
