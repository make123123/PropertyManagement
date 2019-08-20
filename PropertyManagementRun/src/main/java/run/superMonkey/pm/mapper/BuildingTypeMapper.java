package run.superMonkey.pm.mapper;

import java.util.List;

import run.superMonkey.pm.model.entity.Area;
import run.superMonkey.pm.model.entity.BuildingType;

public interface BuildingTypeMapper {
		//c
		public void create(BuildingType buildingType) throws Exception;
		//u
		public void update(BuildingType buildingType) throws Exception;
		//d
		public void delete(BuildingType buildingType) throws Exception;
		//R  取得列表
		public List<BuildingType> selectListByAll() throws Exception;
		//R  查询返回单个对象，一般根据表的主键字段值获取
		public Area selectByTypeno(Double typeno) throws Exception;
}
