package run.superMonkey.pm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import run.superMonkey.pm.model.entity.Area;
import run.superMonkey.pm.model.entity.Building;
import run.superMonkey.pm.model.entity.Room;


@Mapper
public interface RoomMapper {
	//c
	public void create(Room room) throws Exception;
	//u
	public void update(Room room) throws Exception;
	//d
	public void delete(Room room) throws Exception;
	//R  取得列表，不取关联对象，不分页
	public List<Room> selectListByAllWithoutPage() throws Exception;
}
