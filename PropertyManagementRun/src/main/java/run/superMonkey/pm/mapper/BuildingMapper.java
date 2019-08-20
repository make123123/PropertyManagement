package run.superMonkey.pm.mapper;

import java.util.List;

import run.superMonkey.pm.model.entity.Area;
import run.superMonkey.pm.model.entity.Building;

public interface BuildingMapper {
		//c
		public void create(Building building) throws Exception;
		//u
		public void update(Building building) throws Exception;
		//d
		public void delete(Building building) throws Exception;
		//R  取得列表
		public List<Building> selectListByAll() throws Exception;
		//R  查询返回单个对象，一般根据表的主键字段值获取
		public Area selectByBuildingno(Double buildingno) throws Exception;
}
